package test.test_393;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Solution {
    // 十二小时值
    public String findLatestTime(String s) {
        char[] hour = s.substring(0, 2).toCharArray();
        char[] min = s.substring(3).toCharArray();
        if (hour[0] == '?') {
            if (hour[1] != '?' && hour[1] > '1')
                hour[0] = '0';
            else
                hour[0] = '1';
        }
        if (hour[1] == '?') {
            if (hour[0] == '1') {
                hour[1] = '1';
            } else {
                hour[1] = '9';
            }
        }
        if (min[0] == '?')
            min[0] = '5';
        if (min[1] == '?')
            min[1] = '9';
        return new String(hour) + ":" + new String(min);
    }

    // 找素数
    public int maximumPrimeDifference(int[] nums) {
        int index1 = 0;
        int index2 = nums.length - 1;
        while (index1 < nums.length) {
            if (check(nums[index1]))
                break;
            ++index1;
        }
        while (index2 >= index1) {
            if (check(nums[index2]))
                break;
            --index2;
        }
        return index2 - index1;
    }

    public boolean check(int num) {
        boolean ans = true;
        if (num == 1)
            return false;
        for (int i = 2; i < num / 2 + 1; ++i) {
            if (num % i == 0) {
                ans = false;
                break;
            }
        }
        return ans;
    }
    //对硬币组进行轮询，每次拿最小的
    public long findKthSmallest(int[] coins, int k) {
        long ans = 0;
        Set<Long> set = new HashSet<>();
        Arrays.sort(coins);
        PriorityQueue<long[]> queue = new PriorityQueue<>(new Comparator<long[]>() {
            @Override
            public int compare(long[] a, long[] b){
                return (int)(a[0] - b[0]);
            }
        });
        for(int i = 0;i<coins.length;++i){
            boolean judge = true;
            for(long num:set){
                if(coins[i]%num == 0){
                    judge = false;
                    break;
                }
            }
            if(judge){
                queue.add(new long[]{coins[i],coins[i]});
            set.add((long)coins[i]);
            }
            
        }
        if(queue.peek()[0]==1L||queue.size()==1)
            return k*queue.peek()[0];
        while(k>0){
            long[] num = queue.poll();
            ans = num[0];
            long cur = num[0];
            while(set.contains(cur)){
                cur+=num[0];
            }
            set.remove(num[0]);
            set.add(cur);
            queue.add(new long[]{cur,num[0]});

            --k;
        }
        return ans;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        s.findKthSmallest(new int[]{3,6,9}, 4);
    }
}
