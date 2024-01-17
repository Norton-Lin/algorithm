package day.leetcode_1072;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
	//按列翻转，检查最多多少行全为0/1
	//两行完全相等或完全相反，则可通过翻转操作得到值相等的行
	//暴力匹配规模 300^3
	//O(m^2*n)
	/**
    public int maxEqualRowsAfterFlips(int[][] matrix) {
    	int cur = 0,ans = 0;
    	int count = 0;
    	boolean[] isChecked = new boolean[matrix.length];
    	Arrays.fill(isChecked,true);
    	for(int[] i:matrix)//无需翻转
    	{
    		int j = 0;
    		for(;j<matrix[0].length;++j)
    		{
    			if(i[j]!=i[0])
    				break;
    		}
    		if(j==matrix[0].length)
    			++ans;
    	}
    	for(int i = 0;i<matrix.length;++i)//需翻转
    	{
    		if(isChecked[i])
    		{
    			cur = 1;
    			for(int j = i+1;j<matrix.length;++j)
    			{
    				if(isChecked[j]&&isTrue(matrix[i], matrix[j]))
        			{
    					++cur;
    					isChecked[i] = false;
        			}	
    			}
    			ans = Math.max(cur, ans);
    		}
    	}
    	return ans;
    	
    }
    boolean isTrue(int[] row1,int [] row2)
    {
    	int len = row1.length;
    	if(row1[0]==row2[0])
    	{
    		for(int i = 1;i<len;++i)
    			if(row1[i]!=row2[i])
    				return false;
    	}
    	else {
    		for(int i = 1;i<len;++i)
    			if(row1[i]==row2[i])
    				return false;
		}
    	return true;
    }*/
	//位图,会溢出
    //哈希
	public int maxEqualRowsAfterFlips(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < m; i++) {
            char[] arr = new char[n];
            Arrays.fill(arr, '0');
            for (int j = 0; j < n; j++) {
                // 如果 matrix[i][0] 为 1，则对该行元素进行翻转
                arr[j] = (char) ('0' + (matrix[i][j] ^ matrix[i][0]));
            }
            String s = new String(arr);
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        int res = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            res = Math.max(res, entry.getValue());
        }
        return res;
    }
}
