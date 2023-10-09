package leetcode_2578;

import java.util.Arrays;

class Solution {
    //将num分割为两个非负整数，num1，num2
    //num1，num2中出现的数经过重新排列可以组合为num
    //求num1+num2的最小值
    //num没有前导0，num1可以有前导0
    /** 纯数字处理
     public int splitNum(int num) {
        int num1 = 0;
        int num2 = 0;
        int len = 0;//num长度
        int record[];
        num1 = num;
        while(num1!=0)
        {
            num1/=10;
            ++len;
        }
        record = new int[len];
        for(int i = 0;i<len;++i)
        {
            record[i] = num%10;
            num/=10;
        }
        Arrays.sort(record);
        for(int i = 0;i<len;++i)
        {
            if(i%2==0)
                num1 = num1*10+record[i];
            else{
                num2 = num2*10+record[i];
            }
        }
        return num1+num2;
    }
     */
    public int splitNum(int num) {
        //整形数组转字符数组
        char arr[] = Integer.toString(num).toCharArray();
        Arrays.sort(arr);
        int num1 = 0,num2 = 0;
        for(int i = 0;i<arr.length;++i)
        {
            if(i%2 == 0)
                num1 = num1*10+arr[i]-'0';
            else
                num2 = num2*10+arr[i]-'0';
        }
        return num1+num2;
    }

}
