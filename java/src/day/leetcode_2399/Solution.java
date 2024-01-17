package day.leetcode_2399;

import java.util.Arrays;

class Solution {
    public boolean checkDistances(String s, int[] distance) {
        int[] map1 = new int[26];
        int[] map2 = new int[26];
        Arrays.fill(map1,-1);
        Arrays.fill(map2,0);
        for(int i = 0;i<s.length();++i)
        {
            char c = s.charAt(i);
            if(map1[c-'a']==-1)
                map1[c-'a'] = i;
            else
                map2[c-'a'] = i;
        }
        for(int i = 0;i<26;++i)
            if(map2[i]-map1[i]-1!=distance[i])
                return false;
        return true;
    }
    public static void main(String args[]) {
		Solution solution = new Solution();
		boolean ans = solution.checkDistances("abaccb", new int[] {1,3,0,5,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0});
		System.out.print(ans);
	} 
}
