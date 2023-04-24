package leetcode_1105;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    //books[i][0]表示厚度，books[i][1]表示高度
    //返回书架最小高度，每层摆shelfWidth宽度的书
    //优先摆最高的书
	//本层放不下就放下一层
	//dp[i]放前i本书的最小高度
    public int minHeightShelves(int[][] books, int shelfWidth) {
    	int n = books.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 1000000);
        dp[0] = 0;
        for (int i = 0; i < n; ++i) {
            int maxHeight = 0, curWidth = 0;
            for (int j = i; j >= 0; --j) {
                curWidth += books[j][0];
                if (curWidth > shelfWidth) {
                    break;
                }
                maxHeight = Math.max(maxHeight, books[j][1]);
                dp[i + 1] = Math.min(dp[i + 1], dp[j] + maxHeight);
            }
        }
        return dp[n];
    }
    public static void main(String args[]) {
    	Solution solution = new Solution();
    	int ans = solution.minHeightShelves(new int[][]{{7,3},{8,7},{2,7},{2,5}}, 10);
    }
}