/*
 * @lc app=leetcode id=26 lang=java
 *
 * [26] Remove Duplicates from Sorted Array
 */

// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {
        /*
         * 方法：双指针法
         */
        //特殊情况
        if (nums.length == 0) return 0;
        //
        int slow = 0, fast = 1;
        while (fast < nums.length){
            if (nums[slow] != nums[fast]){
                //先运行slow++，再赋值, 因为要先把位置空出来
                    slow++;
                    nums[slow] = nums[fast];
            }
            fast++;
        }
        return slow + 1;
    }
}
// @lc code=end

