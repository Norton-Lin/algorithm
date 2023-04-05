package lq_test;


import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static int a = 2021;
	static int b = 999999999;
	static int p = 1000000007;
	public static void main(String args[]) {
		/**
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();//询问数
		int[] ans = new int[n];
		for(int i = 0;i<n;++i)
		{
			ans[i] = getAns(scanner.nextInt());
		}
		for(int i = 0;i<n;++i)
			System.out.println(ans[i]);
			**/
		//System.out.println(pow(a, p - 2) * b % p);
		System.out.println(gcd(2, 3));
	}
	static int gcd(int a,int b)
	{
		return b==0?a:gcd(b, a%b);
	}
    static long pow(int a, int n) {
        if (n == 1) return a;
        long res = pow(a, n >> 1);
        res = res * res % p;
        return (n & 1) == 1 ? res * a % p : res;
    }
	public static int getAns(int len)
	{
		Scanner scanner = new Scanner(System.in);
		int[] arr = new int[len];
		int sum = 0;
		for(int i = 0;i<len;++i)
		{
			arr[i] =scanner.nextInt();
			sum^=arr[i];
		}
		if(sum == 0)
			return 0;
		Arrays.sort(arr);
		
		
		return 0;
	}
}
