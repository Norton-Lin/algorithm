
/*
 * @lc app=leetcode.cn id=670 lang=java
 *
 * [670] 最大交换
 */
import java.util.Arrays;

// @lc code=start
class Solution {
    // 贪心，放最大位,找到还没有放到可放最高位的最大数
    public int maximumSwap(int num) {
        char[] arr = Integer.toString(num).toCharArray();
        char[] max = Integer.toString(num).toCharArray();
        Arrays.sort(max);
        for (int j = 0, k = max.length - 1; j < k; ++j, --k) {
            char temp = max[k];
            max[k] = max[j];
            max[j] = temp;
        }
        int i = 0;
        for (i = 0; i < arr.length; ++i)
            if (arr[i] != max[i])
                break;
        if (i != arr.length) {
            for (int j = arr.length - 1; j >= 0; --j) {
                if (arr[j] == max[i]) {
                    char temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return Integer.parseInt(new String(arr));
    }
}
// @lc code=end
