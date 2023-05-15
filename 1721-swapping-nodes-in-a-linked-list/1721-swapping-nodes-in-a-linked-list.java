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
    public ListNode swapNodes(ListNode head, int k) {
        ArrayList<Integer> al = new ArrayList<>();
        ListNode temp = head;
        while(temp != null){
            al.add(temp.val);
            temp = temp.next;
        }
        int t = al.get(k-1);
        al.set(k-1, al.get(al.size()-k));
        al.set(al.size()-k, t);
        ListNode newNode = new ListNode(0);
        ListNode newHead = newNode;
        for(int v : al){
            ListNode node = new ListNode(v);
            newNode.next = node;
            newNode = node;
        }
        return newHead.next;        
    }
}