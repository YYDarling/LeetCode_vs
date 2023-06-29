/*
 * @lc app=leetcode id=151 lang=java
 *
 * [151] Reverse Words in a String
 */

// @lc code=start
class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        // 先清洗一下数据，把多于的空格都删掉
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (c != ' '){
                sb.append(c);
            }else if (!sb.isEmpty() && sb.charAt(sb.length() - 1) != ' '){
                sb.append(' ');  
                //单词间隔只保留一个空格: sb.charAt(sb.length() - 1) != ' '
                //前提是sb不为空
            }
        }
        // 如果清洗后的字符串为空，直接返回空字符串
        if (sb.isEmpty()) return ""; 
        //如果末尾有空格， 清楚他
        if (sb.charAt(sb.length() - 1) == ' '){
            sb.deleteCharAt(sb.length() - 1);
        }

        //清洗之后的字符串转换成char字符数组
        char[] arr = sb.toString().toCharArray();
        //整个字符串反转
        reverse(arr, 0, arr.length - 1);

        //单词反转
        for (int i = 0; i < arr.length;){
            for (int j = i; j < arr.length; j++){
                if (j + 1 == arr.length || arr[j + 1] == ' '){
                    //char[i..j] 是一个单词， 反转
                    reverse(arr, i, j);
                    //把i 移动到下一个单词的开头
                    i = j + 2; //跳过空格
                    break;
                }
            }
        }
        //最后把char数组转换成字符串
        return new String(arr);
    }

    //reverse the char array
    void reverse(char[] arr, int start, int end){
        while (start < end){
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start ++;
            end --;
        }
    }
}
// @lc code=end

