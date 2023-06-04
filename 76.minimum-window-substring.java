/*
 * @lc app=leetcode id=76 lang=java
 *
 * [76] Minimum Window Substring
 */

// @lc code=start

import java.util.HashMap;

import javax.xml.stream.events.Characters;

class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();

        // init need
        for (char c : t.toCharArray()){
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        // init window
        int left = 0, right = 0;
        int valid = 0; //窗口中满足need条件的字符个数

        // 记录最小覆盖子串的起始索引及长度
        int start = 0, len = Integer.MAX_VALUE;

        // 开始滑动
        while (right < s.length()){ //字符串，length要加括号
            // c 是将移入窗口的字符
            char c = s.charAt(right);
            // 右移窗口
            right++;  //左闭右开区间

            // 进行窗口内数据的一系列更新
            if (need.containsKey(c)){
                window.put(c, window.getOrDefault(c, 0)+ 1);
                // 这里不能用==，因为Integer是对象，==比较的是地址
                // 用equals比较的是值
                // 用==比较的是地址
                if (window.get(c).equals(need.get(c))){
                    // 字符c的出现次数符合要求了
                    valid++;
                }
            }

            // 判断左侧窗口是否要收缩
            while (valid == need.size()){
                // 在这里更新最小覆盖子串
                if (right - left < len){
                    start = left;
                    len = right - left; //因为是开区间， 所以就是right - left
                }
                
                // d 是将移出窗口的字符
                char d = s.charAt(left);
                // 左移窗口
                left++;

                // 进行窗口内数据的一系列更新
                if (need.containsKey(d)){
                    // 这里不能用==，因为Integer是对象，==比较的是地址
                    if (window.get(d).equals(need.get(d))){
                        valid --;
                    }
                    // 这里不用减1，因为上面已经减过了
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        // 返回最小覆盖子串
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }
}
// @lc code=end

