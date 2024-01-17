package day.leetcode_1669;


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode head = new ListNode();
        ListNode tail = new ListNode();
        ListNode cur = list1;
        int count = 0;
        for(int i =0;i<b;++i,++count,cur = cur.next)
        {
        	if(count == a-1)
        		head = cur;
        }
        tail = cur.next;
        head.next = list2;
        cur = list2;
        while(cur.next!=null)
        	cur = cur.next;
        cur.next = tail;
        return list1;
        
    }
}
