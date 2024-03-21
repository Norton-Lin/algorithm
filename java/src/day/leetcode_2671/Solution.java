package day.leetcode_2671;
/*
 * @lc app=leetcode.cn id=2671 lang=java
 *
 * [2671] 频率跟踪器
 */

import java.util.HashMap;
import java.util.Map;

// @lc code=start
class FrequencyTracker {
    Map<Integer, Integer> map;
    Map<Integer, Integer> fre;

    public FrequencyTracker() {
        map = new HashMap<>();
        fre = new HashMap<>();
    }

    public void add(int number) {
        map.put(number, map.getOrDefault(number, 0) + 1);
        int num = map.get(number);
        fre.put(num, fre.getOrDefault(num,0) + 1);
        fre.put(num - 1, fre.getOrDefault(num -1 ,0) - 1);
    }

    public void deleteOne(int number) {
        if (map.getOrDefault(number,0)==0)
            return;
        map.put(number, map.get(number) - 1);
        int num = map.get(number);
        fre.put(num, fre.get(num) + 1);
        fre.put(num + 1, fre.get(num+1) - 1);
    }
    public boolean hasFrequency(int frequency) {
        return fre.getOrDefault(frequency, 0) != 0;
    }
}

/**
 * Your FrequencyTracker object will be instantiated and called as such:
 * FrequencyTracker obj = new FrequencyTracker();
 * obj.add(number);
 * obj.deleteOne(number);
 * boolean param_3 = obj.hasFrequency(frequency);
 */
// @lc code=end
