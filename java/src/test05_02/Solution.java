package test05_02;

class Solution {
    public String printBin(double num) {
        StringBuilder ans = new StringBuilder();
        ans.append("0.");
        double cur = 1;
        for(int i = 0; i<32;++i)
        {
        	cur/=2;
            if(num > cur)
            {
                ans.append('1');
        		num-=cur;
            }
        	else if(Math.abs(num-cur)<=(double)(1/(1<<31)))
        	{
        		ans.append('1');
        		num-=cur;
                break;
        	}
        	else
				ans.append('0');
        }
        if(Math.abs(num)>(double)(1/(1<<31)))
            return "ERROR";
        return ans.toString();
    }
    
}