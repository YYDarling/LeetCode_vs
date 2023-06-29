/*
 * @lc app=leetcode id=1109 lang=java
 *
 * [1109] Corporate Flight Bookings
 */

// @lc code=start
class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        if (bookings == null || bookings.length == 0 || bookings[0].length == 0){
            return new int[0];
        }
        //思路：差分数组
        //nums 初始化为0
        int [] nums =  new int[n];
        
        //构造差分数组
        int [] diff = new int[n];
        diff[0] = 0;
        for (int i =  1; i < nums.length; i++){
            diff[i] = nums[i] - nums[i - 1];
        } 
        //根据题目给的bookings数组，对差分数组进行相应的操作
        for (int i = 0; i < bookings.length; i++){
            int left = bookings[i][0] - 1;   //flight label是从1开始的，而数组是从0开始的，所以要减1
            int right = bookings[i][1] - 1;
            int seats = bookings[i][2];
            
            //差分数组的操作
            diff[left] += seats;
            if (right + 1 < n){
                diff[right + 1] -= seats;
            }

            //根据差分数组构造nums数组
            nums[0] = diff[0];
            for (int j = 1 ; j < nums.length; j++){
                nums[j] = nums[j -1] + diff[j];
            }
        }
        return nums;
    }
}
// @lc code=end

