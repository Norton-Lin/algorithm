package test1;

import java.util.Scanner;

public class main {
	public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        int ans1 = 0,ans2 = 0;
        int cur  =0;
        for(int i = 0;i<num;++i)
        {
            cur = scan.nextInt();
            if(cur>=60)
              ans1++;
            if(cur>=85)
              ans2++;
        }
        //在此输入您的代码...
        double res1 = (double)ans1*100/(double)num;
        double res2 = (double)ans2*100/(double)num;
        if(Math.abs(Math.abs(res1)-(double)((int)res1))>5e-1)
          System.out.println((int)(res1)+1);
        else
          System.out.println((int)(res1));
        if(Math.abs(Math.abs(res2)-(double)((int)res2))>5e-1)
          System.out.println((int)(res2)+1);
        else
          System.out.println((int)(res2));
        //System.out.printf("%5.1f", res1);
        System.out.println(String.format("%8.2f", res1));
        
        scan.close();
    }
}
