package test;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		//int n = scanner.nextInt();
		//int[] nums = new int[n];
		//for(int i = 0;i<n;++i)
			//nums[i] = scanner.nextInt();
		System.out.println(gcd(3, 10));
		scanner.close();
		
	}
	public static int gcd(int a,int b) {
		return b == 0?a:gcd(b, a%b);
	}
}
