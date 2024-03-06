/*
 * @lc app=leetcode.cn id=2917 lang=java
 *
 * [2917] 找出数组中的 K-or 值
 */

// @lc code=start
class Solution {
    //统计位上1的数量
    /**
    public int findKOr(int[] nums, int k) {
        int[] arr = new int[32];
        int count = 0;
        int ans = 0;
        for(int num:nums){
            count = 0;
            while(num!=0){
                arr[count] += num%2;
                num/=2;
                ++count;
            }
        }
        for(int i = 0;i<arr.length;++i)
            if(arr[i]>=k)
                ans+=Math.pow(2,i);
        return ans;
    } */
    //优化位运算
    public int findKOr(int[] nums, int k){
        int ans = 0;
        int cur = 0;
        for(int i = 0;i<32;++i){
            cur = 0;
            for(int num:nums){
                cur+= num>>i&1;
            }
            if(cur>=k)
                ans += Math.pow(2,i);
        }
        return ans;
    }
}
// @lc code=end

