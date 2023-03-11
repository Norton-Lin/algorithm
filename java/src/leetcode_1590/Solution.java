package leetcode_1590;

class Solution {
    //子数组，连续
    //删除一个、两个
    //记录以第i位为结尾、子数组和
    //没有什么是暴力dp不能解决的×
	//这里说错了，他也是个前缀和不算dp
    /** 
    public int minSubarray(int[] nums, int p) {
        long[] dp = new long[nums.length];
        long sum = 0;
        boolean judge = false;
        for(int i = 0;i<nums.length;++i)
            sum+=nums[i];
        if((sum%p) == 0)
            return 0;
        for(int i = 0;i<nums.length-1;++i)
        {
            for(int j = i;j<nums.length;++j)
            {
                dp[j]+=nums[j-i];
                if((sum - dp[j])%p == 0)
                {
                    judge = true;
                    break;
                }
            }
            if(judge)
                return i+1;
        }
        return -1;

    }*/
    //优化一下
    public int minSubarray(int[] nums, int p) {
        int sum = 0;
        for (int num : nums)//记录原数组和与p的余数，同时防止越界（省得用long）
            sum = (sum + num) % p;
        if (sum == 0)//原数组和可以整除p
            return 0;
        //若 (sum - key) % p == 0, 则sum % p == key%p
        //若 (key - sum) % p = tmp 则sum % p == (key - tmp) % p
        Map<Integer, Integer> index = new HashMap<Integer, Integer>(nums.length+1);//哈希记录
        int key = 0, ans = nums.length;
        //子数组(j……i) = f(i+1) - f(j) 
        for (int i = 0; i < nums.length; i++) {
            index.put(key, i); //记录以i位结尾的子数组和p的余数(记录最大下标，大下标会覆盖)
            key = (key + nums[i]) % p;//即f(i+1)
            if (index.containsKey((key - sum + p) % p)) //存在一个子数组，删除后可以整除p,即找f(j)
                ans = Math.min(ans, i - index.get((key - sum + p) % p) + 1);//更新最短子数组
        }
        return ans == nums.length ? -1 : ans;
    }
}