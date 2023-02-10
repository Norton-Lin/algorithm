package leetcode_2335;

class Solution {
	//amount数组表示需要的不同水的杯子数量
	//1.硬模拟
	//2.数学
    public int fillCups(int[] amount) {
    	int sum = amount[0] + amount[1] + amount[2];
        int num = Math.max(Math.max(amount[0],amount[1]),amount[2]);
        if(sum-num<=num)
            return num;
        int count = 0;
        while(amount[0]>0&&amount[1]>0&&amount[2]>0)
        {
            num = Math.min(Math.min(amount[0],amount[1]),amount[2]);
            if(num==amount[0])
            {
                amount[1] --;
                amount[2] --;
            }
            else if(num == amount[1])
            {
                amount[0] --;
                amount[2] --;
            }
            else
            {
                amount[0] --;
                amount[1] --;
            }
            ++count;
        }
        count += Math.max(Math.max(amount[0],amount[1]),amount[2]);
    	return count;
    }
    /*
    public int fillCups(int[] amount) {
        Arrays.sort(amount);
        if (amount[2] > amount[1] + amount[0]) {
            return amount[2];
        }
        return (amount[0] + amount[1] + amount[2] + 1) / 2;
    }
    */
}