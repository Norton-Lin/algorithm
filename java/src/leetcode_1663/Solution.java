package leetcode_1663;

import java.util.Arrays;

class Solution {
	//什么时候填z? 当k>28-n
	// 5 73 17 abcdefghijklmnopqrs
	//先填充尾部的k
    //再填一个字母
    //剩下全a
    public String getSmallestString(int n, int k) {
        char[] a = new char[n];
        k -= n;
        Arrays.fill(a,'a');
        for(int i=n-1;k>0;i--){
            if(k>25){
                a[i] = 'z';
                k -= 25;
            }else{
                a[i] = (char)('a'+k);
                k -= k;
            }
        }
        return new String(a);
    }
    public static void main(String[] args) {
		Solution s = new Solution();
		String ans = s.getSmallestString(5,73);
		//System.out.print(num);
		System.out.print(ans);
    }
}
