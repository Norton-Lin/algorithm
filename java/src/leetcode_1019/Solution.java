package leetcode_1019;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Stack;

class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
};

class Solution {
	/**
	 * 暴力模拟
	 * @param head
	 * @return
	 */
	/**
    public int[] nextLargerNodes(ListNode head) {
        ListNode cur = head;
        int len = 1;
        while(cur.next!=null)
        {
        	++len;
        	cur = cur.next;
        }
        int[] ans = new int[len];
        cur = head;
        for(int i = 0;i<len;++i)
        {
        	ListNode tmp= cur;
        	while(tmp.next!=null&&cur.val>=tmp.next.val)
        		tmp = tmp.next;
        	if(tmp.next!=null)
        		ans[i] = tmp.next.val;
        	else 
        		ans[i] = 0;
        	cur = cur.next;
        }
        return ans;
    }*/
	/**
	 * 单调栈
	 * @param head
	 * @return
	 */
	/*
	public int[] nextLargerNodes(ListNode head) {
		ListNode cur = head;
		Stack<Integer[]> st = new Stack<>();
        int len = 1;
        int index = 0;
        while(cur.next!=null)
        {
        	++len;
        	cur = cur.next;
        }
        int[] ans = new int[len];
        cur = head;
        st.push(new Integer[]{cur.val,index});
        while(cur.next!=null)
        {
        	if(!st.empty())
        		while(!st.empty()&&cur.next.val>st.peek()[0])
            		ans[st.pop()[1]] = cur.next.val;
        	cur = cur.next;
        	++index;
        	st.push(new Integer[]{cur.val,index});
        	
        }
        return ans;
        
	}*/
	//单调栈优化
	public int[] nextLargerNodes(ListNode head) {
        List<Integer> nums = new ArrayList<>();
        for (; head != null; head = head.next) {
            nums.add(head.val);
        }
        Deque<Integer> stk = new ArrayDeque<>();
        int n = nums.size();
        int[] ans = new int[n];
        for (int i = n - 1; i >= 0; --i) {
            //从后往前看
            while (!stk.isEmpty() && stk.peek() <= nums.get(i)) {
                stk.pop();
            }
            if (!stk.isEmpty()) {
                ans[i] = stk.peek();
            }
            stk.push(nums.get(i));
        }
        return ans;
    }
    public static void main(String agrs[]) {
    	Solution s = new Solution();
    	ListNode s1 = new ListNode(5);
    	ListNode s2 = new ListNode(3,s1);
    	ListNode s3 = new ListNode(4,s2);
    	ListNode s4 = new ListNode(7,s3);
    	ListNode s5 = new ListNode(2,s4);
    	int[] arr = s.nextLargerNodes(s5);
		
	}
}