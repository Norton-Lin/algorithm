/*
 * @lc app=leetcode.cn id=206 lang=java
 *
 * [206] 反转链表
 */
package leetcode_206;
class ListNode {
    int val;
   ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
// @lc code=start
class Solution {
    //原地翻转
    public ListNode reverseList(ListNode head) {
        if(head == null)
            return head;
        ListNode cur = head;
        ListNode next = head.next;
        ListNode pre = null;
        while(next!=null){
            cur.next = pre;
            pre = cur;
            cur = next;
            next = next.next;
        }
        cur.next = pre;
        return cur;
    }
}
// @lc code=end

