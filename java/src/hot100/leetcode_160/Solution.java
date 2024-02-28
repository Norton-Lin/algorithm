package hot100.leetcode_160;
/*
 * @lc app=leetcode.cn id=160 lang=java
 *
 * [160] 相交链表
 */

// @lc code=start
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int len1 = 0;
        int len2 = 0;
        ListNode cur1 = headA;
        ListNode cur2 = headB;
        while (cur1 != null) {
            cur1 = cur1.next;
            ++len1;
        }
        while (cur2 != null) {
            cur2 = cur2.next;
            ++len2;
        }
        cur1 = headA;
        cur2 = headB;
        if (len1 > len2) {
            for (int i = 0; i < len1 - len2; ++i)
                cur1 = cur1.next;
        } else {
            for (int i = 0; i < len2 - len1; ++i) {
                cur2 = cur2.next;
            }
        }
        ListNode ans = null;
        while (cur1 != null) {
            if (cur1 == cur2) {
                ans = cur1;
                break;
            }
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return ans;
    }
}
// @lc code=end
