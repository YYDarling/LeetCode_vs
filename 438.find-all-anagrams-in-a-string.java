/*
 * @lc app=leetcode id=438 lang=java
 *
 * [438] Find All Anagrams in a String
 */

// @lc code=start
import java.util.HashMap;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        HashMap<Character,Integer> need = new HashMap<>();
        HashMap<Character,Integer> window = new HashMap<>();

        for (char c : p.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int valid = 0;

        List<Integer> res = new ArrayList<>();  // 记录结果

        while (right < s.length()){
            char c = s.charAt(right);
            right++;

            // 进行窗口内数据的一系列更新
            if (need.containsKey(c)){
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))){
                    valid++;
                }
            }
            // 判断左侧窗口是否要收缩
            while (right - left >= p.length()){
                // 当窗口符合条件时，把起始索引加入 res
                if (valid == need.size()){
                    res.add(left);
                }

                //要删除的元素
                char d = s.charAt(left);
                left++;

                // 进行窗口内数据的一系列更新
                if (need.containsKey(d)){
                    
                    if (window.get(d).equals(need.get(d))){
                        valid--;
                    }

                    window.put(d, window.getOrDefault(d, 0) - 1);
                }
            }
        }
        return res;
    }
}
// @lc code=end

