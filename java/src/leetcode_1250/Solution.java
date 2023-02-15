package leetcode_1250;

class Solution {
    //nums数组内，所有数都为整数
    //当nums内存在1，必定有解
    //当nums内全为偶数，无解
    // -- > 归结为 当nums内的公因数在不为1时，无解
    public boolean isGoodArray(int[] nums) {
        int num = nums[0];
        for(int cur:nums)
        {
            if(num<=cur)
                num = gcd(num,cur);
            else
                num = gcd(cur,num);
            if(num == 1)
                return true;
        }
        return false;
    }
    public int gcd(int a,int b)
    {
        return a==0?b:gcd(b%a,a);
    }
}
