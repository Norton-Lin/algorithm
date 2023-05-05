package leetcode_2342;

class Solution {
    public int hardestWorker(int n, int[][] logs) {
        int ret = logs[0][0],max = logs[0][1];
        int cur = logs[0][1];
        for(int i = 1;i<logs.length;++i)
        {
            cur=logs[i][1] - logs[i-1][1];
            if(cur>max||(cur == max&&logs[i][0]<ret))
            {
                max = cur;
                ret = logs[i][0];
            }
        }
        return ret;
    }
}
