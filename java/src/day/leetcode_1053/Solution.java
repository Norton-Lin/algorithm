package day.leetcode_1053;

import java.util.Scanner;

class Solution {
    //一次交换，字典序小于arr,但最大
    //最小序列，不动
    //找后续最大字典序元素，进行交换
    //从后往前 176 -> 167  1867 -> 1768 1 8 7 6 5 4 3 2  1  8 7 6 1 2 3
    //从后往前找递增序列 然后交换最大值和最小值
    public int[] prevPermOpt1(int[] arr) {
        if(arr.length == 1)
            return arr;
        int next = arr[arr.length-1];
        int cur  = arr[arr.length-2];
        int index1 = arr.length - 2;
        int index2 = index1+1;
        int max = next;
        while(index1>=0)
        {
            if(cur>next)
            {
                while(arr[index1] <= arr[index2])
                    --index2;
                while(arr[index2] == arr[index2-1])
                    --index2;
                arr[index1] = arr[index2];
                arr[index2] = cur;
                return arr;
            }
            else
            {
                if(max<cur)
                {
                    max = cur;
                    index2 = index1;
                }
            }
            --index1;
            if(index1<0)
                break;
            next = arr[index1+1];
            cur  = arr[index1];
            
        }
        return arr;
    }
}