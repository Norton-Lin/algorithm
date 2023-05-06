package leetcode_1419;


class Solution {
    //某个字符出现时，当且仅当该字符之前的字符数大于该字符已出现数
	//青蛙数量 = max(c - k)
    public int minNumberOfFrogs(String croakOfFrogs) {
    	int[] state = new int[5];
    	int ans = 0;
    	if(croakOfFrogs.length()%5!=0)
    		return -1;
    	for(char c:croakOfFrogs.toCharArray())
    	{
    		switch(c)
    		{
    		case 'c':{
    			++state[0];
    			ans = Math.max(ans, state[0]-state[4]);
    		}break;
    		case 'r':{
    			if(state[0]==state[1])
    				return -1;
    			++state[1];
    		}break;
    		case 'o':{
    			if(state[1]==state[2])
    				return -1;
    			++state[2];
    		}break;
    		case 'a':{
    			if(state[2]==state[3])
    				return -1;
    			++state[3];
    		}break;
    		case 'k':{
    			if(state[3]==state[4])
    				return -1;
    			++state[4];
    		}break;
    		default:return -1;
    		}
    	}
        for(int cur:state)
            if(cur!=state[0])
                return -1;
    	return ans;
    }
}