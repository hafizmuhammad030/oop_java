 class RecursiveRemoveFromLinkedList {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    public static Node remove(Node head, int target) {
        if (head == null) {
            return null;
        }
        if (head.data == target) {
            return remove(head.next, target);
        }

        head.next = remove(head.next, target);
        return head;
    }

    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(4);

        System.out.print("Original List: ");
        printList(head);

        int target = 2;
        head = remove(head, target);

        System.out.print("List after removing" + target);
        printList(head);
    }
}
