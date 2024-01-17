package day.leetcode_2451;


class Solution {
	//暴力匹配
    public String oddString(String[] words) {
    	int[] dif1 = new int[words[0].length()-1];
    	int[] dif2 = new int[words[0].length()-1];
    	int[] dif = new int[words[0].length()-1];
    	boolean judge = false;
    	for(int i = 0;i<dif1.length;++i)
    	{
    		dif1[i] = words[0].charAt(i+1)- words[0].charAt(i);
    		dif2[i] = words[1].charAt(i+1)- words[1].charAt(i);
    		if(dif1[i]!=dif2[i])
    			judge = true;
    	}
    	if(judge)
    	{
    		judge = false;
    		for(int i = 0;i<dif1.length;++i)
    		{
        		dif[i] = words[2].charAt(i+1)- words[2].charAt(i);
        		if(dif[i]!=dif2[i])
        			judge = true;
    		}
    		if(judge)
    			return words[1];
    		else {
				return words[0];
			}
    	}
    	for(int i=2;i<words.length;++i)
    	{
    		for(int j = 0;j<dif1.length;++j)
    		{
    			if(words[i].charAt(j+1)- words[i].charAt(j)!=dif1[j])
    				return words[j];
    		}
    		
    	}
    	return "";
    }
    public static void main(String args[]) {
    	Solution s = new Solution();
    	String ans = s.oddString(new String[] {"adc","wzy","abc"});
		System.out.println(ans);
	}
}