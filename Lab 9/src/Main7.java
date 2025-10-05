import java.util.LinkedList;
import java.util.Queue;

 class RecursiveQueueCopy {

    public static Queue<Integer> copyQueue(Queue<Integer> original) {
        if (original.isEmpty()) {
            return new LinkedList<>();
        }
        int front = original.poll();

        Queue<Integer> copied = copyQueue(original);
        original.add(front);
        copied.add(front);

        return copied;
    }

    public static void main(String[] args) {
        Queue<Integer> original = new LinkedList<>();
        original.add(10);
        original.add(20);
        original.add(30);

        Queue<Integer> copied = copyQueue(original);

        System.out.println("Original Queue: " + original);
        System.out.println("Copied Queue:   " + copied);  
    }
}
