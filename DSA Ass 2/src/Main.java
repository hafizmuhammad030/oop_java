import java.util.Scanner;

class Node {
    int data;
    Node next;
    Node prev;

    Node(int data) {
        this.data = data;
    }
}

class DoublyCircularLinkedList {
    Node head = null;

    public void insertAtFront(int value) {
        Node newNode = new Node(value);

        if (head == null) {
            newNode.next = newNode.prev = newNode;
            head = newNode;
        } else {
            Node tail = head.prev;

            newNode.next = head;
            newNode.prev = tail;

            head.prev = newNode;
            tail.next = newNode;

            head = newNode;
        }
        System.out.println(value + " inserted at front.");
    }

    public void insertAtEnd(int value) {
        Node newNode = new Node(value);

        if (head == null) {
            newNode.next = newNode.prev = newNode;
            head = newNode;
        } else {
            Node tail = head.prev;

            newNode.next = head;
            newNode.prev = tail;

            tail.next = newNode;
            head.prev = newNode;
        }
        System.out.println(value + " inserted at end.");
    }

    public int removeFromFront() {
        if (head == null) {
            System.out.println("List is empty.");
            return -1;
        }

        int value = head.data;

        if (head.next == head) {
            head = null;
        } else {
            Node tail = head.prev;
            head = head.next;

            head.prev = tail;
            tail.next = head;
        }

        System.out.println(value + " removed from front.");
        return value;
    }

    public int removeFromEnd() {
        if (head == null) {
            System.out.println("List is empty.");
            return -1;
        }

        Node tail = head.prev;
        int value = tail.data;

        if (head.next == head) {
            head = null;
        } else {
            Node newTail = tail.prev;
            newTail.next = head;
            head.prev = newTail;
        }

        System.out.println(value + " removed from end.");
        return value;
    }

    public boolean search(int value) {
        if (head == null) {
            return false;
        }

        Node current = head;
        while (true) {
            if (current.data == value) {
                return true;
            }
            current = current.next;
            if (current == head) {
                break;
            }
        }
        return false;
    }

    public void display() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Node current = head;
        System.out.print("List: ");
        while (true) {
            System.out.print(current.data + " ");
            current = current.next;
            if (current == head) {
                break;
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DoublyCircularLinkedList list = new DoublyCircularLinkedList();
        Scanner scanner = new Scanner(System.in);
        int choice = -1;

        System.out.println("Circular Doubly Linked List");

        while (choice != 0) {
            System.out.println("\nMenu:");
            System.out.println("1. Insert at Front");
            System.out.println("2. Insert at End");
            System.out.println("3. Remove from Front");
            System.out.println("4. Remove from End");
            System.out.println("5. Search");
            System.out.println("6. Display");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            if (choice == 1) {
                System.out.print("Enter value to insert at front: ");
                int value = scanner.nextInt();
                list.insertAtFront(value);
            }

            if (choice == 2) {
                System.out.print("Enter value to insert at end: ");
                int value = scanner.nextInt();
                list.insertAtEnd(value);
            }

            if (choice == 3) {
                list.removeFromFront();
            }

            if (choice == 4) {
                list.removeFromEnd();
            }

            if (choice == 5) {
                System.out.print("Enter value to search: ");
                int value = scanner.nextInt();
                boolean found = list.search(value);
                if (found) {
                    System.out.println("Value found.");
                } else {
                    System.out.println("Value not found.");
                }
            }

            if (choice == 6) {
                list.display();
            }

            if (choice < 0 || choice > 6) {
                System.out.println("Invalid choice1 Try again.");
            }
        }

        System.out.println("Program exited.");
        scanner.close();
    }
}
