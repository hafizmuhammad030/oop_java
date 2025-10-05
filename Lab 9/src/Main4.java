 class RecursiveMaxInLinkedList {


    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }


    static class LinkedList {
        Node head;


        public void add(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
                return;
            }
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        public int findMax(Node head) {
            if (head == null) {
                return Integer.MIN_VALUE;
            }
            return Math.max(head.data, findMax(head.next));
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(10);
        list.add(25);
        list.add(5);
        list.add(42);
        list.add(18);

        int max = list.findMax(list.head);
        System.out.println("Maximum value in the linkedlist" + max);
    }
}
