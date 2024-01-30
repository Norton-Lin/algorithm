package day.leetcode_514;
/*
 * @lc app=leetcode.cn id=514 lang=java
 *
 * [514] 自由之路
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
// @lc code=start

class Solution {
    // 每一次旋转，次数小于ring.length 的一半
    // 但是要最小？ 每次贪心不一定可以得到最优结果
    // ring key 长度都小于100
    // dp[i][j] 拼完key第i位，选择ring的第j位时，所需要的最小距离
    // dp[i][j] = Math.min(dp[i-1][x]+差值)
    // x是上一个选择 差值是 abs(j-x) 或者ring.length-abs(j-x)
    public int findRotateSteps(String ring, String key) {
        int count = Integer.MAX_VALUE;
        // dp[i][j] 从
        int dp[][] = new int[key.length()][ring.length()];
        List<List<Integer>> lists = new ArrayList<List<Integer>>();// 记录符合key的ring字符位置
        for (int i = 0; i < key.length(); ++i) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < ring.length(); ++j) {
                if (ring.charAt(j) == key.charAt(i)) {
                    list.add(j);
                    if (i == 0){
                        dp[0][j] = Math.min(ring.length()-j,j);
                        ++dp[0][j];
                    }
                        
                }

            }
            lists.add(list);
        }
        for (int i = 1; i < key.length(); ++i) {
            List<Integer> pres = lists.get(i - 1);
            List<Integer> curs = lists.get(i);
            for (int j = 0; j < curs.size(); ++j) {
                int cur = curs.get(j);
                for (int k = 0; k < pres.size(); ++k) {
                    int pre = pres.get(k);
                    int value = Math.abs(cur - pre);
                    dp[i][cur] = Math.min(dp[i][cur],dp[i-1][pre]+Math.min(value,ring.length()-value));
                }
                ++dp[i][cur];
            }
        }
        for(int i = 0;i<dp[key.length()-1].length;++i){
            count = Math.min(count, dp[key.length()-1][i]);
        }
        return count;
    }
    public static void main(String args[]){
        Solution s = new Solution();
        s.findRotateSteps("godding", "gd");
    }
}
// @lc code=end
