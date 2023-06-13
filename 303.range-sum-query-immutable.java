/*
 * @lc app=leetcode id=303 lang=java
 *
 * [303] Range Sum Query - Immutable
 */

// @lc code=start
class NumArray {

    private int[] prenums;
    public NumArray(int[] nums) {
        prenums = new int[nums.length + 1];
        prenums[0] = 0;
    for (int i = 1; i < nums.length + 1; i++){
        prenums[i] = prenums[i - 1] + nums[i -1]; 
    }
}
    
    public int sumRange(int left, int right) {
        return prenums[right + 1] - prenums[left];
    }

    //案例：你们班上有若干同学，每个同学有一个期末考试的成绩（满分 100 分），
    //那么请你实现一个 API，输入任意一个分数段，返回有多少同学的成绩在这个分数段内。
    //比如输入 60-80，返回 8。
    // int []scores; //给出的一个分数的列表
    // int []count = new int[100 + 1];
    
    // //统计每个分数的人数
    // for (int scrore : scores){
    //     scores[scrore]++;
    // }

    // //统计每个分数段的人数
    // count[0] = 0;
    // for (int i = 1; i < account.length; i++){
    //     count[i] = count[i -1] + scores[i];
    // }

    // public int count(int left, int right){
    //     return count[right + 1] - count[left];
    // }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
// @lc code=end

