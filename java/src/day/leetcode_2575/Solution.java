package day.leetcode_2575;
/*
 * @lc app=leetcode.cn id=2575 lang=java
 *
 * [2575] 找出字符串的可整除数组
 */
// @lc code=start
class Solution {
    //  word[0,...,i] 所表示的 数值 能被 m 整除，div[i] = 1
    //  若i位可整除，div[j]只要看i+1...j位，
    //  进一步优化只要看 (i+1...j-1)mod m*10+word[j]
    public int[] divisibilityArray(String word, int m) {
        int n = word.length();
        int[] ans = new int[n];
        long cur = 0;
        for(int i = 0;i<n;++i){
            cur = (cur*10+(word.charAt(i)-'0'))%m;
            if(cur == 0)
                ans[i] = 1;
        }   
        return ans;
    }
}
// @lc code=end

