import java.util.LinkedList;
import java.util.Queue;

 class RecursiveQueueCount {

    public static int countOccurrences(Queue<Integer> queue, int target) {
        if (queue.isEmpty()) {
            return 0;
        }
        int front = queue.poll();
        int count = countOccurrences(queue, target);
        queue.add(front);

        if (front == target) {
            return count + 1;
        } else {
            return count;
        }
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(2);
        queue.add(5);
        queue.add(1);
        queue.add(5);
        queue.add(7);

        int target = 5;
        int occurrences = countOccurrences(queue, target);

        System.out.println("Occurrences of " + target + occurrences);
        System.out.println("Queue after count " + queue);
    }
}
