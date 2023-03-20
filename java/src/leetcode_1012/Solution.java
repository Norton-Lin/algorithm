package leetcode_1012;


class Solution {
    //组合数学，n转换为字符串
    public int numDupDigitsAtMostN(int n) {
        String sn = String.valueOf(n);
        return n + 1 - f(0, sn, 0, true);
    }
    /**
     * 
     * @param mask	掩码 统计前面填入的数字
     * @param sn	数字字符串
     * @param i		当前填入位
     * @param same	前i位是否相同
     * @return 不重复的字符串
     */
    public int f(int mask, String sn, int i, boolean same) {
    	//已填完
        if (i == sn.length()) {
            return 1;
        }
        //前面填入的数字与 n 对应位置的数字相同，且当前填入的数字为 t；
        //前面填入的数字都是 0，即前缀 0，并且当前填入的数字也为 0。
        int t = same ? sn.charAt(i) - '0' : 9, res = 0, c = Integer.bitCount(mask) + 1;
        for (int k = 0; k <= t; k++) {
            if ((mask & (1 << k)) != 0) {
                continue;
            }
            if (same && k == t) {
                res += f(mask | (1 << t), sn, i + 1, true);
            } else if (mask == 0 && k == 0) {
                res += f(0, sn, i + 1, false);
            } else {
                res += A(sn.length() - 1 - i, 10 - c);
            }
        }
        return res;
    }

    public int A(int x, int y) {
        int res = 1;
        for (int i = 0; i < x; i++) {
            res *= y--;
        }
        return res;
    }
}
