package leetcode_1439;

import java.util.Arrays;

class Solution {
	//mat每行选一个元素，找到第k小的元素的和
	//mat每行非递减
	//找当前最小元素，查看是否行重复，这不枚举么，不行
	//所有可能40^40，必定爆炸
	//第k小，m1*m2*m3*..mm
	//暴力
	public int kthSmallest(int[][] mat, int k) {
	    var a = new int[]{0};
	    for (var row : mat) 
	    {
	        var b = new int[a.length * row.length];
	        int i = 0;
	        for (int x : a)
	            for (int y : row)
	               b[i++] = x + y;
	        Arrays.sort(b);
	        if (b.length > k) // 保留最小的 k 个
	            b = Arrays.copyOfRange(b, 0, k);
	        a = b;
	    }
	    return a[k - 1];
	}
	/**
	 * 二分搜索
	private int leftK;

    public int kthSmallest(int[][] mat, int k) {
        int sl = 0, sr = 0;
        for (var row : mat) {
            sl += row[0];
            sr += row[row.length - 1];
        }
        // 二分模板 https://www.bilibili.com/video/BV1AP41137w7/
        int left = sl - 1, right = sr; // 开区间 (sl-1,sr)
        while (left + 1 < right) { // 开区间不为空
            // 循环不变量：
            // f(left) < k
            // f(right) >= k
            int mid = (left + right) >>> 1;
            leftK = k;
            if (dfs(mat, mat.length - 1, mid - sl)) // 先把第一列的所有数都选上
                right = mid; // 二分范围缩小至开区间 (left, mid)
            else // f(mid) < k
                left = mid; // 二分范围缩小至开区间 (mid, right)
        }
        return right;
    }

    // 返回是否找到 k 个子数组和
    private boolean dfs(int[][] mat, int i, int s) {
        if (i < 0) // 能递归到这里，说明数组和不超过二分的 mid
            return --leftK == 0; // 是否找到 k 个
        for (int x : mat[i]) { // 「枚举选哪个」，注意 mat[i] 是有序的
            if (x - mat[i][0] > s) // 选 x 不选 mat[i][0]
                break; // 剪枝：后面的元素更大，无需枚举
            if (dfs(mat, i - 1, s - (x - mat[i][0]))) // 选 x 不选 mat[i][0]
                return true; // 找到 k 个就一直返回 true，不再递归
        }
        return false;
    }
	 */
	/**
	 * 最小堆
	 * public int kthSmallest(int[][] mat, int k) {
        var a = new int[]{0};
        for (var row : mat)
            a = kSmallestPairs(row, a, k);
        return a[k - 1];
    }

    // 373. 查找和最小的 K 对数字
    private int[] kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int n = nums1.length, m = nums2.length, sz = 0;
        var ans = new int[Math.min(k, n * m)];
        var pq = new PriorityQueue<int[]>((a, b) -> a[0] - b[0]);
        pq.add(new int[]{nums1[0] + nums2[0], 0, 0});
        while (!pq.isEmpty() && sz < k) {
            var p = pq.poll();
            int i = p[1], j = p[2];
            ans[sz++] = nums1[i] + nums2[j]; // 数对和
            if (j == 0 && i + 1 < n)
                pq.add(new int[]{nums1[i + 1] + nums2[0], i + 1, 0});
            if (j + 1 < m)
                pq.add(new int[]{nums1[i] + nums2[j + 1], i, j + 1});
        }
        return ans;
    }
	 */
    public static void main(String args[]) {
    	Solution solution = new Solution();
    	int ans = solution.kthSmallest(new int[][] {{1,3,11},{1,4,5}}, 7);
		
	}
}
