package day.leetcode_2474;

import java.util.Scanner;

class Solution {
    public int commonFactors(int a, int b) {
    	int num = gcd(a, b);
    	int ans = 0;
    	for(int i = 1;i<=num;++i )
    		if(num%i == 0)
    			++ans;
    	return ans;
    }
    public int gcd(int a,int b)
    {
    	return b == 0?a:gcd(b, a%b);
    }
    public static void main(String args[]) {
    	Scanner in = new Scanner(System.in);
    	Solution solution = new Solution();
    	int a = in.nextInt();
    	int b = in.nextInt();
    	int ans = solution.gcd(a, b);
    	System.out.print(ans);
		in.close();
		
	}
}
