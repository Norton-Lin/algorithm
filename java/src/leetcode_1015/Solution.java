package leetcode_1015;

class Solution {
    //k必须是个以1,3,7,9结尾的奇数
	//直接计算会爆
	//k反推n长度
	public int smallestRepunitDivByK(int k) {
        int bit = k%10;//末位
        if(bit%2==0||bit%5==0)
            return -1;
        int carry = 0;
        int ans = 0;
        do
        {
        	for(int i = 0;i<10;++i)
            {
            	if((k*i+carry)%10==1)
            	{
            		carry = (k*i+carry)/10;
            		break;
            	}
            }
        	++ans;
        }while(carry!=1&&carry!=0);
        if(carry==1)//首位补充
            ans+=1;
    	return ans;
    }
	/**
	 暴力计算+取模性质，保证不会溢出
	 * public int smallestRepunitDivByK(int k) {
        int bit = k%10;//末位
        if(bit%2==0||bit%5==0)
            return -1;
        int ans = 1;
        int num =1;
        while(num%k!=0)
        {
            num = num%k;
            num=num*10+1;
            ++ans;
        }
    	return ans;
    }*/
	 */
}
