package leetcode_2446;


class Solution {
	//暴力匹配
    public boolean haveConflict(String[] event1, String[] event2) {
    	int[] time1 = new int[4];
    	int[] time2 = new int[4];
    	time1[0] = Integer.valueOf(event1[0].substring(0,2));
    	time1[1] = Integer.valueOf(event1[0].substring(3));
    	time1[2] = Integer.valueOf(event1[1].substring(0,2));
    	time1[3] = Integer.valueOf(event1[1].substring(3));
    	time2[0] = Integer.valueOf(event2[0].substring(0,2));
    	time2[1] = Integer.valueOf(event2[0].substring(3));
    	time2[2] = Integer.valueOf(event2[1].substring(0,2));
    	time2[3] = Integer.valueOf(event2[1].substring(3));
    	if(time1[0]>time2[2]||time1[2]<time2[0])//起始时间小时晚于终止时间小时
    		return false;
    	else if(time1[0] == time2[2]&&time1[2] != time2[0])//起始时间小时等于终止时间小时
    	{
    		if(time1[1]<=time2[3])
    			return true;
    		else
    			return false;
    	}
    	else if(time1[2] == time2[0]&&time1[0] != time2[2])
    	{
    		if(time2[1]<=time1[3])
    			return true;
    		else
    			return false;
    	}
        else if(time1[2] == time2[0]&&time1[0] == time2[2])
        {
            if(time1[1]<time2[1])//1先开始
            {
                if(time1[3]>=time2[1])
                {
                    return true;
                }
            }
            else if(time1[1] == time2[1])
                return true;
            else
            {
                if(time2[3]>=time1[1])
                {
                    return true;
                }
                    
            }
            return false;
        }
    	return true;
    }
    //
    /**字符串直接比啊日
     public boolean haveConflict(String[] event1, String[] event2) {
            return !(event1[1].compareTo(event2[0]) < 0 || event2[1].compareTo(event1[0]) < 0);
        }
     */
}
