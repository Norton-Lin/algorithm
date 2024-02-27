package hot100.leetcode_76;
/*
 * @lc app=leetcode.cn id=76 lang=java
 *
 * [76] 最小覆盖子串
 */

// @lc code=start
class Solution {
    //双指针循环移动
    //扩展右指针，直到覆盖所有t内字符
    //如何记录 t内字符？ 哈希
    //答案唯一
    public String minWindow(String s, String t) {
        int[] cnt1 = new int[52];
        int[] cnt2 = new int[52];
        int count = 0;
        String ans = "";
        for(char c:t.toCharArray()){
            if(++cnt1[getIndex(c)] == 1)
                ++count;
        }
        for(int i = 0, j = 0;i<s.length();++i){
            int idx1 = getIndex(s.charAt(i));
            if(++cnt2[idx1] == cnt1[idx1])
                --count;
            while(j<i){
                int idx2 = getIndex(s.charAt(j));
                if(cnt2[idx2]>cnt1[idx2] && --cnt2[idx2]>=0)
                    ++j;
                else break;
            }
            if(count == 0&&(ans.length() == 0||ans.length()>i-j+1))
                ans = s.substring(j, i+1);
        }
        return ans;
    }
    public int getIndex(char c){
        if(c<='z'&&c>='a')
            return c-'a';
        return c-'A'+26;
    }
}
// @lc code=end

