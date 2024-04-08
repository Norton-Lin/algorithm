package test.test_392;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int[] dp = new int[nums.length];
        int ans = 1;
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] < nums[i - 1])
                dp[i] = dp[i - 1] + 1;
            else
                dp[i] = 1;
            ans = Math.max(dp[i], ans);
        }
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] > nums[i - 1])
                dp[i] = dp[i - 1] + 1;
            else
                dp[i] = 1;
            ans = Math.max(dp[i], ans);
        }
        return ans;
    }

    // 对s的字典序差值小于等于k
    public String getSmallestString(String s, int k) {
        char[] t = s.toCharArray();
        int index = 0;
        int value = 0;
        while (k > 0 && index < t.length) {
            value = Math.min(t[index] - 'a', 'z' + 1 - t[index]);
            if (k >= value) {
                k -= value;
                t[index] = 'a';
            } else {
                t[index] -= k;
                k = 0;
            }
            ++index;

        }
        return new String(t);
    }
    // 中位数变成k
    // 设原本的中位数为t
    // 若k>t ,比k大，比t小的不动
    // 若k<t ,比k小，比t大的不动

    public long minOperationsToMakeMedianK(int[] nums, int k) {
        long ans = 0;
        Arrays.sort(nums);
        int n = nums.length;
        int index = n / 2;// 中位数下标
        int t = nums[index];// 当前中位数
        if (t == k)
            return ans;
        else if (k > t) {
            for (int i = index;  i < n&&nums[i] < k;  ++i)
                ans += k - nums[i];
        } else {
            for (int i = index; i >= 0&&nums[i] > k; --i)
                ans += nums[i] - k;
        }
        return ans;
    }
    //带权图
    //最后的权取决于途径的最低权
    //无环路径，取决于最低权，找连通图里的最小
    //有环路径，走有最低权的,然后绕一圈
    //带环的直接与
    //找连通图里的最小
    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        int[] ans = new int[query.length];
        int[] record = new int[n];
        int[][] map = new int[n][n];
        List<Integer> list = new ArrayList<>();
        Arrays.fill(record, -1);
        int cur = 0;
        for(int i = 0;i<n;++i)
            Arrays.fill(map[i],-1);
        for(int[] edge:edges){
            if(map[edge[0]][edge[1]] == 0){
                map[edge[0]][edge[1]] = edge[2];
                map[edge[1]][edge[0]] = edge[2];
            }
                
            else{
                map[edge[0]][edge[1]] = map[edge[0]][edge[1]]&edge[2];
                map[edge[1]][edge[0]] = map[edge[1]][edge[0]]&edge[2];
            }       
        }
        for(int i = 0;i<n;++i){
            if(record[i]!=-1)//已存在于连通图中
                continue;
            record[i] = list.size();
            cur = dfs(i,map, record, list.size(), n);
            list.add(cur);
        }
        for(int i = 0;i<query.length;++i){
            if(record[query[i][0]] == record[query[i][1]])
                ans[i] = list.get(record[query[i][0]]);
            else
                ans[i] = -1;
        }
        return ans;
    }
    public int dfs(int index,int[][] map, int[] record, int num,int n){
        int ans = 100000;
        for(int i = 0;i<n;++i){
            if(map[index][i]!=-1){//有路径
                if(record[i]==-1){//不在连通图中
                    record[i] = num;
                    ans = Math.min(map[index][i],ans&map[index][i],);
                    int res = dfs(i,map,record,num,n);
                    ans = Math.min(res,ans&ans);
                }
            } 
        }
        return ans;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        s.minimumCost(3,new int[][]{{1,0,4},{0,2,5},{0,2,3},{0,2,14},{0,2,12},{2,0,14},{0,2,4}},new int[][]{{2,1}});
    }
}
