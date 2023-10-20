package leetcode_2525;
/*
 * @lc app=leetcode.cn id=2525 lang=java
 *
 * [2525] 根据规则将箱子分类
 */

// @lc code=start
class Solution {
    public static String[] ans = {"Neither", "Bulky", "Heavy", "Both"};
    public static int len = 10000;
    public static long volum = 1000000000;
    public String categorizeBox(int length, int width, int height, int mass) {
        int index = 0;
        if(mass >= 100)
        {
            index = 2;
            if(length>=len||width>=len||height>=len||(long)length*(long)width*(long)height>=volum)
                index = 3;
        }
        else{
            if(length>=len||width>=len||height>=len||(long)length*(long)width*(long)height>=volum)
                index = 1;
        }
        return ans[index];
    }
}
// @lc code=end

