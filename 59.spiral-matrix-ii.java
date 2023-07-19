/*
 * @lc app=leetcode id=59 lang=java
 *
 * [59] Spiral Matrix II
 */

// @lc code=start
class Solution {
    public int[][] generateMatrix(int n) {
        //假设你有一个机器人
        //目标是定义好边界
        //返回的list
        int[][] res = new int[n][n];
        
        //定义边界
        int upper = 0, lower = n - 1;
        int left = 0, right = n - 1;

        //需要填入矩阵的数字
        int num = 1;

        //定义方向
        while (num <= n * n){
            //在顶部从左向右移动
            if (upper <= lower){
                //在顶部从左到右移动, 是左闭右开 [left, right)
                for (int i = left; i <= right; i++){
                    res[upper][i] = num++;
                }
                //顶部向下移动一行
                upper++;
            }

            //在右边从上到下移动
            if (left <= right){
                //在右边从上到下移动, 是左闭右开 [upper, lower)
                for (int i = upper; i <= lower; i++){
                    res[i][right] = num++;
                }
                //右边向左移动一行
                right--;
            }

            //在底部从右到左移动
            if (upper <= lower){
                //在底部从左向右移动, 是左闭右开 [right, left)
                for (int i = right; i >= left; i--){
                    res[lower][i] = num++;
                } 
                //底部向上移动一行
                lower--;
            }

            //在左边从下到上移动
            if (left <= right){
                //在左边从下到上移动, 是左闭右开 [lower, upper)
                for (int i =  lower; i >= upper; i--){
                    res[i][left] = num++;
                }
                //左边向右移动一行
                left++;
            }
        }
        return res;
    }
}
// @lc code=end

