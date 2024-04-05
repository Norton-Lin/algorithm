package day.leetcode_2192;
/*
 * @lc app=leetcode.cn id=2192 lang=java
 *
 * [2192] 有向无环图中一个节点的所有祖先
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
// @lc code=start
class Solution {
    //找所有节点的祖先
    //即找可达某节点的所有节点
    //a是b的祖先，那么a的祖先也是b的祖先
    //并查集
    //暴力弗洛伊德
    /**
    public List<List<Integer>> getAncestors(int n, int[][] edges){
        List<List<Integer>> ans = new ArrayList<>();
        int[][] record = new int[n][n];
        for(int i = 0;i<n;++i){
            ans.add(new ArrayList<>());
            Arrays.fill(record[i], n);
            //record[i][i] = true;
        }
        for(int[] edge: edges){
            record[edge[0]][edge[1]] = 1;
        }
        for(int i = 0;i<n;++i){
            for(int j = 0;j<n;++j){
                for(int k = 0;k<n;++j){
                    record[i][j] = Math.min(record[i][j],record[i][k]+record[k][j]);
                }
            }
        }
        for(int i = 0;i<n;++i){
            for(int j = 0;j<n;++j){
                if(record[j][i]<n)
                    ans.get(j).add(i);
            }
        }
        return ans;
    }
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Set<Integer>> record = new ArrayList<>();
        boolean test = true;
        for(int i = 0;i<n;++i){
            ans.add(new ArrayList<>());
            record.add(new HashSet<>());
            //record[i][i] = true;
        }
        for(int[] edge: edges){
            record.get(edge[0]).add(edge[1]);
        }
        while(test){
            test = false;
            for(int i = 0;i<n;++i){
                Set<Integer> cur = record.get(i);
                Set<Integer> next = new HashSet<>(cur);
                int len = cur.size();
                for(int j:cur){
                    Set<Integer> set = record.get(j);
                    next.addAll(set);
                    if(next.size()>len)
                        test = true;
                }
                record.set(i,next);
            }
        }
        for(int i = 0;i<n;++i){
            for(int j = 0;j<n;++j){
                Set<Integer> cur = record.get(j);
                if(cur.contains(i))
                    ans.get(i).add(j);
            }
        }
        return ans;
    }*/
    // a是b的祖先，b是c的祖先，那么a也是c的祖先
    public List<List<Integer>> getAncestors(int n, int[][] edges){
        List<List<Integer>> ans = new ArrayList<>();//答案
        List<List<Integer>> record = new ArrayList<>();
        int[] vis = new int[n];
        Arrays.fill(vis, -1);
        for(int i = 0;i<n;++i){
            record.add(new ArrayList<>());
            ans.add(new ArrayList<>());
        }
        for(int[] edge:edges)
            record.get(edge[0]).add(edge[1]);
        for(int i = 0;i<n;++i){
            dfs(i,i,record,ans,vis);
        }    
        return ans;
    }
    /**
     * 
     * @param start 祖先节点
     * @param cur 当前节点下标
     * @param record 可达点记录表
     * @param ans 祖先记录表
     * @param vis 访问节点表
     */
    public void dfs(int start, int index,List<List<Integer>> record,List<List<Integer>> ans, int[] vis){
        vis[index] = start;
        for(int i:record.get(index)){
            if(vis[i]!=start){//避免重复访问
                ans.get(i).add(start);
                dfs(start,i,record,ans,vis);
            }
        }
    }
}
// @lc code=end

