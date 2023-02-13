package leetcode_1234;

//滑动窗口
class Solution {
	int n;
    public int balancedString(String s) {
        char[] cs = s.toCharArray();
        n = s.length();
        int ans = n;
        int[] charCount = new int[26];
        for (char c: cs) {
            charCount[c - 'A'] += 1;
        }

        //[left, right]
        int left = 0;
        for (int right = 0; right < n; right++) {
            charCount[cs[right] - 'A'] -= 1;
            while (left < n && valid(charCount)) {
                ans = Math.min(ans, right - left + 1);
                charCount[cs[left] - 'A'] += 1;
                left += 1;
            }
        }
        return ans;
    }
    private boolean valid(int[] charCount) {  
        return charCount['Q' - 'A'] <= n / 4
        && charCount['W' - 'A'] <= n / 4
        && charCount['E' - 'A'] <= n / 4
        && charCount['R' - 'A'] <= n / 4;
    }
}
