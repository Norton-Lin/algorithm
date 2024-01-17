package day.leetcode_1238;

import java.util.ArrayList;
import java.util.List;

class Solution {
    //返回0-2^(n-1)的排列
	//回溯，排列树
    public List<Integer> circularPermutation(int n, int start) {
        List<Integer> ans = new ArrayList<Integer>();
        ans.add(start);
        start = backtrack(1<<(n-1), start, ans);
        return ans;
    }
    public int backtrack(int index,int start, List<Integer> ans) {
		if(index == 1)
		{
			start = start^index;
			ans.add(start);
		}
		else 
		{
			start = backtrack(index>>1, start, ans);
			start = start^index;
			ans.add(start);
			start = backtrack(index>>1, start, ans);
		}
		return start;
	}
    public static void main(String args[]) {
		Solution solution = new Solution();
		List<Integer> ans = solution.circularPermutation(2, 0);
	}
}