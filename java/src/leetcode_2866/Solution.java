/*
 * @lc app=leetcode.cn id=2866 lang=java
 *
 * [2866] 美丽塔 II
 */


package leetcode_2866;

import java.util.List;
import java.util.Stack;
// @lc code=start
class Solution {
    // 存在一个下标i，使该下标两侧heights单调不增
    // 且heights<maxHeights
    // 选定一个maxHeights,
    // 对sum1,如果maxHeights[i]>maxHeights[i-1] sum1[i] = sum1[i-1]+maxHeights[i-1]
    // 否则 往前找，最差情况下 O(n^2)
    // 优化往前找这一步
    public long maximumSumOfHeights(List<Integer> maxHeights) {
        long ans = 0;
        // 前向累积值
        long sum1[] = new long[maxHeights.size()];
        // 后向累积值
        long sum2[] = new long[maxHeights.size()];
        Stack<Long> stack = new Stack<>();
        Stack<Integer> index = new Stack<>();
        sum1[0] = 0;
        stack.push((long)maxHeights.get(0));
        index.push(0);
        for (int i = 1; i < sum1.length; ++i) {
            if (maxHeights.get(i) >= maxHeights.get(i - 1))
                sum1[i] = sum1[i - 1] + (long)maxHeights.get(i - 1);
            else {
                while (!stack.empty()&&stack.peek() > maxHeights.get(i)) {
                    stack.pop();
                    index.pop();
                }
                if(stack.empty())
                    sum1[i] = (i)*(long)maxHeights.get(i);
                else
                    sum1[i] = sum1[index.peek()] + stack.peek() + (long)maxHeights.get(i) * (long)(i - index.peek()-1);
                stack.push((long)maxHeights.get(i));
                index.push(i);

            }
            stack.push((long)maxHeights.get(i));
            index.push(i);
        }
        sum2[sum2.length - 1] = 0;
        stack.clear();
        index.clear();
        stack.push((long)maxHeights.get(maxHeights.size()-1));
        index.push(maxHeights.size()-1);
        for (int i = sum2.length - 2; i >= 0; --i) {
            if (maxHeights.get(i) >= maxHeights.get(i + 1))
                sum2[i] = sum2[i + 1] + (long)maxHeights.get(i + 1);
            else {
                while (!stack.empty()&&stack.peek() > maxHeights.get(i)) {
                    stack.pop();
                    index.pop();
                }
                 if(stack.empty())
                    sum2[i] = (long)(sum2.length-i-1)*(long)maxHeights.get(i);
                else
                    sum2[i] = sum2[index.peek()] + stack.peek() + (long)maxHeights.get(i) * (long)(index.peek()-i-1);

            }
            stack.push((long)maxHeights.get(i));
            index.push(i);
        }
        for (int i = 0; i < sum1.length; ++i) {
            ans = Math.max(sum1[i] + sum2[i] + (long) maxHeights.get(i), ans);
        }
        return ans;
    }
}
// @lc code=end
