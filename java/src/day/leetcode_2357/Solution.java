package day.leetcode_2357;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int minimumOperations(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for(int i: nums)
            set.add(i);
        if(set.contains(0))
            return set.size()-1;
        return set.size();
    }
}