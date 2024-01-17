package day.leetcode_1093;


class Solution {
    //找最小值，最大值，平均值，中位值，众数
	//暴力遍历， 我觉得会爆 
    public double[] sampleStats(int[] count) {
        double minimum = 256;
        double maximum = 0;
        double mean = 0;
        double median = 0;
        double mode = 0;
        double max_num = 0;
        double cur = 0;
        long sum = 0;
        long num = 0;
        long temp = 0;
        boolean judge = true;
        for(int i = 0;i<count.length;++i)
        {
        	if(count[i] == 0)
        		continue;
        	cur = (double)i;
        	minimum = Math.min(minimum, cur);//这里其实可以优化，why?count有序啊
        	maximum = Math.max(maximum, cur);
        	//防止平均值计算溢出
        	mean = mean*((double)(num)/(double)(num+count[i]))+i*((double)(count[i])/(double)(num+count[i]));
        	num +=count[i];
        	if(max_num<count[i])//这里也可以优化，why?mode就是下标啊
        	{
        		max_num = count[i];
        		mode = cur;
        	}
        }
        mean = (double)(sum)/(double)(num);
        judge = num%2==0;
        temp = num;
        num = 0;
        sum = 0;
        cur = 0;
        for(int i = 0;i<count.length;++i)
        {
        	if(count[i] == 0)
        		continue;
        	num+=count[i];
        	if(judge&&num>=temp/2)
        	{
        		cur = i;
        		judge = false;
        	}
        	if(num>=temp/2+1)
        	{
        		if(Math.abs(cur)<1e-6)
        			cur = i;
        		cur+= i;
        		break;
        	}
        }
        median = cur/2;
        return new double[]{minimum,maximum,mean,median,mode};
    }
    public static void main(String args[]) {
		Solution solution = new Solution();
		double[] ans = solution.sampleStats(new int[] {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,3510,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,6718,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,27870,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,35,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,26256,0,0,0,0,9586565,0,0,0,0,0,0,0,2333,0,0,0,0});
    }
}
