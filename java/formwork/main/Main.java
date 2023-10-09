package main;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		System.out.println(phi(10));
		//BigInteger numBigInteger = new BigInteger("2353252525523532");
		in.close();
	}
	/**
	 * 最大公因数
	 * @param a 大数
	 * @param b 小数
	 * @return 最大公因数
	 */
	public static int gcd(int a,int b) {
		return b == 0?a:gcd(b, a%b);
	}
	/**
	 * 最小公倍数
	 * @param a 大数
	 * @param b 小数
	 * @return 最小公倍数
	 */
	public int lcm(int a,int b) {
		return a*b/gcd(a, b);
	}
	
	/**
	 * 01 背包
	 */
	public void f()
	{
		Scanner in = new Scanner(System.in);
		int m = in.nextInt();
		int n = in.nextInt();
		int[] dp = new int[m+5];//dp[i]剩余容积为i,价值为dp[i]
		for(int i = 0;i<n;++i)//n个物品
		{
			int v =in.nextInt();
			int w =in.nextInt();
			for(int j = m;j>=v;--j)
			{
				dp[j] = Math.max(dp[j], dp[j-v]+w);
			}
		}
		System.out.println(dp[m]);
	}
	
	/**
	 * 完全背包
	 */
	public void ff()
	{
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		int[] dp = new int[m+5];
		for(int i = 0 ;i<n;++i)
		{
			int v = sc.nextInt();
			int w = sc.nextInt();
			for(int j =v;j<=m;++j)
				dp[j] = Math.max(dp[j], dp[j-v]+w);
		}
		System.out.print(dp[m]);
		sc.close();
		return;
	}
	
	/**
	 * 快速幂
	 * @param base
	 * @param power
	 * @return
	 */
	public long fastPower(long base, long power)
	{
		long ans = 1;
		while(power >0)
		{
			if(power%2==1)
				ans = ans*base%1000;//取末尾位数,收集分离的底数
			power/=2;
			base = base*base%1000;
		}
		return ans;
	}
	/**
	 * 快速幂位运算优化
	 * @param base
	 * @param power
	 * @param imporve
	 * @return
	 */
	public long fastPower(long base,long power ,boolean imporve)
	{
		
		long ans = 1;
		while(power >0)
		{
			if(((power&1) == 1))
				ans = ans*base%1000;
			power>>=1;
			base = base*base%1000;
		}
		//(x*y-(x/mod*y)*mod+mod)%mod;    
		return ans;
	}
	/**
	 * 欧拉函数，返回<n的所有与n互质的数
	 * @param n
	 * @return
	 */
	public static long phi(long n) {
		long res = n,a = n;
		for(int i = 2;i*i<=n;++i)
		{
			while(a%i==0)
			{
				res = res/a*(a-1);
				a /= i;
			}
		}
		if(a>1)
			res = res/a*(a-1);
		return res;
	}
	//因式分解，不含因子1的分解
	public int Factorization(int n)
	{
		int total = 0;
		if(n == 1)
			return 1;
		for(int i = 2;i<=n;++i)
			if(n%i== 0)
				total+=Factorization(n/i);
		return total;
	}
	//半数集
	public int half(int n)
    {
    	int res=1;
    	for(int i=1;i<=n/2;i++)
    	{
    		res+=half(i);
    	}
    	return res;
    }
	//lowerBound手动实现
	public int lowerBound(int[] nums,int l ,int r,int target) {
		while(l<r) {
			int m = (l+r)/2;
			if(nums[m] >= target)
				r = m-1;
			else {
				l = m+1;
			}
		}
		return l;
	}
	//欧拉筛，获得范围内质数数量
	public void getprime()
	{
		int[] is_prime = new int[1001];
		int[] prime = new int[1001];
		int count=0;//质数数量
		is_prime[0]=1;
		is_prime[1]=1;
		for(int i=2;i<1001;i++) {
			//是质数
			if(is_prime[i]==0) {      
				prime[count]=i;
				count++;
			}
			//每个合数只标记一次
			for(int j=0;j<count&&i*prime[j]<1001;j++) {
				is_prime[i*prime[j]]=1;
				if(i%prime[j]==0)
					break;
			}
		}
	}
	/**
	 * 二分查找
	 * @param nums
	 * @param l
	 * @param r
	 * @param target
	 * @return
	 */
	public int binarySearch(int[] nums,int l,int r,int target)
	{
		int mid ;
		while(l<r)
		{
			mid = (l+r)/2;
			if(target == nums[mid])
				return mid;
			else if(target>nums[mid])
				r= mid - 1;
			else {
				l = mid+1;
			}
		}
		return -1;
	}
	/**
	 * 
	 * @param nums
	 * @return
	 */
	public int quicksort1(int[][] nums1,Integer[] nums2,List<Integer> temp)
	{
		Arrays.sort(nums1, (o1,o2)->(o1[0]-o2[0]));
		Arrays.sort(nums2,(o1,o2)->(o2-o1));
		Collections.sort(temp,new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				
				return o1 - o2;
			}
		});
		return 0;
		
	}
	public void quicksort2(int[] arr,int l,int r)
	{
		if(l>=r)
			return ;
		int i = l - 1;
		int j = r + 1;
		int x = arr[l+((r-l)>>1)];//选取数组中间的那个数作为分界点，把数组分成两部分
		while(i<j)
		{
			do {
				i++;
			}while(arr[i]<x);
			do {
				--j;
			}while(arr[j]>x);
			if(i<j)
			{
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		quicksort2(arr, l, j);
		quicksort2(arr, j+1, r);
		/**
		 * 另一个模板
		 * if(left>right) {
			return;
		}
        //基准数
		int base=arr[left];
        //定义游标i、j
		int i=left;
		int j=right;
        //i和j没有相遇时交换两个数
		while(i!=j) {
			while(arr[j]>=base&&i<j) {
				j--;
			}
			while(arr[i]<=base&&i<j) {
				i++;
			}
            //交换
			int temp=arr[j];
			arr[j]=arr[i];
			arr[i]=temp;
		}
        //i和j相遇交换基准数和游标指向的数
		arr[left]=arr[i];
		arr[i]=base;
        //继续进行递归
		quicksort(arr, left, i-1);
		quicksort(arr, i+1, right);
		 */
	}
}
