/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode Cycle(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return slow;
            }
        }
        return null;
    }
    public ListNode detectCycle(ListNode head) {
        if(head == null) return null;
        ListNode cNode = Cycle(head);
        if(cNode == null) return null;
        ListNode slow = cNode;
        ListNode fast = cNode;
        ListNode curr = head;
        while(curr != slow && curr != fast){
            curr = curr.next;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return curr;
    }
}