/*
 * @lc app=leetcode id=54 lang=java
 *
 * [54] Spiral Matrix
 */

// @lc code=start

import java.util.List;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        //假设你有一个机器人
        //目标是定义好边界
        int row = matrix.length;
        int col = matrix[0].length;

        //返回的list
        List<Integer> res = new ArrayList<>();

        //定义边界
        int upper = 0, lower = row - 1;
        int left = 0, right = col - 1;

        //定义方向
        while (res.size() < row * col){
            //在顶部从左向右移动
            if (upper <= lower){
                //在顶部从左向右移动, 是左闭右开 [left, right)
                for (int i = left; i <= right; i++){
                    res.add(matrix[upper][i]);
                }
                //顶部向下移动一行
                upper++;
            }

            //在右边从上向下移动
            if (left <= right){
                //在右边从上向下移动, 是左闭右开 [upper, lower)
                for (int i = upper; i <= lower; i++){
                    res.add(matrix[i][right]);
                }
                //右边向左移动一行
                right--;
            }

            //在底部从右向左移动
            if (upper <= lower){
                //在底部从右向左移动, 是左闭右开 [right, left)
                for (int i = right; i >= left; i--){
                    res.add(matrix[lower][i]);
                }
                //底部向上移动一行
                lower--;
            }

            //在左边从下向上移动
            if (left <= right){
                //在左边从下向上移动， 是左闭右开 [lower, upper)
                for (int i = lower; i >= upper; i--){
                    res.add(matrix[i][left]);
                }
                //左边向右移动一行
                left++;
            }
        }
        return res;

    }
}
// @lc code=end

