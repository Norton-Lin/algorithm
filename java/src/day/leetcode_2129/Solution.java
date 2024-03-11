package day.leetcode_2129;
/*
 * @lc app=leetcode.cn id=2129 lang=java
 *
 * [2129] 将标题首字母大写
 */

// @lc code=start
class Solution {
    //分割由空格决定
    public String capitalizeTitle(String title) {
        title = title.toLowerCase();
        StringBuilder s = new StringBuilder();
        int j = 0;
        for(int i = 0;i<title.length();++i){
            if(title.charAt(i)!=' ')
                continue;
            else{
                if(i - j > 2){
                    s.append(title.substring(j,j+1).toUpperCase());
                    s.append(title.substring(j+1, i+1));
                }else{
                    s.append(title.substring(j, i+1));
                }
                j = i + 1;
                ++i;
            }
        }
        if(title.length() - j > 2){
            s.append(title.substring(j,j+1).toUpperCase());
            s.append(title.substring(j+1, title.length()));
        }else{
            s.append(title.substring(j, title.length()));
        }
        return s.toString();
    }
}
// @lc code=end

