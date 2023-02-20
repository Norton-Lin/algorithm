package leetcode_2347;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public String[] ans = {"Flush", "High Card", "Pair", "Three of a Kind" };
    public String bestHand(int[] ranks, char[] suits) {
        int count = 1;
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        int max = 1 , num = 0;;
        map.put(ranks[0], 1);
        for(int i = 1;i<suits.length;++i)
        {
            if(map.containsKey(ranks[i]))
            {
            	num = map.get(ranks[i]) + 1;
            	map.put(ranks[i], num);
            	if(max<num)
            		max = num;
            		
            }
            else
            	map.put(ranks[i], 1);
            if(suits[0] == suits[i])
                ++count;
        }
        if(count == 5)
            return ans[0];
        if(max>3)
            max = 3;
        return ans[max];
        
    }
}