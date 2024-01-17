package day.leetcode_1599;

class Solution {
	//四个座舱，每个座舱四个人
	//转动成本runningCost
	//customer[i]第i次转动前来的游客数量
	//登舱成本boardingCost
	//决定停止轮转后，后续轮转免费
	//等待人数<=4,全上，否则只上四个，后续接着等
    //注，他要的轮转次数
    //这不就是一次遍历么。。。被唬到了。。。。
    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
    	int cur = 0;//当前轮转利润
    	int wait = 0;//当前等待人数
    	int profit = 0;
        int ans = 0;
    	if(4*boardingCost <= runningCost)
    		return -1;
    	for(int i =1;i<=customers.length;++i)
    	{
    		wait +=customers[i-1];
    		if(wait<=4)
    		{
    			cur += wait*boardingCost;
    			wait = 0;
    		}
    		else 
    		{
				wait -=4;
				cur+=4*boardingCost;
			}
    		cur -= runningCost;
    		if(profit < cur)
            {
    			profit = cur;
                ans = i;
            }
    	}
    	if(wait>0)
    	{
    		cur = 0;
            ans = customers.length;
            ans += wait/4;
    		if(wait%4 == 0)
    			cur = wait*boardingCost - runningCost*(wait/4);
    		else 
    		{
				cur = (wait - wait%4)*boardingCost - runningCost*(wait/4);
				if((wait%4)*boardingCost > runningCost)
                {
					cur +=(wait%4)*boardingCost - runningCost;
                    ++ans;
                }
			}
    		profit += cur;
    	}
    	return profit > 0 ? ans : -1;
    }
}