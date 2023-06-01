/*
 * @lc app=leetcode id=27 lang=java
 *
 * [27] Remove Element
 */

// @lc code=start
class Solution {
    public int removeElement(int[] nums, int val) {
        /*
         * 方法：双指针， 和26题很像
         */
        //特殊情况
        if (nums.length == 0)return 0;
        //定义两个指针
        int slow = 0, fast = 0;
        while (fast < nums.length){
            if (nums[fast] != val){
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
}
// @lc code=end

