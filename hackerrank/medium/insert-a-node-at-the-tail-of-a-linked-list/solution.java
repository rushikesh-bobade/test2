import java.io.*;
import java.util.*;

public class Solution {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node insertAtTail(Node head, int data) {
        Node newNode = new Node(data);

        if (head == null) {
            return newNode;
        }

        Node current = head;

        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;

        return head;
    }

    public static void printList(Node head) {
        Node current = head;

        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Node head = null;

        for (int i = 0; i < n; i++) {
            int data = sc.nextInt();
            head = insertAtTail(head, data);
        }

        printList(head);

        sc.close();
    }
}
