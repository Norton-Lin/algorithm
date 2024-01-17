/*
 * @lc app=leetcode.cn id=1410 lang=java
 *
 * [1410] HTML 实体解析器
 */
package day.leetcode_1410;
// @lc code=start
class Solution {
    public String entityParser(String text) {
        text.replaceAll("&quot;", "\"");
        text.replaceAll("&apos;" , "\'");
        text.replaceAll("&amp;", "&");
        text.replaceAll("&gt;", "<");
        text.replaceAll("lt;", ">");
        text.replaceAll("&frasl;", "\\");
        return text;
    }
}
// @lc code=end

