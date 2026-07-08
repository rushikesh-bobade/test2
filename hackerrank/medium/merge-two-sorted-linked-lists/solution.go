package main

import (
    "bufio"
    "fmt"
    "os"
)

type SinglyLinkedListNode struct {
    data int32
    next *SinglyLinkedListNode
}

type SinglyLinkedList struct {
    head *SinglyLinkedListNode
    tail *SinglyLinkedListNode
}

func (list *SinglyLinkedList) insertNode(data int32) {
    node := &SinglyLinkedListNode{data: data}

    if list.head == nil {
        list.head = node
    } else {
        list.tail.next = node
    }

    list.tail = node
}

func mergeLists(head1 *SinglyLinkedListNode, head2 *SinglyLinkedListNode) *SinglyLinkedListNode {
    dummy := &SinglyLinkedListNode{}
    current := dummy

    for head1 != nil && head2 != nil {
        if head1.data <= head2.data {
            current.next = head1
            head1 = head1.next
        } else {
            current.next = head2
            head2 = head2.next
        }
        current = current.next
    }

    if head1 != nil {
        current.next = head1
    } else {
        current.next = head2
    }

    return dummy.next
}

func printList(node *SinglyLinkedListNode, writer *bufio.Writer) {
    for node != nil {
        fmt.Fprint(writer, node.data)
        if node.next != nil {
            fmt.Fprint(writer, " ")
        }
        node = node.next
    }
    fmt.Fprintln(writer)
}

func main() {
    reader := bufio.NewReader(os.Stdin)
    writer := bufio.NewWriter(os.Stdout)
    defer writer.Flush()

    var t int
    fmt.Fscan(reader, &t)

    for ; t > 0; t-- {
        var n int
        fmt.Fscan(reader, &n)

        list1 := SinglyLinkedList{}
        for i := 0; i < n; i++ {
            var x int32
            fmt.Fscan(reader, &x)
            list1.insertNode(x)
        }

        fmt.Fscan(reader, &n)

        list2 := SinglyLinkedList{}
        for i := 0; i < n; i++ {
            var x int32
            fmt.Fscan(reader, &x)
            list2.insertNode(x)
        }

        result := mergeLists(list1.head, list2.head)
        printList(result, writer)
    }
}
