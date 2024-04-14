package test.test_2_128;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public int scoreOfString(String s) {
        int ans = 0;
        char[] arr = s.toCharArray();
        for (int i = 1; i < arr.length; ++i) {
            ans += Math.abs(arr[i] - arr[i - 1]);
        }
        return ans;
    }

    // 矩形宽度是w,0就是一条线
    // 所以w表示连续的几条线
    // 线的高度取决于右端最高点
    //到最高点就停
    public int minRectanglesToCoverPoints(int[][] points, int w) {
        int ans = 1;
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b){
                if(a[0]!=b[0])
                    return a[0] - b[0];
                return a[1] - b[1];
            }
        });
        int cur = points[0][0];
       for(int i = 0;i<points.length;++i){
            if( points[i][0] - cur>w){
                cur = points[i][0];
                ++ans;
            }
                
        }
        return ans;
    }
    //从0出发 最少时间到达某些点
    //计算到某些点的最少时间
    //但是某些点可能会消失
    //如果某些点消失了，要从图中去除
    public int[] minimumTime(int n, int[][] edges, int[] disappear) {
        Set<Integer> set = new HashSet<>();
        int[] ans = new int[n];
        List<int[]>[] map = new List[n];
        Arrays.setAll(map, i->new ArrayList<>());
        for(int[] e:edges){
            map[e[0]].add(new int[]{e[1],e[2]});
            map[e[1]].add(new int[]{e[0],e[2]});
        }
        set.add(0);
        dfs(set, map,disappear,ans);
    }
    public void dfs(Set<Integer> set,List<int[]>[] map, int[] disappear, int[] ans){
        for(int i:set){
            for(int e[]:map[i]){
                int num = ans[i] + e[1];
                if(num<disappear[e[0]]){//没过期
                    ans[e[0]] = Math.min(ans[e[0]],num);
                    set.add(e[0]);
                }
                    
                else
                    if(ans[e[0]]==0&&e[0]!=0)
                        ans[e[0]] = -1;

            }
        }
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        s.minRectanglesToCoverPoints(new int[][] { {2,1},{1,0},{1,4},{1,8},{3,5},{4,6} }, 1);
    }
}
//{2,1},{1,0},{1,4},{1,8},{3,5},{4,6}
