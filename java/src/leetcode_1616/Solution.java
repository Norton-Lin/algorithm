package leetcode_1616;


class Solution {
    //将a,b在相同下标处分割，检查是否可以构成回文串
    //当a,b至少有一个回文，可以
    //当a,b都不是回文
    //当a头部和b尾部匹配
    //当b头部和a尾部匹配
    //eg abcd efbbba -> 翻转 abbbfe -> 截取 abbb ab和ab相同 检查 bb是否回文
    public boolean checkPalindromeFormation(String a, String b) {
    	if(isPalindrome(a)||isPalindrome(b))
    		return true;
        int len = a.length();
        int index = 0;
        for(index = 0 ;index<len;++index)//记录a头部和b尾部匹配长度
            if(a.charAt(index)!=b.charAt(len-index-1))
                break;
        if(index>=len/2||isPalindrome(b.substring(index, len-index-1)))
        	return true;
        for(index = 0;index<len;++index)
        	if(b.charAt(index)!=a.charAt(len-index-1))
                break;
        if(index>=len/2||isPalindrome(a.substring(index, len-index-1)))
        	return true;
    	return false;
    }
    public boolean isPalindrome(String a)//O(n)
    {
    	int len = a.length();
    	for(int i = 0;i<len/2;++i)
    		if(a.charAt(i)!=a.charAt(len-i-1))
    			return false;
    	return true;
    }
    public static void main(String args[]) {
    	Solution solution = new Solution();
    	boolean ans = solution.checkPalindromeFormation("abda", "acmc");
    	System.out.print(ans);
		
	}
}