package leetcode_1605;

class Solution {
    //非负矩阵，满足行列和
    //这怎么感觉跟填数独一样
    //贪心 ans[i][j] = min(rowSum[i],colSum[i])
    //回溯也行 从min(rowSum[i],colSum[i])开始
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int[][] ans = new int[rowSum.length][colSum.length];
        for(int i = 0;i<rowSum.length;++i)
        {
            for(int j =0;j<colSum.length;++j)
            {
                ans[i][j] = Math.min(rowSum[i],colSum[j]);
                rowSum[i] -= ans[i][j];
                colSum[j] -= ans[i][j];
                if(rowSum[i]<colSum[j])
                    break;
            }
        }
        return ans;
    }
}
