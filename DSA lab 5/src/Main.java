import java.util.Scanner;

class Task {
    String title;
    int priority;
    String deadline;
    Task next;
    Task prev;

    Task(String title, int priority, String deadline) {
        this.title = title;
        this.priority = priority;
        this.deadline = deadline;
    }
}

class TaskManager {
    private Task head = null;
    private Task tail = null;

    public void addTaskStart(String title, int priority, String deadline) {
        Task newTask = new Task(title, priority, deadline);
        if (head == null) {
            head = tail = newTask;
        } else {
            newTask.next = head;
            head.prev = newTask;
            head = newTask;
        }
        System.out.println("Task added at start.");
    }

    public void addTaskEnd(String title, int priority, String deadline) {
        Task newTask = new Task(title, priority, deadline);
        if (tail == null) {
            head = tail = newTask;
        } else {
            tail.next = newTask;
            newTask.prev = tail;
            tail = newTask;
        }
        System.out.println("Task added at end.");
    }

    public void addTaskByPriority(String title, int priority, String deadline) {
        Task newTask = new Task(title, priority, deadline);

        if (head == null || head.priority > priority) {
            addTaskStart(title, priority, deadline);
            return;
        }

        Task current = head;
        while (current.next != null && current.next.priority <= priority) {
            current = current.next;
        }

        newTask.next = current.next;
        if (current.next != null) {
            current.next.prev = newTask;
        } else {
            tail = newTask;
        }
        current.next = newTask;
        newTask.prev = current;
        System.out.println("Task added by priority.");
    }

    public void removeTask(String title) {
        Task current = head;

        while (current != null) {
            if (current.title.equals(title)) {
                if (current.prev != null) {
                    current.prev.next = current.next;
                } else {
                    head = current.next;
                }

                if (current.next != null) {
                    current.next.prev = current.prev;
                } else {
                    tail = current.prev;
                }

                System.out.println("Task removed.");
                return;
            }
            current = current.next;
        }

        System.out.println("Task not found.");
    }

    public void displayForward() {
        Task current = head;
        System.out.println("Tasks (Forward):");
        while (current != null) {
            System.out.println(current.title + " | Priority: " + current.priority + " | Deadline: " + current.deadline);
            current = current.next;
        }
    }

    public void displayBackward() {
        Task current = tail;
        System.out.println("Tasks (Backward):");
        while (current != null) {
            System.out.println(current.title + " | Priority: " + current.priority + " | Deadline: " + current.deadline);
            current = current.prev;
        }
    }

    public void sortByPriority() {
        if (head == null) return;

        boolean swapped;
        do {
            swapped = false;
            Task current = head;
            while (current.next != null) {
                if (current.priority > current.next.priority) {
                    swapNodes(current, current.next);
                    swapped = true;
                } else {
                    current = current.next;
                }
            }
        } while (swapped);

        System.out.println("Tasks sorted by priority.");
    }

    public void sortByDeadline() {
        if (head == null) return;

        boolean swapped;
        do {
            swapped = false;
            Task current = head;
            while (current.next != null) {
                if (current.deadline.compareTo(current.next.deadline) > 0) {
                    swapNodes(current, current.next);
                    swapped = true;
                } else {
                    current = current.next;
                }
            }
        } while (swapped);

        System.out.println("Tasks sorted by deadline.");
    }

    private void swapNodes(Task a, Task b) {
        if (a == null || b == null || a == b) return;

        if (a.next == b) {
            Task prevA = a.prev;
            Task nextB = b.next;

            if (prevA != null) prevA.next = b;
            else head = b;

            if (nextB != null) nextB.prev = a;
            else tail = a;

            b.prev = prevA;
            b.next = a;
            a.prev = b;
            a.next = nextB;
        } else {
            Task prevA = a.prev, nextA = a.next;
            Task prevB = b.prev, nextB = b.next;

            if (prevA != null) prevA.next = b;
            else head = b;

            if (nextA != null) nextA.prev = b;

            if (prevB != null) prevB.next = a;
            else head = a;

            if (nextB != null) nextB.prev = a;

            a.prev = prevB;
            a.next = nextB;

            b.prev = prevA;
            b.next = nextA;
        }
    }

    public void searchTask(String title) {
        Task current = head;
        while (current != null) {
            if (current.title.equalsIgnoreCase(title)) {
                System.out.println("Found: " + current.title + " | Priority: " + current.priority + " | Deadline: " + current.deadline);
                return;
            }
            current = current.next;
        }
        System.out.println("Task not found.");
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TaskManager manager = new TaskManager();

        int choice = -1;

        while (choice != 0) {
            System.out.println("\nTASK MANAGER MENU:");
            System.out.println("1. Add Task at Start");
            System.out.println("2. Add Task at End");
            System.out.println("3. Add Task by Priority");
            System.out.println("4. Remove Completed Task");
            System.out.println("5. Display Tasks Forward");
            System.out.println("6. Display Tasks Backward");
            System.out.println("7. Sort by Priority");
            System.out.println("8. Sort by Deadline");
            System.out.println("9. Search Task by Title");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            if (choice == 1) {
                System.out.print("Enter title: ");
                String title = sc.nextLine();
                System.out.print("Enter priority: ");
                int priority = sc.nextInt();
                sc.nextLine();
                System.out.print("Enter deadline: ");
                String deadline = sc.nextLine();
                manager.addTaskStart(title, priority, deadline);
            } else if (choice == 2) {
                System.out.print("Enter title: ");
                String title = sc.nextLine();
                System.out.print("Enter priority: ");
                int priority = sc.nextInt();
                sc.nextLine();
                System.out.print("Enter deadline: ");
                String deadline = sc.nextLine();
                manager.addTaskEnd(title, priority, deadline);
            } else if (choice == 3) {
                System.out.print("Enter title: ");
                String title = sc.nextLine();
                System.out.print("Enter priority: ");
                int priority = sc.nextInt();
                sc.nextLine();
                System.out.print("Enter deadline: ");
                String deadline = sc.nextLine();
                manager.addTaskByPriority(title, priority, deadline);
            } else if (choice == 4) {
                System.out.print("Enter title of completed task: ");
                String title = sc.nextLine();
                manager.removeTask(title);
            } else if (choice == 5) {
                manager.displayForward();
            } else if (choice == 6) {
                manager.displayBackward();
            } else if (choice == 7) {
                manager.sortByPriority();
            } else if (choice == 8) {
                manager.sortByDeadline();
            } else if (choice == 9) {
                System.out.print("Enter title to search: ");
                String title = sc.nextLine();
                manager.searchTask(title);
            } else if (choice == 0) {
                System.out.println("Exiting Task Manager.");
            } else {
                System.out.println("Invalid choice.");
            }
        }

        sc.close();
    }
}
