package leetcode_1637;

import java.util.Arrays;

class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        Arrays.sort(points,(o1,o2)->(o1[0]-o2[0]));
        int ans = 0,cur = 0;
        for(int i = 1;i<points.length;++i)
        {
        	cur = points[i][0] - points[i-1][0];
        	ans = ans>= cur? ans:cur;
        }
        return ans;
    }
}
