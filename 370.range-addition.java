/*
 * @lc app=leetcode id=370 lang=java
 *
 * [370] Range Addition
 */

// @lc code=start
class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        //构造nums数组， 初始化为0
        int [] nums = new int[length];

        //构造差分方程数组
        int [] diff = new int[length];
        diff[0] = nums[0]; 
        for (int i = 1; i < nums.length; i++){
            diff[i] = nums[i] - nums[i - 1];
        }

        //根据差分方程数组，更新nums数组
        for (int i = 0; i < updates.length; i++){
            int left = updates[i][0];
            int right = updates[i][1];
            int val = updates[i][2];
            
            //进行区别的加减， 在diffrent 上
            diff[left] += val;
            if (right + 1 < diff.length) {
                diff[right + 1] -= val;
            }

            //返回结果的数组
            nums[0] = diff[0];
            for (int j = 1; j < nums.length; j++){
                nums[j] = nums[j - 1] + diff[j];
            }
        }
        return nums;
    }
}
// @lc code=end

