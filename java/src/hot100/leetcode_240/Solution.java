/*
 * @lc app=leetcode.cn id=240 lang=java
 *
 * [240] 搜索二维矩阵 II
 */
package hot100.leetcode_240;
// @lc code=start
class Solution {
    //O(nlogn)
    /**
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int i = 0;i<matrix.length;++i){
            if(binarySearch(matrix[i], target))
                return true;
        }
        return false;
    }
    public boolean binarySearch(int[] row, int target) {
        int left = 0, right = row.length - 1;
        int mid = (left + right)/2;
        while(left <= right){
            mid = (left + right)/2;
            if(row[mid] == target)
                return true;
            else if(row[mid]<target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return false;
    }*/
    //优化 O(n)
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0,j = matrix[0].length-1;
        while(i<matrix.length&&j>=0){
            if(matrix[i][j] == target)
                return true;
            else if(matrix[i][j]<target)
                ++i;
            else
                --j;
        }
        return false;
    }
}
// @lc code=end

