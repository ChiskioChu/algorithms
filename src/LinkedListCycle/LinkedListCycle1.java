package LinkedListCycle;

/**
 *
 * 单链表中是否存在环，使用双指针算法，fast和slow，最终会相遇
 *
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 *
 */
public class LinkedListCycle1 {
    public boolean hasCycle(ListNode head) {
        //边界判断
        if(head == null || head.next == null)
            return false;
        //出发点需要不一样，否则while中的相等就必须是他们的第二次相遇
        ListNode i = head;
        ListNode j = head.next;
        while(j != null && j.next != null)
        {
            if(i == j) return true;
            i = i.next;
            j = j.next.next;
        }
        return false;
    }
}
