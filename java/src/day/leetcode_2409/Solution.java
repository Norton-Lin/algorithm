package day.leetcode_2409;

class Solution {
	static int[] days = {31,28,31,30,31,30,31,31,30,31,30,31};
	static int[] prefix = new int[13];
	/**
	 * 暴力模拟
	 * @param arriveAlice
	 * @param leaveAlice
	 * @param arriveBob
	 * @param leaveBob
	 * @return
	 */
	/*
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
    	int arriveMonthAlice = stoi(arriveAlice.split("-")[0]);
    	int arriveDayAlice = stoi(arriveAlice.split("-")[1]);
    	int arriveMonthBob = stoi(arriveBob.split("-")[0]);
    	int arriveDayBob = stoi(arriveBob.split("-")[1]);
    	int leaveMonthAlice = stoi(leaveAlice.split("-")[0]);
    	int leaveDayAlice = stoi(leaveAlice.split("-")[1]);
    	int leaveMonthBob = stoi(leaveBob.split("-")[0]);
    	int leaveDayBob = stoi(leaveBob.split("-")[1]);
    	int startMonth = 0,startDay = 0;
    	int endMonth = 0,endDay = 0;
    	int ans = 0;
    	if(arriveMonthAlice>arriveMonthBob)
    	{
    		startMonth = arriveMonthAlice;
    		startDay = arriveDayAlice;
    	}
    	else if(arriveMonthAlice<arriveMonthBob)
    	{
    		startMonth = arriveMonthBob;
    		startDay = arriveDayBob;
    	}
    	else
    	{
    		startMonth = arriveMonthAlice;
    		startDay = Math.max(arriveDayAlice, arriveDayBob);
    	}
    	if(leaveMonthAlice<leaveMonthBob)
    	{
    		endMonth = leaveMonthAlice;
    		endDay = leaveDayAlice;
    	}
    	else if(leaveMonthAlice>leaveMonthBob)
    	{
    		endMonth = leaveMonthBob;
    		endDay = leaveDayBob;
    	}
    	else
    	{
    		endMonth = leaveMonthAlice;
    		endDay = Math.min(leaveDayAlice, leaveDayBob);
    	}
        if(startMonth>endMonth)
            return 0;
    	if(startMonth == endMonth)
        {
            if(startDay>endDay)
                return 0;
            return endDay - startDay +1; 
        }
    	for(int i = startMonth;i<endMonth-1;++i)
    		ans+=days[i];
    	ans+=days[startMonth-1]-startDay+1;
    	ans+=endDay;
    	return ans;
    }
    public int stoi(String s) {
    	return (s.charAt(0)-'0')*10+s.charAt(1)-'0';
    }*/
	public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
		for(int i = 1;i<12;++i)
			prefix[i] = prefix[i-1]+days[i-1];
		int arriveA = calendarDay(arriveAlice);
		int leaveA = calendarDay(leaveAlice);
		int arriveB = calendarDay(arriveBob);
		int leaveB = calendarDay(leaveBob);
		int ans = Math.min(leaveA, leaveB) - Math.max(arriveA,arriveB)+1;
		return ans>0?ans:0;
		
	}
	public int calendarDay(String s) {
		return prefix[Integer.parseInt(s.substring(0,2))-1]+Integer.parseInt(s.substring(3));
	}
}

