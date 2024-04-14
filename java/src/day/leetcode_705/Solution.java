package day.leetcode_705;
/*
 * @lc app=leetcode.cn id=705 lang=java
 *
 * [705] 设计哈希集合
 */

// @lc code=start
class MyHashSet {
    public boolean[] map = new boolean[1000001];
    public MyHashSet() {

    }
    
    public void add(int key) {
        map[key] = true;
    }
    
    public void remove(int key) {
        map[key] = false;
    }
    
    public boolean contains(int key) {
        return map[key];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
// @lc code=end

