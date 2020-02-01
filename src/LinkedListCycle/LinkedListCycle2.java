package LinkedListCycle;
/**
 * 这类链表题目一般都是使用双指针法解决
 * 例如寻找距离尾部第k个结点、寻找环入口、寻找公共尾部入口等
 * 算法流程：
 *         1.双指针第一次相遇
 *              1)fast 指针走过链表末端，说明链表无环，直接返回 null
 *              2)当fast==slow时，两指针在环中第一次相遇,下面分析此时fast与slow走过的步数关系：
 *              设链表共有a+b个节点，其中链表头部到链表入口有a个节点（不计链表入口节点）,链表环有b个节点，
 *              假设两个指针分别走了f和s步，由于f=2s，且当相遇时f=s+nb(双指针都走过a步，然后在环内绕圈直
 *              到重合，重合时fast比slow多走环的长度整数倍)
 *              3)两式联立可得f=2nb，s=nb
 *         2.构造第二次相遇
 *              1)由于要到达环入口，走过的步数等于k=a+nb;
 *              2)第一次相遇后，让fast回到头结点，当fast再走a步后，在环入口和s=a+nb的slow会合，返回slow
 *              即可
 *
 */
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
         next = null;
      }
}
public class LinkedListCycle2 {
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null)
            return null;
        ListNode fast = head;
        ListNode slow = head;
        while(true){
            if(fast == null || fast.next == null)
                return null;
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow)
                break;
        }
        fast = head;
        while(fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
