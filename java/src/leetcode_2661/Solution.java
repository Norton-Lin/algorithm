/*
 * @lc app=leetcode.cn id=2661 lang=java
 *
 * [2661] 找出叠涂元素
 */
package leetcode_2661;
// @lc code=start
class Solution {
    //某一行或列完全上色时，返回当前arr下标
    //邻接表？
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int[][] record = new int[arr.length+1][2];
        int[] row = new int[mat.length];
        int[] col = new int[mat[0].length];
        for(int i = 0;i<mat.length;++i){
            for(int j = 0;j<mat[i].length;++j){
                record[mat[i][j]][0] = i;
                record[mat[i][j]][1] = j;
            }
        }
        int count = 0;
        while(count<arr.length){
            ++row[record[arr[count]][0]];
            ++col[record[arr[count]][1]];
            if(row[record[arr[count]][0]] == mat[0].length||col[record[arr[count]][1]]==mat.length)
                break;
            ++count;
        }
        return count;
    }
}
// @lc code=end

