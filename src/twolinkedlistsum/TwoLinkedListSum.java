package twolinkedlistsum;


import java.util.LinkedList;
import java.util.Queue;

public class TwoLinkedListSum {

    static ListNode head1;
    static ListNode head2;
    public ListNode addTwoLists(ListNode l1, ListNode l2) {
        ListNode prev = null;
        // Create 3 queues
        Queue<ListNode> q1 = new LinkedList<>();
        Queue<ListNode> q2 = new LinkedList<>();
        Queue<ListNode> q3 = new LinkedList<>();
        // Fill first queue with first List Elements
        while (l1 != null) {
            q1.add(l1);
            l1 = l1.next;
        }
        // Fill second queue with second List Elements
        while (l2 != null) {
            q2.add(l2);
            l2 = l2.next;
        }
        int carry = 0;
        // Fill the third queue with the sum of first and
        // second queue
        while (!q1.isEmpty() && !q2.isEmpty()) {
            int sum
                    = q1.peek().val + q2.peek().val + carry;
            ListNode temp = new ListNode(sum % 10);
            q3.add(temp);
            if (sum > 9) {
                carry = 1;
            }
            else {
                carry = 0;
            }
            q1.remove();
            q2.remove();
        }
        while (!q1.isEmpty()) {
            int sum = carry + q1.peek().val;
            ListNode temp = new ListNode(sum % 10);
            q3.add(temp);
            if (sum > 9) {
                carry = 1;
            }
            else {
                carry = 0;
            }
            q1.remove();
        }
        while (!q2.isEmpty()) {
            int sum = carry + q2.peek().val;
            ListNode temp = new ListNode(sum % 10);
            q3.add(temp);
            if (sum > 9) {
                carry = 1;
            }
            else {
                carry = 0;
            }
            q2.remove();
        }
        // If carry is still present create a new node with
        // value 1 and push it to the third queue
        if (carry == 1) {
            ListNode temp = new ListNode(1);
            q3.add(temp);
        }
        // Link all the elements inside third queue with
        // each other
        if (!q3.isEmpty())
            prev = q3.peek();
        while (!q3.isEmpty()) {
            ListNode temp = q3.peek();
            q3.remove();
            if (q3.isEmpty()) {
                temp.next = null;
            }
            else {
                temp.next = q3.peek();
            }
        }

        return prev;
    }

    static void printList(ListNode head)
    {
        while (head.next != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println(head.val);
    }

    public static void main(String[] args) {
        TwoLinkedListSum list = new TwoLinkedListSum();

        // creating first list
        list.head1 = new ListNode(2);
        list.head1.next = new ListNode(4);
        list.head1.next.next = new ListNode(9);
        System.out.print("First List : ");
        list.printList(head1);

        // creating second list
        list.head2 = new ListNode(5);
        list.head2.next = new ListNode(6);
        list.head2.next.next = new ListNode(4);
        list.head2.next.next.next = new ListNode(9);
        System.out.print("Second List : ");
        list.printList(head2);

        System.out.print("Sum List : ");
        // add the two lists and see the result
        list.printList(list.addTwoLists(head1, head2));

    }
}