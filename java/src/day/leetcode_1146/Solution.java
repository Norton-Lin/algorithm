package day.leetcode_1146;
/*
 * @lc app=leetcode.cn id=1146 lang=java
 *
 * [1146] 快照数组
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.RowFilter.Entry;
// @lc code=start
//暴力存会超限制
//哈希 或者 二分lowerbound
/**
class SnapshotArray {
    int id;
    List<Map<Integer,Integer>> record;
    Map<Integer,Integer> cur;
    //只有在对元素有修改的时候，才记录，记录修改后的值和对应快照
    public SnapshotArray(int length) {
        id = 0;
        record = new ArrayList<>();
        cur = new HashMap<>();
    }
    
    public void set(int index, int val) {
        cur.put(index,val);
    }
    
    public int snap() {
        record.add(new HashMap<Integer,Integer>(cur));
        cur.clear();
        return id++;
    }
    //找该index的最近一次修改
    public int get(int index, int snap_id) {
        for(int i = snap_id;i>=0;--i)
            if(record.get(i).containsKey(index))
                return record.get(i).get(index);
        return 0;
    }
}*/
class SnapshotArray {

    private int snapId;
    private ArrayList<int[]>[] record;

    public SnapshotArray(int length) {
        record = new ArrayList[length];
        Arrays.setAll(record, e -> new ArrayList<>());
    }

    public void set(int index, int val) {
        record[index].add(new int[] { snapId, val });
    }

    public int snap() {
        return snapId++;
    }

    public int get(int index, int snap_id) {
        int t = binarySearch(index, snap_id);
        return t == -1 ? 0 : record[index].get(t)[1];
    }
    //二分优化 lowerbound
    private int binarySearch(int index, int snap_id) {
        if (record[index].isEmpty()) {
            return -1;
        }
        int l = 0, r = record[index].size() - 1;
        while (l < r) {
            int mid = l + ((r - l + 1) >> 1);
            int t = record[index].get(mid)[0];
            if (t <= snap_id) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return record[index].get(l)[0] <= snap_id ? l : -1;
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */
// @lc code=end

