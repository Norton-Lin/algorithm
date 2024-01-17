package day.leetcode_1173;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

class Solution {
	//暴力超时
    public int capacity = 0;
    int[][] stacks;
    HashMap<Integer, Integer> map ;
    PriorityQueue<Integer> queue1;//空位
    PriorityQueue<Integer> queue2;//有值
    //优先队列，一个队列维护有值，一个队列维护空位,太慢哩
    public Solution(int capacity) {
        this.capacity = capacity;
        stacks = new int[200001][capacity];
        map = new HashMap<>();//记录栈内元素数
        queue1 = new PriorityQueue<>((o1,o2)->(o1-o2));
        queue2 = new PriorityQueue<>((o1,o2)->(o2-o1));
        for(int i = 0;i<stacks.length;++i)
        {
            map.put(i,0);
            queue1.add(i);
        }
    }
    
    public void push(int val) {
        //必然有位置
    	int index = queue1.peek();
    	int cap = map.get(index);
        stacks[index][cap] = val;
        map.put(index,cap+1);
        if(cap == capacity-1)//无空位了
        	queue1.remove();
        if(cap == 0)//本无值
        	queue2.add(index);
        	
    }
    public int pop() {
    	if(queue2.isEmpty())
    		return -1;
    	int index = queue2.peek();
    	int cap = map.get(index);
    	while(cap == 0&&!queue2.isEmpty())//被popAtStack处理过
    	{
    		queue2.poll();
    		index = queue2.peek();
    		cap = map.get(index);
    	}
    	if(cap == 0)
    		return -1;
    	map.put(index, cap-1);
    	if(cap == 1)//移除后不在有值
    		queue2.remove();
    	if(cap == capacity)//移除后有空位
    		queue1.add(index);
    	return stacks[index][cap-1];
    }
    
    public int popAtStack(int index) {
        //此处已经可以O(1)
    	if(map.get(index) ==0)
    		return -1;
    	int cap = map.get(index);
    	map.put(index, cap-1);
    	if(cap == capacity)//将有空位
    		queue1.add(index);
    	return stacks[index][cap-1];
    }
    public static void main(String args[]) {
    	Solution solution = new Solution(1);
    	solution.push(1);
    	solution.push(2);
    	solution.push(3);
    	solution.popAtStack(1);
    	solution.pop();
    	solution.pop();
	}
}


/**
 * Your DinnerPlates object will be instantiated and called as such:
 * DinnerPlates obj = new DinnerPlates(capacity);
 * obj.push(val);
 * int param_2 = obj.pop();
 * int param_3 = obj.popAtStack(index);
 */