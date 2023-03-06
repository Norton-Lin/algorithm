package leetcode_1653;

class Solution {
    //b字符都在a字符之后
    //前后dp,原本需要三次一轮遍历,两个长度为n的数组空间，时间复杂度O(n),空间复杂度O(n)
    //优化，两次一轮遍历，一个长度为n的数字空间，时间复杂度O(n),空间复杂度O(n)
    /** 
    public int minimumDeletions(String s) {
        int[] dp = new int[s.length()];
        int ans = s.length(), cur =0;
        for(int i = s.length()-1;i>=0;--i)
        {
            dp[i] = cur;
            if(s.charAt(i) == 'a')
                ++cur;
        }
        cur = 0;
        for(int i = 0;i<s.length();++i)
        {
            if(ans>cur+dp[i])
                ans = cur+dp[i];
            if(s.charAt(i) == 'b')
                cur++;
        }
        return ans;
    }
    */
    //再优化,当正数第i位是b,问题转化为 minimumDeletions(s.substring(i))+1)
    public int minimumDeletions(String s){
        //ans统计到第i位时的最少删除次数
        //cur统计到第i位时，b的数量
        /**
            1.状态定义:
                dp[i]: 0~i的需要的最少删除次数
            2.状态转移:
                2.1. cs[i] == 'b'时, 不需要动
                    dp[i] = dp[i-1] 
                2.2. cs[i] == 'a'时, 选择i之前的所有的b删除，或者把i删除
                    dp[i] = Math.min(sumb, dp[i-1] + 1);
         */ 
        int ans = 0,cur = 0;
        for(char c : s.toCharArray())
        {
            if(c == 'b')
                ++cur;
            else
                ans = Math.min(ans+1,cur);
        }
        return ans;
    }
}