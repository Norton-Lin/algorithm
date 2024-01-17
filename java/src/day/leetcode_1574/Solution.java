package day.leetcode_1574;

class Solution {
    //清除一个连续子序列，使剩下的元素非递减
    //去头，去尾
    public int findLengthOfShortestSubarray(int[] arr) {
    	int len = arr.length-1;
        int ans = len;
        int index1 =0,index2=len;//分别记录头尾连续非递减序列
        //去尾 (0,index1)是递减序列
        for(int i = 1;i<arr.length&&arr[i]>=arr[i-1];++i)
            index1 = i;
        if(index1==len)
            return 0;
        ans = Math.min(len-index1,ans);
        //去头 (index2,len-1)是递减序列
        for(int i = arr.length-2;i>=0&&arr[i]<=arr[i+1];--i)
        	index2 = i;
        ans = Math.min(index2,ans);
        //去头尾，得优化O(n^2),剪枝O(n)
        for(int i = index1;i>=0&&index2-i-1<ans;--i)//满足arr[i-1]<=arr[i]
        {
        	for(int j = index2;j<=len&&j-i-1<ans;++j)//满足arr[j]<=arr[j+1]
        	{
        		if(arr[i]<=arr[j])
        			ans = j-i-1;
        	}
            
            
        }
        //接下来不存在 arr[0]>arr[len-1]
        
        return ans;
    }
}