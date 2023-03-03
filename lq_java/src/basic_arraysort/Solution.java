package basic_arraysort;
import java.util.Scanner;

class Solution{
	public static void main(String args[]){
			Scanner s = new Scanner(System.in);
			int n = s.nextInt();
			int[] nums = new int[n];
			for(int i = 0;i<n;++i)
			{
				nums[i] = s.nextInt();
			}
			for (int i = n-1; i >0 ; i--) 
			{
	            boolean flag = true;
	            for(int j=0;j<i;++j)
				{
					if(nums[j]>nums[j+1])
					{
						int temp = nums[j];
						nums[j] = nums[j+1];
						nums[j+1] = temp;
						flag = false;
					}
				}
				if(flag)
					break;
			}
			for(int i = 0;i<n;++i)
			{
				System.out.print(nums[i]);
				if(i!=n-1)
					System.out.print(" ");
			}
	}
}