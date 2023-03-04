package leetcode_982;
class Solution {
    public int countTriplets(int[] A) {
        //遍历数组， 确定形如100..00的上界， 以便之后可以用k-1作为掩码
        int k = 1;
        for(int item:A){
            while(k<=item){
                k<<=1;
            }
        }
        //记录对于每个特定的值， 数组里位或他能等于0的元素数量
        int[] mem = new int[k];
        for(int item:A){
            //所有1的位置和item完全无重合的值位与item都是0， 需要在特定mask之下降序遍历
            int mask = (k-1)^item;
            int i=mask;
            while(true){
                mem[i]++;
                if(i==0)break;
                i=(i-1)&mask;//关键算法，别记错了
            }
        }
        int ans = 0;
        for(int a:A){
            for(int b:A){
                //利用之前的mem累加出答案
                ans+=mem[a&b];
            }
        }
        return ans;
    }
}
/*
class Solution {
    //一个数字，一种
    //两个数字，三种
    //三个数字，六种
	//暴力
    public int countTriplets(int[] nums) 
    {
        int ans = 0;
        for(int i =0;i<nums.length;++i)
        {
            for(int j = i;j<nums.length;++j)
            {
                int cur = nums[i]&nums[j];
                for(int k = j;k<nums.length;++k)
                {
                    if((int)(cur&nums[k]) == 0)
                    {
                        if(i == j && i == k)
                            ans++;
                        else if(i!=j&&i!=k&&j!=k)
                            ans+=6;
                        else 
                        	ans+=3;
                    }
                }
            }
        }
        return ans;
    }
}*/


