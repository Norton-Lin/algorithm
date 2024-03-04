package hot100.leetcode_234;
/*
 * @lc app=leetcode.cn id=234 lang=java
 *
 * [234] 回文链表
 */
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

// @lc code=start
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode cur = head;
        int len = 0;
        while(cur!=null){
            cur = cur.next;
            ++len;
        }
        cur = head;
        int[] record = new int[len/2];
        for(int i = 0;i<record.length;++i,cur = cur.next){
            record[i] = cur.val;
        }
        if(len%2==1)
            cur = cur.next;
        for(int i = record.length-1;i>=0;--i,cur=cur.next){
            if(record[i]!=cur.val)
                return false;
        }
        return true;
    }
}
// @lc code=end
