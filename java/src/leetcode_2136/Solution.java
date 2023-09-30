package leetcode_2136;

import java.util.Arrays;

class Solution {
    //  不能同时播种，一朵花必须先播种完在开花
    //  尽可能并发开花
    //  生长时间越长的话应该越早种，播种时间越短的话应该越晚种
    //  PS: 进一步优化，节省二维空间 -> 记录下标
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        int[][] record = new int[plantTime.length][2];
        int res = 0;
        int len = 0;
        for(int i = 0 ;i<plantTime.length;++i){
            record[i][0] = plantTime[i];
            record[i][1] = growTime[i]+1;
        }
        Arrays.sort(record,(a,b)->{
            if(a[1] == b[1])
                return b[0] - a[0];
            return b[1] - a[1];
        });
        for(int i = 0;i<plantTime.length;++i)
        {
            
            res += record[i][0]; 
            len = Math.max(len,res+record[i][1]);
        }
        return len-1;
    }
    public static void main(String[] args) {
        int[] plantTime = {1,4,3};
        int[] growTime = {2,3,1};
        Solution s = new Solution();
        System.out.println(s.earliestFullBloom(plantTime, growTime));
    }
}