package day.leetcode_2363;

import java.util.ArrayList;
import java.util.List;

class Solution {
	/*
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        for(int i =0;i<items1.length;++i)
            map.put(items1[i][0],items1[i][1]);
        for(int i =0;i<items2.length;++i)
        {
            if(map.containsKey(items2[i][0]))
            	map.put(items2[i][0], map.get(items2[i][0])+items2[i][1]);
            else 
				map.put(items2[i][0], items2[i][1]);
        }
        for(int i: map.keySet())
        {
        	ArrayList<Integer> temp = new ArrayList<Integer>();
        	temp.add(i);
        	temp.add(map.get(i));
        	ans.add(temp);
        }
        Collections.sort(ans, (a,b)-> a.get(0)-b.get(0));
        return ans;
    }*/
	public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        int[] cnt = new int[1001];
        for (var x : items1) {
            cnt[x[0]] += x[1];
        }
        for (var x : items2) {
            cnt[x[0]] += x[1];
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < cnt.length; ++i) {
            if (cnt[i] > 0) {
                ans.add(List.of(i, cnt[i]));
            }
        }
        return ans;
    }
}
