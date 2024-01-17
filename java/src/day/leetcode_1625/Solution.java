package day.leetcode_1625;

class Solution {
    //s是偶数，则若b为偶数，只能对偶数位操作
    public String findLexSmallestString(String s, int a, int b) {
        int n = s.length();
        String res = s;
        s = s + s;
        int g = gcd(b, n);
        //轮转次数是s.length()/gcd(b,s.length)//多了重复
        //每次轮转，都要获取一个最小字典序
        for (int i = 0; i < n; i += g) {
            char[] t = s.substring(i, i + n).toCharArray();//轮转
            add(t, n, a, 1);//奇数位累加
            if (b % 2 != 0) //b不是偶数
                add(t, n, a, 0);//偶数位累加
            String tStr = new String(t);
            if (tStr.compareTo(res) < 0) {
                res = tStr;
            }
        }
        return res;
    }
    public void add(char[] t, int n, int a, int start) {
        int minVal = 10, times = 0;
        for (int i = 0; i < 10; i++) {
            int added = ((t[start] - '0') + i * a) % 10;//获取一个首字符最小字典序
            if (added < minVal) {
                minVal = added;
                times = i;
            }
        }//time是最小轮转次数
        for (int i = start; i < n; i += 2) {
            t[i] = (char) ('0' + ((t[i] - '0') + times * a) % 10);
        }
    }
    //计算公因数
    public int gcd(int num1, int num2) {
        while (num2 != 0) {
            int temp = num1;
            num1 = num2;
            num2 = temp % num2;
        }
        return num1;
    }
}