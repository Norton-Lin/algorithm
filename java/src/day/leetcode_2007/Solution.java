package day.leetcode_2007;
/*
 * @lc app=leetcode.cn id=2007 lang=java
 *
 * [2007] 从双倍数组中还原原数组
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    //排序，检测是否有倍数
    public int[] findOriginalArray(int[] changed) {
        int i = 0, j =1, index = 0;
        if(changed.length %2 == 1)
            return new int[]{};
        Arrays.sort(changed);
        //记录
        //boolean[] judge = new boolean[changed.length];
        int[] ans = new int[changed.length/2];
        for(i = 0;i<changed.length&&j<changed.length;++i){
            //if(judge[i])
            if(changed[i]==-1)
                continue;
            if(j<=i)
                j = i+1;
            while(j<changed.length){
                if(changed[j++] == 2*changed[i]){
                    ans[index++] = changed[i];
                    changed[j-1] = -1;
                    break;
                }
            }
        }
        if(index<ans.length)
            return new int[]{};
        return ans;
    }
}
// @lc code=end

