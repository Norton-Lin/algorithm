package day.leetcode_1041;

class Solution {
    //有限状态自动机
    //G走，L左转，R右转
	//暴力模拟
	/*
    public boolean isRobotBounded(String instructions) {
    	int x=0,y=1;
    	int locatex=0,locatey=0;
        for(int i = 0;i<4;++i)
        {
            for(char c:instructions.toCharArray()) {
    		    if(c=='G')
    		    {
    			    locatex+=x;
    			    locatey+=y;
    		    }
    		    else if(c=='L')
    		    {
    		    	int temp = y;
    		    	y  =x;
    		    	x = temp == 0?0:-temp;
    		    }
    		    else {
    		    	int temp = y;
    		    	y = -x;
    		    	x= temp == 0?0:temp;
			    }
    	    }
            if(locatex == 0&&locatey==0)
                return true;
        }
    	
    	return false;
    }
    */
    //不朝北就无法脱离
	public boolean isRobotBounded(String instructions) {
    	int x = 0,y = 1;
    	int locatex=0,locatey=0;
    	for(char c:instructions.toCharArray()) {
		    if(c=='G')
		    {
			    locatex+=x;
			    locatey+=y;
		    }
		    else if(c=='L')
		    {
		    	int temp = y;
		    	y  =x;
		    	x = temp == 0?0:-temp;
		    }
		    else {
		    	int temp = y;
		    	y = -x;
		    	x= temp == 0?0:temp;
		    }
	    }
    	if(locatex !=0&&locatey!=0&&x==0&&y==1)
    		return true;
    	return false;
    }
}