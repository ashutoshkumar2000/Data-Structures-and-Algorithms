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
        return mergeKList(lists, 0, lists.length-1);
        
    }
    public ListNode mergeKList(ListNode[] lists, int strt, int end){
        if(lists.length == 0) return null;
        if(strt == end){
            return lists[strt];
        }
        
        int mid = (strt+end)/2;
        ListNode left = mergeKList(lists, strt, mid);
        ListNode right = mergeKList(lists, mid+1, end);
        return merge(left, right);
    }
    
    public ListNode merge(ListNode A, ListNode B){
        if(A == null) return B;
        if(B == null) return A;
        ListNode head = new ListNode(-1);
        ListNode curr = head;
        while(A != null && B != null){
            if(A.val > B.val){
                curr.next = B;
                curr = curr.next;
                B = B.next;
            }
            else{
                curr.next = A;
                curr = curr.next;
                A = A.next;
            }
        }
        if(A != null) {
            curr.next = A;
        }
        if(B != null){
            curr.next = B;
        }
        return head.next;
    }
}
