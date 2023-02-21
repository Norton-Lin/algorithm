package leetcode_1326;

import java.util.Arrays;
import java.util.Comparator;


class Solution {
	//贪心，从左端开始，试图尽可能覆盖右侧区域
	// O(nlogn)
	/*
	public int minTaps(int n, int[] ranges) {
        int[][] cover = new int[n+1][2];
        for(int i =0;i<=n;++i)
        {
        	cover[i][0] = i - ranges[i];
        	cover[i][1] = i + ranges[i];
        	if(cover[i][0]<0)
        		cover[i][0] = 0;
        	if(cover[i][1]>n)
        		cover[i][1] = n;
        }
        Arrays.sort(cover,new Comparator<int[]>() {
        	@Override
        	public int compare(int c1[], int c2[])
        	{
        		return (c1[0] - c2[0]) != 0 ? c1[0] - c2[0]: c1[1] - c2[1];
        	}
        });
        int left = 0,right = 0,ans = 0;
        int cur_left = 0, cur_right = 0;
        for(int i =0;i<=n&&cur_right<n;++i)
        {
        	if(right >= cover[i][0] )//覆盖域相连接
        	{
        		if(cover[i][1]>cur_right)//更新覆盖预
        		{
        			cur_left = cover[i][0];
        			cur_right = cover[i][1];
        		}
        	}
        	else 
    		{
				left = cur_left;
				right = cur_right;
                if(right<cover[i][0])
                    break;
                --i;
				++ans;
			}
        }
        return cur_right == n? ans+1:-1;
    }*/
	//优化
	//dp
	public int minTaps(int n, int[] ranges) {
		int[] right = new int[n+1];
		int ans = 0, cur = 0, next = 0;//当前最右覆盖，下一个最右覆盖
		for(int i = 0;i<=n;++i)
		{
			int r = ranges[i];
			if(i>r)//左侧覆盖域不超过0
				right[i-r] = i+r;//从i-r处可以向右覆盖的最远区域
			else //左侧覆盖率可达0
				right[0] = Math.max(right[0], i+r);
		}
		for(int i = 0 ;i<=n ;++i)
		{
			if(i>=cur)
			{
				if(i>next)
					return -1;
				if(i<n)
				{
					++ans;
					cur = Math.max(right[i], next);
				}	
			}
            next = Math.max(right[i],next);
		}
        return ans;
	}
}

