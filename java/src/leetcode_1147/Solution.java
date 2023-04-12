package leetcode_1147;

class Solution {
	//对1<=i<=k,subtexti == subtextk-i+1
	//前后回文
	public int longestDecomposition(String text) {
        int head1 = 0,head2 = 0;
        int end1 = text.length()-1,end2 = text.length()-1;
        int ans = 0;
        while(head1<end1)
        {
            if(text.substring(head2,head1+1).equals(text.substring(end1,end2+1)))
            {
            	System.out.println(text.substring(head2,head1+1));
                head2 = head1+1;
                end2 = end1-1;
                ans+=2;
            }
            ++head1;
            --end1;
        }
        if(head2<=end2)
        {
        	if(!text.substring(head2,head1+1).equals(text.substring(end1,end2+1))||(head2 == end1&&head1==end2))
        		++ans;
        }
        	
        return ans;
    }
	 public static void main(String agrs[]) {
	    	Solution s = new Solution();
	    	int ans = s.longestDecomposition("ab");
			
		}
}