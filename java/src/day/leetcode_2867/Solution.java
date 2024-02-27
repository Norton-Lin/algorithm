package day.leetcode_2867;
/*
 * @lc app=leetcode.cn id=2867 lang=java
 *
 * [2867] 统计树中的合法路径数目
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;
class Solution {
    //节点变号中有且仅有一个质数，路径合法
    //自顶向下dfs 统计每个节点到根的质数数量
    //到根质数为零，那就是可能路径组合数* 
    //质数判断 欧拉筛
    private static final int len = 100001;
    private static boolean[] is_prime = new boolean[len];
    //静态加速，免调用
    static{
        int count = 0;//质数数量
        int[] prime = new int[len];
        is_prime[0] = true;
        is_prime[1] = true;
        for(int i = 2;i<len;++i){
            //是质数
            if(!is_prime[i]){
                prime[count] = i;
                ++count;
            }
            //合数
            for(int j = 0;j<count&&i*prime[j]<len;++j){
                is_prime[prime[j]*i] = true;
                if(i%prime[j] == 0)
                    break;
            }
        }

    }
    public long countPaths(int n, int[][] edges) {
        List<Integer> list[] = new ArrayList[n+1];
        for(int i = 0;i<=n;++i){
            list[i] = new ArrayList<>();
        }
        //建立互联关系
        for(int[] edge:edges){
            int i = edge[0],j = edge[1];
            list[i].add(j);
            list[j].add(i);
        }
        List<Integer> seen = new ArrayList<>();
        long ans = 0;
        long[] count = new long[n+1];
        for(int i = 1;i<=n;++i){
            //合数，继续
            if(is_prime[i])
                continue;
            long cur = 0;
            //找到质数点
            for(int j:list[i]){
                //找和该质数点直接相连的合数点
                if(!is_prime[j])
                    continue;
                //合数点没有被计算过子树数量
                if(count[j] == 0){
                    seen.clear();
                    dfs(list, seen,j,0);
                    long cnt = seen.size();
                    for(int k: seen){
                        count[k] = cnt;
                    }
                }
                //子树相乘
                ans += count[j] * cur;
                cur += count[j];
            }
            //仅达质数节点
            ans += cur;
        }
        return ans;
    }
    //连通分量内，不经过质数有多少路径
    public void dfs(List<Integer>[] list, List<Integer> seen, int i, int pre){
        seen.add(i);
        for(int j:list[i]){
            if(j != pre&&is_prime[j])
                dfs(list, seen, j,i);
        }
    }
}
// @lc code=end

