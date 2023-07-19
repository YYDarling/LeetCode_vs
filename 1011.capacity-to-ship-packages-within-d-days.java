/*
 * @lc app=leetcode id=1011 lang=java
 *
 * [1011] Capacity To Ship Packages Within D Days
 */

// @lc code=start
class Solution {
    public int shipWithinDays(int[] weights, int days) {
        //船的最小载重应该是 weights 数组中元素的最大值，
        //因为每次至少得装一件货物走，不能说装不下嘛
        //最大载重显然就是weights 数组所有元素之和，也就是一次把所有货物都装走
        int left = 0, right = 1;
        for (int w : weights){
            left = Math.max(left, w);
            right += w;
        }

        while (left <= right){
            int mid = left + (right - left) / 2;
            if (f(weights, mid) == days){
                //搜索左侧边界， 则需要收缩右侧边界, 求最大承载能力
                right = mid - 1;
            }else if (f(weights, mid) < days){
                //需要让f(x) 的返回值大一些
                right = mid - 1;
            }else if (f(weights, mid) > days){
                //需要让f(x) 的返回值小一些
                left = mid + 1;
            }
        }
        return left;
    }
    
    //1、确定 x, f(x), target 分别是什么，并写出函数 f 的代码
    //2、确定二分搜索的左右边界
    //3、确定 while 循环的条件
    //x : 运载能力
    //f(x) : 在运载能力为 x 的情况下，需要几天运完所有货物
    //target : D days
    //反比

    int f(int[] weights, int x){
        int days = 0;
        for (int i = 0; i < weights.length;){
            int cap = x; 
            while (i < weights.length){
                if (cap < weights[i]) break;
                else cap -= weights[i];  
                //这里用减法，不用除法，因为除法会有精度问题
                i++;
            }
            days ++;
        }
        return days;
    }
}
// @lc code=end

