/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        return mergeKLists(lists, 0, lists.length-1);
    }
    
    
    public ListNode mergeKLists(ListNode[] lists, int si, int ei){
        if(lists.length == 0){
            return null;
        }
        if(lists.length == 1){
            return lists[0];
        }
        if(si == ei){
            return lists[si];
        }
        
        int mid = (si+ei)/2;
        ListNode l1 = mergeKLists(lists, si, mid);
        ListNode l2 = mergeKLists(lists, mid+1, ei);
        
        return mergeTwoLinkedList(l1, l2);
        
    }
    
    public ListNode mergeTwoLinkedList(ListNode l1, ListNode l2){
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        ListNode c1 = l1;
        ListNode c2 = l2;
        ListNode dummy = new ListNode(-1);
        ListNode c = dummy;
        while(c1 != null && c2 != null){
            if(c1.val > c2.val){
                c.next = c2;
                c2 = c2.next;
            }
            else{
                c.next = c1;
                c1 = c1.next;
            }
            c = c.next;
        }
        if(c1 != null){
            c.next = c1;
        }
        if(c2 != null){
            c.next = c2;
        }
        return dummy.next;
    }
}