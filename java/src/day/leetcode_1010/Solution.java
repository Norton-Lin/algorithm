package day.leetcode_1010;

import java.util.HashMap;

class Solution {
	//哈希记录 O(n) O(n)
    public int numPairsDivisibleBy60(int[] time) {
        long ans = 0;
        int cur = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i:time)
        {
        	cur = i%60;
        	if(map.containsKey(cur))
        		map.put(cur,map.get(cur)+1);
        	else 
				map.put(cur,1);
        }
        //优化
        for(int i = 1;i<30;++i)
        {
        	if(map.containsKey(i)&&map.containsKey(60-i))
        		ans+=map.get(i)*map.get(60-i);
        }
        if(map.containsKey(0))
        	ans+=(long)map.get(0)*(map.get(0)-1)/2;//注意溢出
        if(map.containsKey(30))
        	ans+=(long)map.get(30)*(map.get(30)-1)/2;
        /**
        for(int i:time)
        {
        	cur = i%60;
        	num = cur==0?0:60-cur;
        	map.put(cur, map.get(cur)-1);
        	if(map.containsKey(num))
        		ans+=map.get(num);
        	
        }**/
        return (int)ans;
    }
    //数组记录余数
    /*
    public int numPairsDivisibleBy60(int[] time) {
        int[] cnt = new int[60];
        for (int t : time) {
            cnt[t % 60]++;
        }
        long res = 0;
        for (int i = 1; i < 30; i++) {
            res += cnt[i] * cnt[60 - i];
        }
        res += (long) cnt[0] * (cnt[0] - 1) / 2 + (long) cnt[30] * (cnt[30] - 1) / 2;
        return (int) res;
    }*/
}
