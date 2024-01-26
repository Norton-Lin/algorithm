/*
 * @lc app=leetcode.cn id=2865 lang=java
 *
 * [2865] 美丽塔 I
 */
package day.leetcode_2865;
import java.util.*;
// @lc code=start
class Solution {
    //单调栈+动态归划
    //left,right记录当某山峰是最高点,其左右侧的累积高度
    //单调栈要存储数组下标和值
    public long maximumSumOfHeights(List<Integer> maxHeights) {
        Stack<long[]> stack = new Stack<>();
        long left[] = new long[maxHeights.size()];
        long right[] = new long[maxHeights.size()];
        long ans = 0;
        stack.push(new long[]{0,-1});
        left[0] = maxHeights.get(0);
        stack.push(new long[]{maxHeights.get(0),0});
        for(int i = 1;i<left.length;++i){
            long height = maxHeights.get(i);
            long sum = 0;
            while(height<stack.peek()[0]){
                long[] top =stack.pop();
                sum -= top[0]*(top[1]-stack.peek()[1]);
            }
            sum += height*(i-stack.peek()[1]);
            stack.push(new long[]{height,i});
            left[i] = left[i-1]+sum;
        }
        stack.clear();
        stack.push(new long[]{0,maxHeights.size()});
        stack.push(new long[]{maxHeights.get(maxHeights.size()-1),maxHeights.size()-1});
        right[maxHeights.size()-1] = maxHeights.get(maxHeights.size()-1);
        for(int i = maxHeights.size()-2;i>=0;--i){
            long height = maxHeights.get(i);
            long sum = 0;
            while(height<stack.peek()[0]){
                long[] top =stack.pop();
                sum -= top[0]*(stack.peek()[1]-top[1]);
            }
            sum += height*(stack.peek()[1]-i);
            stack.push(new long[]{height,i});
            right[i] = right[i+1]+sum;
        }
        for(int i = 0;i<left.length;++i){
            ans = Math.max(ans,left[i]+right[i]-maxHeights.get(i));
        }
        return ans;
    }
    public static void main(String args[]){
        Solution s = new Solution();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(3);
        list.add(4);
        list.add(1);
        list.add(1);
        s.maximumSumOfHeights(list);
    }
}
// @lc code=end

