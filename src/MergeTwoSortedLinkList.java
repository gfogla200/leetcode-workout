

/*
*
Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

Example:

Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4

*
* */

import java.util.HashMap;

public class MergeTwoSortedLinkList {

    public static ListNode m2sll(ListNode l1, ListNode l2) {

        ListNode head = new ListNode(0);
        ListNode newList = new ListNode(0);
        head.next = newList;
        while (l1 != null && l2 != null) {
            ListNode iterator = new ListNode(0);
            if (l1.val < l2.val) {
                iterator.val = l1.val;
                l1 = l1.next;
            } else {
                iterator.val = l2.val;
                l2 = l2.next;
            }
            newList.next = iterator;
            newList = newList.next;
        }

        if (l1 != null) {
            newList.next = l1;
        } else
            newList.next = l2;

        return head.next.next;
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }

    }

    public static void main(String args[]) {


        link_list_operations llo = new link_list_operations();
        ListNode l1 = llo.create_new_link_list_from_array(new int[]{1, 3, 5, 7, 9});
        ListNode l2 = llo.create_new_link_list_from_array(new int[]{1, 2, 4, 6, 8, 10, 11});
        ListNode head = mergeTwoLists(l1, l2);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
