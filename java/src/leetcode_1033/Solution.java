package leetcode_1033;

import java.util.Arrays;

class Solution {
    //移动直至石子连续
    public int[] numMovesStones(int a, int b, int c) {
        int[] index = new int[3];
        int len1,len2;
        int ans1=0;
        index[0] = a;index[1] = b;index[2] =c;
        Arrays.sort(index);
        len1 = Math.min(index[1]-index[0],index[2]-index[1]);
        len2 = Math.max(index[1]-index[0],index[2]-index[1]);
        if(len2 == 1)
            ans1 = 0;
        else if(len1 == 1||len1 ==2)
            ans1 = 1;
        else 
            ans1 = 2;
        return new int[]{ans1,len1+len2-2};
    }
}