package day.leetcode_2611;

import java.util.Arrays;

class Solution {
    //dp dp[i][j] 第i个奶酪，是第一只老鼠吃的第j块
    //贪心+排序
    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        int ans = 0;
        Integer[] value = new Integer[reward1.length];
        for(int i = 0;i<reward1.length;++i)
            value[i] = reward1[i] - reward2[i];
        Arrays.sort(value,(o1,o2)->(o2-o1));
        int target = Integer.MAX_VALUE;
        if(k>0)
            target = value[k-1];
        int count = 0;
        for(int i = 0;i<value.length;++i)
        {
            if(reward1[i] - reward2[i]>=target)
            {
                ans+=reward1[i];
                ++count;
                if(count>k)
                    ans-=target;
            }
            else
                ans+=reward2[i];
            //System.out.println(ans);
        }
        return ans;
    }
}
/**
 */