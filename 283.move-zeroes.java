/*
 * @lc app=leetcode id=283 lang=java
 *
 * [283] Move Zeroes
 */

// @lc code=start
class Solution {
    public void moveZeroes(int[] nums) {
        /*
         * 方法：双指针法
         * 1. 就和去重是一样的， 只不过这里是把非0的数往前移动
         */
        int slow = 0, fast = 0;
        while (fast < nums.length){
            if (nums[fast] != 0){
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        // 把后面的数都置为0
        while (slow < nums.length){
            nums[slow] = 0;
            slow++;
        }
    }
}
// @lc code=end

