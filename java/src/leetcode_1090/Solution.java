package leetcode_1090;

import java.util.Arrays;
import java.util.HashMap;

class Solution {
    //子集大小（元素数量）小于等于nunmWanted
    //相同标签数（label）最多为useLimit
    //求子集最大分数（value和）
    //贪心
    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        int[][] record = new int[values.length][2];
        HashMap<Integer, Integer> map = new HashMap<>();//记录标签使用数
        for(int i = 0;i<values.length;++i)
        {
        	record[i][0] = values[i];
        	record[i][1] = labels[i];
        }
        Arrays.sort(record,(o1,o2)->(o2[0]-o1[0]));//大到小排序
        int count = 0;
        int ans = 0;
        for(int i = 0;i<values.length&&count<numWanted;++i)
        {
        	if(map.getOrDefault(record[i][1], 0)==useLimit)
        		continue;
        	ans+=record[i][0];
        	++count;
        	map.put(record[i][1], map.getOrDefault(record[i][1], 0)+1);
        }
        return ans;
    }
}
