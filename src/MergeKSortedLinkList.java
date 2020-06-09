

/*
*
Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

Example:

Input:
[
  1->4->5,
  1->3->4,
  2->6
]
Output: 1->1->2->3->4->4->5->6
*
* */

import java.util.List;


public class MergeKSortedLinkList {

    public static ListNode m2sll(ListNode[] l) {

//        if (l.length == 0)
//            return null;
//        if (l.length == 1)
//            return l[0];
//        ListNode dummy = new ListNode(0);
//        ListNode head = dummy;
//
//        boolean flag = true;
//        int max;
//        int index;
//        while (flag) {
//            max = Integer.MAX_VALUE;
//            index = -1;
//            flag = false;
//            for (int i = 0; i < l.length; i++) {
//                if (l[i] != null) {
//                    if (l[i].val < max) {
//                        max = l[i].val;
//                        index = i;
//                    }
//                }
//            }
//            ListNode newNode = new ListNode(max);
//            dummy.next = newNode;
//            dummy = dummy.next;
//            l[index] = l[index].next;
//            for (int i = 0; i < l.length; i++) {
//                if (l[i] != null) {
//                    flag = true;
//                }
//            }
//        }
//        return head.next;

        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        if (l.length == 0)
            return null;
        if (l.length == 1)
            return l[0];

        dummy.next = l[0];

        MergeTwoSortedLinkList mergeTwoSortedLinkList = new MergeTwoSortedLinkList();
        for(int i = 1 ; i < l.length;i++){
            dummy.next = mergeTwoSortedLinkList.mergeTwoLists(dummy.next, l[i]);
        }

        return head.next;
    }


    public static void main(String args[]) {

        link_list_operations llo = new link_list_operations();
        ListNode l1 = llo.create_new_link_list_from_array(new int[]{1, 3, 5, 7, 9});
        ListNode l2 = llo.create_new_link_list_from_array(new int[]{1, 2, 4, 6, 8, 10, 11});
        ListNode l3 = llo.create_new_link_list_from_array(new int[]{1, 1, 2, 3, 6, 21, 23});
        ListNode head = m2sll(new ListNode[]{l1, l2, l3, null});
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
