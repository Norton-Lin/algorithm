package day.leetcode_1073;

class Solution {
	//-2进制
	//进制转换
	//整数计算必然爆炸，Fuck
	//逐位模拟
	public int[] addNegabinary(int[] arr1, int[] arr2) {
    	StringBuilder record = new StringBuilder();
    	int pre = 0,cur = 0,next = 0;
    	int[] record1 = new int[Math.max(arr1.length, arr2.length)];
    	int[] record2 = new int[record1.length];
    	for(int i = record1.length-1;i>=record1.length-arr1.length;--i)
    	{
    		record1[i] = arr1[i-(record1.length-arr1.length)];
    	}
    	for(int i = record1.length-arr1.length-1;i>=0;--i)
    	{
    		record1[i] = 0;
    	}
    	for(int i = record2.length-1;i>=record2.length-arr2.length;--i)
    	{
    		record2[i] = arr2[i-(record2.length-arr2.length)];
    	}
    	for(int i = record2.length-arr2.length-1;i>=0;--i)
    	{
    		record2[i] = 0;
    	}
    	for(int i = record1.length-1;i>=0;--i)
    	{
    		cur = record1[i]+record2[i] - pre + next;//当前位
    		if(cur == -1)//进位
    		{
    			cur = 1;
    			pre = 0;
    			next = 1;
    		}
    		else if(cur == 2)
            {
                cur = 0;
                pre = 1;
                next = 0;
            }
            else if (cur ==3 )
            {
            	cur = 1;
            	pre = 1;
            	next = 0;
            }
            else 
    		{
            	pre = 0;
    			next = 0;
    		}
            record.append(cur);
    	}
        if(next == 1)
            record.append("11");
    	record.reverse();
    	int start = 0;
    	while(start<record.length()&&record.charAt(start)=='0')
    		++start;
    	String str = record.substring(start);
    	if(str.length()==0)
    		return new int[] {0};
    	int[] ret = new int[str.length()];
    	for(int i = 0;i<ret.length;++i)
    		ret[i] = str.charAt(i)-'0';
    	return ret;
    }
    public static void main(String args[]) {
		Solution solution = new Solution();
		int[] ans = solution.addNegabinary(new int[] {1,0,1}, new int[] {1});
    }
}
