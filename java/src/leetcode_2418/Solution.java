package leetcode_2418;

import java.util.Arrays;

class Solution {
	//解1,类排序
	/*
    public String[] sortPeople(String[] names, int[] heights) {
        class Temp{
            public String name = new String();
            public int height = 0;
        }
        Temp[] ans = new Temp[heights.length];
        for(int i = 0;i<heights.length;++i)
        {
        	ans[i] = new Temp();
            ans[i].name = names[i];
            ans[i].height = heights[i];
        }
        Arrays.sort(ans,(o1,o2)->(o1.height-o2.height));
        for(int i = 0;i<names.length;++i)
            names[i]=ans[i].name;
        return names;
    }*/
	public String[] sortPeople(String[] names, int[] heights) {
		Integer[] index = new Integer[heights.length];
		for(int i = 0;i<index.length;++i)
			index[i] = i;
		Arrays.sort(index,(i,j)->heights[j]-heights[i]);
		String[] ans = new String[names.length];
		for(int i = 0;i<names.length;++i)
			ans[i] = names[index[i]];
		return ans;
	}
	//或者哈希
    public static void main(String args[]) {
		Solution solution = new Solution();
		String ans[] = solution.sortPeople(new String[] {"Mary","John","Emma"}, new int[] {180,165,170});
	}
}
