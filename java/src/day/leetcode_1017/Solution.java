package day.leetcode_1017;

class Solution {
    //答案必是奇数项
    //先转二进制
    public String baseNeg2(int n) {
    	if(n == 0)
        	return "0";
        StringBuilder res = new StringBuilder(base2(n));
        int num = 0;
        for(int i = 0;i<res.length();++i)
        {
        	if(i%2 == 1)
        	{
                if(num == 1)
                {
                    if(res.charAt(i)=='1')
                    {
        		        res.setCharAt(i, '0');
                        num = 1;
                    }
                    else
                    {
                        res.setCharAt(i, '1');
                        num = 1;
                    }
                }
        		else if(num == 0&&res.charAt(i)=='1')
        			num = 1;//进位
        	}
        	else {
				if(res.charAt(i)=='1')
				{
					if(num == 1)
					{
						res.setCharAt(i, '0');
						num = 1;
					}
                    else
                        num = 0;
				}
				else 
				{
					if(num == 1)
					{
						res.setCharAt(i, '1');
						num = 0 ;
					}
				}
			}
        }
        if(num == 1)
        	res.append("1");
        if(res.length()%2==0)
        	res.append("1");
        return res.reverse().toString();

    }
    public static String base2(int n) {
        StringBuilder res = new StringBuilder();
        while(n>0)
        {
        	if(n%2 == 0)
        		res.append("0");
        	else 
				res.append("1");
        	n/=2;
        	
        }
        return res.toString();
        
    }
    public String baseNeg21(int n) {
        if(n<2)
            return String.valueOf(n);
        StringBuilder res = new StringBuilder();
        while(n!=0)
        {
        	int r = n & 1;
        	res.append(r);
        	n -= r;
        	n/=-2;
        }
        return res.reverse().toString();
    }
}