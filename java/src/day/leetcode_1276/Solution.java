/*
 * @lc app=leetcode.cn id=1276 lang=java
 *
 * [1276] 不浪费原料的汉堡制作方案
 */
package day.leetcode_1276;
import java.util.ArrayList;
import java.util.List;
// @lc code=start
class Solution {
    //使剩余原料数为零
    //模拟
    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        List<Integer> ans = new ArrayList<>();
        if(tomatoSlices>4*cheeseSlices||tomatoSlices<2*cheeseSlices||tomatoSlices%2==1)//不可能情况1
            return ans;
        int start = tomatoSlices/2;
        for(int i = start;i>=0;--i){
            if((cheeseSlices-i)*4+i*2 == tomatoSlices){
                ans.add(cheeseSlices-i);
                ans.add(i);
                break;
            }
        }
        return ans;
    }
    /**数学
    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        List<Integer> result = new ArrayList<>(2);

        if(tomatoSlices % 2 != 0 || (tomatoSlices / 2 - cheeseSlices) <0 || (cheeseSlices * 2 - (tomatoSlices / 2))<0){
            return new ArrayList<>();
        }

        result.add(tomatoSlices / 2 - cheeseSlices);
        result.add(cheeseSlices * 2 - tomatoSlices / 2);
        return result;
    }
     */
}
// @lc code=end

