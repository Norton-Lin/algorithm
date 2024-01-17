package day.leetcode_1630;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    //三个数组
    //返回List列表
    //l,r数组表示第i个查询的左右端
    
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> ans = new ArrayList<Boolean>();
        for(int i = 0 ;i<l.length;++i)
            ans.add(check(nums,l[i],r[i]));
        return ans;
    }
    //判断优化，O(n*m)
    public Boolean check(int[] nums,int l,int r)
    {
        int len = r - l + 1;
        int max = -100001,min = 100001;
        int[] cur = new int[len];
        boolean[] judge = new boolean[len];
        for(int i = 0;i<len;++i)//O(n)
        {
            cur[i] = nums[l+i];
            if(max < cur[i])
                max = cur[i];
            if(min > cur[i])
                min = cur[i];
        }
        if((max-min)%(len-1)!=0)
        	return false;
        int value = (max - min)/(len - 1);
        if(value == 0)
            return true;
        int index = 0;
        for(int i = 0;i<len;++i)
        {
        	if((cur[i] - min)%value!=0)
            	return false;
            index = (cur[i] - min)/value;
            if(judge[index])
                return false;
            judge[index] = true;
        }
        return true;
    }
    /*
    //暴力法，截取、排序、遍历 O(nlogn * m)
    public Boolean check(int[] nums,int l,int r)
    {
        int len = r - l + 1;
        int[] cur = new int[len];
        for(int i = 0;i<len;++i)//O(n)
            cur[i] = nums[l+i];
        Arrays.sort(cur);
        int value = cur[0] - cur[1];
        for(int i = 2;i<len;++i)
        {
            if(cur[i-1] - cur[i] != value)
                return false;
        }
        return true;
    }*/
    public static void main(String args[]) {
		Solution solution = new Solution();
		List<Boolean> ans =solution.checkArithmeticSubarrays
				(new int[]{-12,-9,-3,-12,-6,15,20,-25,-20,-15,-10}, 
						new int[]{0,1,6,4,8,7}, 
						new int[]{4,4,9,7,9,10});
		System.out.print(ans);
    }
}

