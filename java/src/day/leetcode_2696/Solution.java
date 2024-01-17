/*
 * @lc app=leetcode.cn id=2696 lang=java
 *
 * [2696] 删除子串后的字符串最小长度
 */
package day.leetcode_2696;
// @lc code=start
class Solution {
    public int minLength(String s) {
        StringBuffer str = new StringBuffer(s);
        while(true){
            int count = str.length();
            for(int i = 0;i<str.length();++i){
                if(str.charAt(i)=='A'){
                    if(i<str.length()-1){
                        if(str.charAt(i+1) == 'B'){
                            str.replace(i, i+2, "");
                            break;
                        }
                    }
                }
                else if(str.charAt(i) == 'C'){
                    if(i<str.length()-1){
                        if(str.charAt(i+1) == 'D'){
                            str.replace(i, i+2, "");
                            break;
                        }
                    }
                }
                --count;
            }
            if(count ==0)
                break;
        }
        return str.length();
    }
}
// @lc code=end

