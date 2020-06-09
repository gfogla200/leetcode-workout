import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class link_list_operations {

    void print(ListNode head){
        ListNode node = head;
        while(node != null){
            System.out.println(node.val);
            node = node.next;
        }
    }

    public ListNode delete_node(ListNode head, int value){

        if(head.val == value)
            return head.next;

        ListNode node = head;

        while(node.next != null){
            if(node.next.val == value){
                node.next = node.next.next;
                return head;
            }

            node = node.next;
        }
        return head;
    }

    public ListNode add_node(ListNode head, int value){


        ListNode new_node = new ListNode(value);
        ListNode node = head;
        if(head == null)
            return node;

        while(node.next != null)
            node = node.next;

        node.next = new_node;

        return head;
    }

    public ListNode create_new_link_list_from_array(int[] values){

        if(values.length < 1)
            return null;

        ListNode head = new ListNode(values[0]);
        ListNode node = head;

        for(int i =1; i<values.length;i++){
            ListNode new_node = new ListNode(values[i]);
            node.next = new_node;
            node = node.next;
        }

        return head;
    }

    public ListNode delete_duplicate_from_link_list(ListNode head){

        List<Integer> temp_list = new ArrayList<>();
        ListNode node = head;
        temp_list.add(head.val);

        while(node.next != null){
                if (temp_list.contains(node.next.val)){
                    node.next = node.next.next;
                }
                else {
                    temp_list.add(node.next.val);
                }
                node = node.next;
        }

        return head;
    }

    public static void main(String args[]) throws IOException {

        link_list_operations llo = new link_list_operations();

        int[] val = new int[]{1,2,3,4,4,5};

        ListNode head = llo.create_new_link_list_from_array(val);
        head = llo.delete_node(head,2);
        head = llo.delete_duplicate_from_link_list(head);
        llo.print(head);
    }
}
