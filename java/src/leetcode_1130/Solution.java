package leetcode_1130;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

class Solution {
	//类哈夫曼构建，尽可能将最小价值的结点往下放
    //arr要按顺序
    //合并arr中最小的元素
    //构建链表，链表合并，保存叶结点最大值即可
	//O(n^2)
	/*
    public int mctFromLeafValues(int[] arr) {
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	int ans = 0;
    	int index = 0;
    	int cur = 0;
    	int min = Integer.MAX_VALUE;
    	for(int i:arr)
    		list.add(i);
    	while(list.size()>1)
    	{
    		min = Integer.MAX_VALUE;
    		for(int i =1;i<list.size();++i)
    		{
    			cur = list.get(i)*list.get(i-1);
    			if(min > cur)
    			{
    				min = cur;
    				index = i;
    			}
    		}
    		ans+=min;
    		cur = Math.max(list.get(index), list.get(index-1));//获取最大叶结点
    		list.remove(index);
    		list.add(index, cur);
    		list.remove(index-1);
    	}
    	return ans;
    }*/
    //单调栈 O(n)
	public int mctFromLeafValues(int[] arr) {
		int ans = 0;
		Deque<Integer> stack = new ArrayDeque<Integer>();
		for(int i:arr) {
			//让栈内元素严格递减
			while(!stack.isEmpty()&&stack.peek()<=i)//栈顶元素比较小
			{
				int top = stack.pop();
				
				if(stack.isEmpty()||stack.peek()>i)//栈空或栈顶个元素更大
					ans += i * top;
				else {
					ans += stack.peek() * top;//合并，添加代价
				}
			}
			stack.push(i);//入栈
		}
		while(stack.size()>1) {
			int top = stack.pop();
			ans+=top*stack.peek();
		}
		return ans;
	}

    public static void main(String args[]) {
    	Solution solution = new Solution();
    	int ans = solution.mctFromLeafValues(new int[] {6,2,4});
		
	}
}