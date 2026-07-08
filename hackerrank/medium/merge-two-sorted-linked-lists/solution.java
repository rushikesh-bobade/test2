import java.io.*;
import java.util.*;

public class Solution {

    static class SinglyLinkedListNode {
        int data;
        SinglyLinkedListNode next;

        SinglyLinkedListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static SinglyLinkedListNode mergeLists(
            SinglyLinkedListNode head1,
            SinglyLinkedListNode head2) {

        SinglyLinkedListNode dummy = new SinglyLinkedListNode(0);
        SinglyLinkedListNode tail = dummy;

        while (head1 != null && head2 != null) {

            if (head1.data <= head2.data) {
                tail.next = head1;
                head1 = head1.next;
            } else {
                tail.next = head2;
                head2 = head2.next;
            }

            tail = tail.next;
        }

        if (head1 != null)
            tail.next = head1;
        else
            tail.next = head2;

        return dummy.next;
    }

    static SinglyLinkedListNode insert(
            SinglyLinkedListNode head, int data) {

        SinglyLinkedListNode node = new SinglyLinkedListNode(data);

        if (head == null)
            return node;

        SinglyLinkedListNode temp = head;

        while (temp.next != null)
            temp = temp.next;

        temp.next = node;

        return head;
    }

    static void printList(SinglyLinkedListNode head) {

        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {

            int n = Integer.parseInt(br.readLine());
            SinglyLinkedListNode head1 = null;

            for (int i = 0; i < n; i++) {
                head1 = insert(head1,
                        Integer.parseInt(br.readLine()));
            }

            int m = Integer.parseInt(br.readLine());
            SinglyLinkedListNode head2 = null;

            for (int i = 0; i < m; i++) {
                head2 = insert(head2,
                        Integer.parseInt(br.readLine()));
            }

            SinglyLinkedListNode result = mergeLists(head1, head2);

            printList(result);
            System.out.println();
        }
    }
}
