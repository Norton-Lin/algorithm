package test.test_338;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
		int ans = 0;
		if(numOnes>=k)
			return k;
		else if(numOnes+numZeros>=k)
				return numOnes;
		return numOnes- (k - numOnes - numZeros);
    }
	//选择每个下标执行一次质数减法
	//使nums成为严格递增数组
	//从尾部开始，每次都让nums[i]小于nums[i+1]同时尽量使nums[i]接近nums[i+1]
	//质数范围1-1000
	int[] is_prime = new int[1001];
	int[] prime = new int[1001];
	int count=0;//质数数量
	public boolean primeSubOperation(int[] nums) {
		getprime();
		for(int i = nums.length-2;i>=0;--i)
		{
			if(nums[i]>=nums[i+1])
			{
				int j = 0;
				while(j<count&&nums[i]>prime[j]&&nums[i]-prime[j]>=nums[i+1])
					++j;
				nums[i] = nums[i]-prime[j];
				if(nums[i]>=nums[i+1]||nums[i]<=0)
					return false;
			}
		}
		return true;
    }
	public void getprime()
	{
		is_prime[0]=1;
		is_prime[1]=1;
		for(int i=2;i<1001;i++) {
			if(is_prime[i]==0) {      
				prime[count]=i;
				count++;
			}
			for(int j=0;j<count&&i*prime[j]<1001;j++) {
				is_prime[i*prime[j]]=1;
				if(i%prime[j]==0)
					break;
			}
		}
	}
	//queires.length个查询
	//暴力 queires.length+nums.length 超时
	//前缀和+二分
	public List<Long> minOperations(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int len = nums.length;
        int[] prefix = new int[len+1];
        List<Long> ans = new ArrayList<Long>();
        for(int i = 1;i<=len;++i)
            prefix[i] = prefix[i-1]+nums[i-1];
        for(int query: queries)
        {
            long cur = 0;
            int index = binarySearch(query,nums)+1;
            cur += query*index - prefix[index];
            cur += prefix[len] - prefix[index] - query*(len-index);
            ans.add(cur);
        }
        return ans;
    }
	//手动实现C++ lowwer_bound
    public int binarySearch(int num,int nums[])
    {
        int l = 0;
        int r = nums.length-1;
        int mid = (l+r)/2;
        int ans = -1;
        while(l<=r)
        {
            mid = (l+r)/2;
            if(nums[mid] <= num)
            {
                ans = mid;
                l = mid+1;
            }
            else
                r = mid - 1;
        }
        return ans;
    }
    //好了第四题不会
	public static void main(String args[]) {
		Solution solution = new Solution();
		//boolean ans = solution.primeSubOperation(new int[] {5,8,3});
		List<Long> ansList = solution.minOperations(new int[] {3,1,6,8}, new int[] {1,5});
	}
}


