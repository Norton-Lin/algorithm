package day.leetcode_2309;


class Solution {
	 public String greatestLetter(String s) {
	        char[] ans = new char[1];
           ans[0] = ' ';
	        char cur = ' ';
	        boolean[] cha1 = new boolean[26];
	        boolean[] cha2 = new boolean[26];
	        for(int i = 0 ;i<s.length();++i)
	        {
	        	cur = s.charAt(i);
	        	if(cur>='a'&&cur<='z')
	        	{
	        		cha1[cur-'a'] = true;
	        		if(cha2[cur-'a']&&ans[0]<cur-'a'+'A')
	        			ans[0] = (char)(cur-'a'+'A');
	        	}
	        	else 
	        	{
	        		cha2[cur-'A'] = true;
	        		if(cha1[cur-'A']&&ans[0]<cur)
	        			ans[0] = cur;
	        	}
	        }
           if(ans[0] == ' ')
               return "";
	        return new String(ans);
	    }
}
