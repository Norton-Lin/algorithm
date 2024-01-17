package day.leetcode_605;

class Solution {
    /*
     * 一维数组表花坛，0表示空，1表示有花，给定一个整数n，
     * 表示要种植的花的数量，问是否可以种植n朵花.
     * 种植的花不能相邻，即相邻的两个位置不能同时为1.
     */
    /**
     * public boolean canPlaceFlowers(int[] flowerbed, int n) {
     * for (int i = 0; i < flowerbed.length && n > 0; ++i) {
     * if (flowerbed[i] == 0) {
     * if (i - 1 >= 0) {
     * if (flowerbed[i - 1] == 0) {
     * if (i + 1 < flowerbed.length) {
     * if (flowerbed[i + 1] == 0) {
     * flowerbed[i] = 1;
     * ++i;
     * --n;
     * }
     * 
     * } else {
     * flowerbed[i] = 1;
     * ++i;
     * --n;
     * }
     * }
     * 
     * } else {
     * if (i + 1 < flowerbed.length) {
     * if (flowerbed[i + 1] == 0) {
     * flowerbed[i] = 1;
     * ++i;
     * --n;
     * }
     * } else {
     * flowerbed[i] = 1;
     * ++i;
     * --n;
     * }
     * }
     * }
     * 
     * }
     * return n == 0;
     * }
     */
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        boolean flag = true;
        for (int i = 0; i < flowerbed.length && n > 0; ++i) {
            if (flowerbed[i] == 1) {
                flag = false;// 前置位为1，后置位不能种花
                continue;
            }
            if (i + 1 < flowerbed.length) {
                if (flowerbed[i + 1] == 0) {
                    if (flag == true) {
                        --n;
                    }
                    flag = !flag;
                }
            }
            if (i + 1 == flowerbed.length&&flag)
                --n;
        }
        return n == 0;
    }
    public static void main(String[] args) {
        int[] flowerbed = { 1, 0, 0,0, 0, 1 };
        int n = 2;
        Solution solution = new Solution();
        System.out.println(solution.canPlaceFlowers(flowerbed, n));
    }
}