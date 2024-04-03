/*
 * @lc app=leetcode.cn id=2233 lang=java
 *
 * [2233] K 次增加后的最大乘积
 */
import java.util.Arrays;
import java.util.PriorityQueue;
// @lc code=start
class Solution {
    //最小值一直加就行
    public int maximumProduct(int[] nums, int k) {
        Arrays.sort(nums);
        int count=0;
        int MOD=1000000007;
        long ans=1;
        int n=nums.length;
        while(count<k){
            nums[0]++;
            count++;
            int j=1;
            while(j<n&&nums[j]<nums[j-1]&&count<k){
                nums[j]++;
                count++;
                j++;
            }
        }
        for(int i=0;i<n;i++){
            ans*=nums[i];
            ans%=MOD;
        }

        return (int)ans;

    }
    /** 优先队列
    public int maximumProduct(int[] nums, int k) {
        long mod = 1000000007;
        long ans = 1;
        PriorityQueue<Long> queue = new PriorityQueue<>();
        for(int num:nums)
            queue.add((long)num);
        while(k>0){
            long cur = queue.poll();
            queue.add(cur+1);
            --k;
        }
        while(!queue.isEmpty()){
            ans = (ans*queue.poll())%mod;
        }
        return (int)ans;
    }*/
}
// @lc code=end

