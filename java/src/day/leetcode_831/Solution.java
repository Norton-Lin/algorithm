package day.leetcode_831;

class Solution {
	String[] head = {"","+*-","+**-","+***-"};
	public String maskPII(String s) {
		int index = s.indexOf("@");
		if(index>=0)
		{
			s = s.toLowerCase();
			return s.substring(0, 1)+"*****"+s.substring(index-1);
		}
		s = s.replaceAll("[^0-9]", "");
		return head[s.length()-10]+"***-***-"+s.substring(s.length()-4);
	}
	/**
	 * 暴力模拟
    public String maskPII(String s) {
    	StringBuilder ans = new StringBuilder();
    	if(s.contains((CharSequence)"@"))
    	{
    		int index = 0;
    		index = s.indexOf("@");
    		char first = s.charAt(0);
    		char end = s.charAt(index-1);
    		if(first>='A'&&first<='Z')
    			first = (char) (first-'A'+'a');
    		if(end>='A'&&first<='Z')
    			end = (char) (end-'A'+'a');
    		ans.append(first);
    		ans.append("*****");
    		ans.append(end);
    		for(int i = index;i<s.length();++i)
    		{
    			char cur = s.charAt(i);
    			if(cur>='A'&&cur<='Z')
    				cur = (char) (cur-'A'+'a');
    			ans.append(cur);
    		}
    	}
    	else {
    		int count = 1;
    		StringBuilder number = new StringBuilder();
    		for(int i = 0;i<s.length();++i)
    		{
    			char cur = s.charAt(i);
    			if(cur>='0'&&cur<='9')
    				number.append(cur);
    		}
    		if(number.length() == 10)
    			ans.append("***-***-"+number.substring(7));
    		else if(number.length() == 11)
    			ans.append("+*-***-***-"+number.substring(8));
    		else if(number.length() == 12)
    			ans.append("+**-***-***-"+number.substring(9));
    		else 
    			ans.append("+***-***-***-"+number.substring(10));
    			
    	}
    	return ans.toString();	
    }*/
}