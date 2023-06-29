/*
 * @lc app=leetcode id=1094 lang=java
 *
 * [1094] Car Pooling
 */

// @lc code=start
class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        //1 <= trips.length <= 1000
        //1 <= capacity <= 105
        //差分数组
        int [] nums = new int[1001];
        int [] diff = new int[1001];
        diff[0] = 0;

        for (int i = 1; i < nums.length; i++){
            diff[i] = nums[i] - nums[i - 1];
        }

        //开始大循环
        for (int i = 0; i < trips.length; i++){
            //第[i][1] 上车
            int start = trips[i][1];
            //第[i][2] 已经下车
            //所以乘客在车上的区间是第[i][2] - 1
            int end = trips[i][2] - 1;
            //第[i][0] 乘客数量
            int val = trips[i][0];
            diff[start] += val;
            if (end + 1 < nums.length) diff[end + 1] -= val;

            //开始小循环
            nums[0] = diff[0];
            for (int j = 1; j < nums.length; j++){
                nums[j] = nums[j-1] + diff[j];
            }
        }

        for (int j = 0; j < nums.length;j++){
            if (nums[j] > capacity) return false;
        }

        return true;

    }
}
// @lc code=end

