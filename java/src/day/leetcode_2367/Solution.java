package day.leetcode_2367;

class Solution {
    //三指针 O(n)
    public int arithmeticTriplets(int[] nums, int diff) {
        int ans = 0;
        int n = nums.length;
        for (int i = 0, j = 1, k = 2; i < n - 2 && j < n - 1 && k < n; i++) {
            j = Math.max(j, i + 1);
            while (j < n - 1 && nums[j] - nums[i] < diff) {
                j++;
            }
            if (j >= n - 1 || nums[j] - nums[i] > diff) {
                continue;
            }
            k = Math.max(k, j + 1);
            while (k < n && nums[k] - nums[j] < diff) {
                k++;
            }
            if (k < n && nums[k] - nums[j] == diff) {
                ans++;
            }
        }
        return ans;
    }
    /** 
    //哈希 O(n)
    public int arithmeticTriplets(int[] nums, int diff) 
    {
        int ans = 0;
        HashSet<Integer> set = new HashSet<>();
        for(int num:nums)
            set.add(num);
        for(int num:nums)
        {
            if(set.contains(num+diff)&&set.contains(num+2*diff))
                ++ans;
        }
        return ans;
    }
    */
    /** 
    //暴力 O(n^3)
    public int arithmeticTriplets(int[] nums, int diff) {
        int ans = 0;
        for(int i = 0;i<nums.length-2;++i)
        {
            for(int j = i + 1;j<nums.length-1;++j)
            {
                if(nums[j]-nums[i] == diff)
                {
                    for(int k = j+1;k<nums.length;++k)
                    {
                        if(nums[k] - nums[j] == diff)
                            ++ans;
                    }
                }
            }
        }
        return ans;
    }
    */
}
