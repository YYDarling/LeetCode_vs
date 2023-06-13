/*
 * @lc app=leetcode id=304 lang=java
 *
 * [304] Range Sum Query 2D - Immutable
 */

// @lc code=start
class NumMatrix {

    //定义： presum[i][j] 为从(0,0)到(i -1,j- 1)的矩形的和
    private int[][] presum;
    public NumMatrix(int[][] matrix) {
        int m = matrix.length; //行数
        int n = matrix[0].length; //列数
        if (m == 0 || n == 0) return;

        //初始化, 构造presum数组
        presum = new int[m + 1][n + 1];
        presum[0][0] = 0;
        for (int i = 1; i < presum.length; i++){
            for (int j = 1; j < presum[0].length;j++){
                //s = s1 + s2 + s3 + s4
                //s1 = presum[i - 1][j - 1]
                //s2 = presum[i - 1][j]
                //s3 = presum[i][j - 1]
                //s4 = matrix[i - 1][j - 1]
                //现在s4, 使用
                //s4 =  s - (s1 + s3) - (s2 + s1) + s1
                presum[i][j] = presum[i-1][j] + presum[i][j - 1] 
            }
        }
        
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
// @lc code=end

