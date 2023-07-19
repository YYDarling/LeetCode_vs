/*
 * @lc app=leetcode id=875 lang=java
 *
 * [875] Koko Eating Bananas
 */

// @lc code=start
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        //珂珂吃香蕉的速度就是自变量 x
        //吃香蕉的速度越快，吃完所有香蕉堆所需的时间就越少，
        //速度和时间就是一个单调函数关系
        //吃香蕉的速度为 x 根/小时，则需要 f(x) 小时吃完所有香蕉

        //题目说了 1 <= piles[i] <= 10^9，
        //那么我就可以确定二分搜索的区间边界
        //最小速度应该是 1，最大速度是 piles 数组中元素的最大值
        //1 <= piles[i] <= 109，所以最大值是 109
        int left = 1, right = 1000000000 + 1;
        //确定了自变量 x 是吃香蕉的速度，f(x) 是单调递减的函数，
        //target 就是吃香蕉的时间限制 H，题目要我们计算最小速度，也就是 x 要尽可能小
        //搜索左侧边界的二分搜索嘛
        //注意单调递减
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (f(piles, mid) == h) right = mid - 1;
            else if (f(piles, mid) > h) left = mid + 1; 
            else if (f(piles, mid) < h) right = mid - 1;
        }
        return left;
        
    }

    // 定义：速度为 x 时，需要 f(x) 小时吃完所有香蕉
    // f(x) 随着 x 的增加单调递减
    long f(int[] piles, int x){
        long hours = 0;
        for (int i = 0; i < piles.length; i++){
            hours += piles[i] / x;
            //3除以8 也算是 1
            if (piles[i] % x > 0) hours++;
        }
        return hours;
    }


}
// @lc code=end

