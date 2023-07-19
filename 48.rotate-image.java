/*
 * @lc app=leetcode id=48 lang=java
 *
 * [48] Rotate Image
 */

// @lc code=start
class Solution {
    public void rotate(int[][] matrix) {
        //思路： 进行镜像对称， 再进行翻转
        int n = matrix.length;

        //镜像对称
        for (int i = 0; i < n; i++){
            for (int j = i; j < n; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        //反转二维矩阵的每一行
        for (int[] row : matrix){
            reverse(row);
        }
    }

    void reverse(int[] arr){
        int i = 0;
        int j = arr.length - 1;
        while (i < j){
            int temp = arr[i];
            arr[i++] = arr[j];
            arr[j--] = temp;
        }
    }
}
// @lc code=end

