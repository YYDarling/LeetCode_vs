/*
 * @lc app=leetcode id=567 lang=java
 *
 * [567] Permutation in String
 */
import java.util.HashMap;

// @lc code=start
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap <Character, Integer> need = new HashMap<>();
        HashMap <Character, Integer> window = new HashMap<>();

        //注意这道题， 元素是可以重复的，所以需要记录每个元素的个数
        for (char c : s1.toCharArray()){
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int valid = 0;

        while (right < s2.length()){
            char c = s2.charAt(right);

            //窗口右移， 左开右闭
            right++;

            //更新窗口内数据
            if (need.containsKey(c)){
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))){
                    valid++;
                }
            }

            //判断左侧窗口是否要收缩
            //这道题的不同之处就在这里，因为元素可以重复，所以需要判断是否找到了合法的子串
            //而不是判断窗口内元素个数是否等于s1.length()
            //这里的判断条件是，窗口大小大于等于s1.length()
            //这里的窗口大小是right - left，因为左开右闭，所以是大于等于
            while (right - left >= s1.length()){   
                //判断是否找到了合法的子串
                if (valid == need.size()){
                    return true;
                }
                //窗口左移， 左开右闭
                char d = s2.charAt(left);
                left++;
                //更新窗口内数据
                //这里的更新窗口内数据和上面的更新窗口内数据是一样的
                if(need.containsKey(d)){
                    if (window.get(d).equals(need.get(d))){
                        valid--;
                    }
                    window.put(d, window.getOrDefault(d, 0) - 1);
                }
            }
        }
        return false;
    }
}
// @lc code=end

