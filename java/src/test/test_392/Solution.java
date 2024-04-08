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
    //最后的权取决于整个连通图的dfs &
    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        List<int[]>[] map = new List[n];//边图, 一个点一个权
        Arrays.setAll(map, i->new ArrayList<>());
        for(int[] e: edges){
            map[e[0]].add(new int[]{e[1],e[2]});
            map[e[1]].add(new int[]{e[0],e[2]});
        }
        int[] record = new int[n];//记录点所在连通图编号
        Arrays.fill(record, -1);
        List<Integer> curAnd = new ArrayList<>();//记录每个连通图与值
        for(int i = 0;i<n;++i){
            if(record[i]==-1)
                curAnd.add(dfs(i,curAnd.size(),record,map));
        }
        int[] ans = new int[query.length];
        for(int i = 0;i<ans.length;++i){
            if(record[query[i][0]]!=record[query[i][1]])
                ans[i] = -1;
            else{
                ans[i] = curAnd.get(record[query[i][0]]);
                if(query[i][0] == query[i][1])
                    ans[i] = 0;
            }
                
        }
        return ans;
    }
    public int dfs(int index, int cur, int[] record, List<int[]>[] map){
        int res = -1;
        record[index] = cur;
        for(int arr[]: map[index]){
            res &= arr[1];
            if(record[arr[0]]!=-1)
                continue;
            res &= dfs(arr[0],cur,record,map);
        }
        return res;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        s.minimumCost(3,new int[][]{{0,2,7},{0,1,15},{1,2,6},{1,2,1}},new int[][]{{2,1}});
    }
}
