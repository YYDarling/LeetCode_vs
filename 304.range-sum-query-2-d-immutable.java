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
        int row = matrix.length; //行数
        int col = matrix[0].length; //列数
        if (row == 0 || col == 0) return;

        //初始化, 构造presum数组
        presum = new int[row + 1][col + 1];
        presum[0][0] = 0;
        for (int i = 1; i < presum.length; i++){
            for (int j = 1; j < presum[0].length;j++){
                //s = s2 + s3 + s4 -s1
                //s1 = presum[i - 1][j - 1]
                //s2 = presum[i - 1][j]
                //s3 = presum[i][j - 1]
                //s4 = matrix[i - 1][j - 1]
                // 计算每个矩阵【0， 0， i， j】的元素和
                presum[i][j] = presum[i-1][j] + presum[i][j - 1] + matrix[i - 1][j - 1] - presum[i - 1][j - 1];
            }
        }
        
    }
    
    //计算子矩阵[x1, y1, x2, y2]的和
    public int sumRegion(int row1, int col1, int row2, int col2) {
        //目标矩阵的和由四个相邻矩阵的运算得到
        return presum[row2 + 1][col2 + 1] - presum[row1][col2 + 1] - presum[row2 + 1][col1] + presum[row1][col1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
// @lc code=end

