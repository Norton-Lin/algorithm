package leetcode_2437;

class Solution {
	//暴力暴力
    public int countTime(String time) {
        int ans = 1;
        if(time.charAt(0)=='?'&&time.charAt(1)=='?')
        	ans=24;
        else if(time.charAt(0)=='?')
        {
        	if(time.charAt(1)>='4')
        		ans=2;
        	else {
				ans=3;
			}
        }
        else if(time.charAt(1)=='?')
        {
            if(time.charAt(0)<'2')
        	    ans = 10;
            else if(time.charAt(0)=='2')
                ans = 4;
        }
        if(time.charAt(3)=='?'&&time.charAt(4)=='?')
        	ans*=60;
        else if(time.charAt(3)=='?')
        {
        	ans *=6;
        }
        else if(time.charAt(4)=='?')
        	ans *= 10;
        return ans;
    }
}