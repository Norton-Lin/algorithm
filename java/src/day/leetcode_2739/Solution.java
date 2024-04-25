package day.leetcode_2739;
/*
 * @lc app=leetcode.cn id=2739 lang=java
 *
 * [2739] 总行驶距离
 */

// @lc code=start
class Solution {
    public int distanceTraveled(int mainTank, int additionalTank) {
        int res = 0;
        while(mainTank>0){
            if(mainTank>=5){
                mainTank-=5;
                if(additionalTank>0){
                    mainTank+=1;
                    additionalTank-=1;
                }
                res +=50;
            }else{
                res += mainTank*10;
                mainTank = 0;
            }
        }
        //return Math.min((mainTank-1)/4,additionalTank)*10+mainTank*10;一步到位
        return res;
    }
}
// @lc code=end

