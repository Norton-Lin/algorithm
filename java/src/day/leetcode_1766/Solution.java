package day.leetcode_1766;
/*
 * @lc app=leetcode.cn id=1766 lang=java
 *
 * [1766] 互质树
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// @lc code=start
class Solution {
    List<Integer>[] gcds;
    List<Integer>[] tmp;
    List<Integer>[] g;
    int[] dep;
    int[] ans;

    public int[] getCoprimes(int[] nums, int[][] edges) {
        int n = nums.length;
        // 初始化
        gcds = new List[51];
        tmp = new List[51];
        Arrays.setAll(gcds, i->new ArrayList<>());
        Arrays.setAll(tmp, i->new ArrayList<>());
        ans = new int[n];
        dep = new int[n];
        Arrays.fill(ans, -1);
        Arrays.fill(dep, -1);
        g = new List[n];
        Arrays.setAll(g, i->new ArrayList<>());

        for (int i = 1; i <= 50; i++) {//记录50以内互质数
            for (int j = 1; j <= 50; j++) {
                if (gcd(i, j) == 1) {
                    gcds[i].add(j);
                } 
            }
        }

        for (int[] val : edges) {
            g[val[0]].add(val[1]);
            g[val[1]].add(val[0]);
        }

        dfs(nums, 0, 1);
        
        return ans;
    }

    public int gcd(int a,int b){
        return b == 0?a:gcd(b,a%b);
    }

    public void dfs(int[] nums, int x, int depth) {
        dep[x] = depth;//深度记录
        for (int val : gcds[nums[x]]) {
            if (tmp[val].isEmpty()) {
                continue;
            }
        
            int las = tmp[val].get(tmp[val].size() - 1);
            if (ans[x] == -1 || dep[las] > dep[ans[x]]) {//互质数更接近当前节点
                ans[x] = las;
            }
        }
        tmp[nums[x]].add(x);

        for (int val : g[x]) {
            if (dep[val] == -1) { // 被访问过的点dep不为-1
                dfs(nums, val, depth + 1);
            }
        }

        tmp[nums[x]].remove(tmp[nums[x]].size() - 1);
    }
}

// @lc code=end

