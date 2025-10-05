import java.util.Stack;

class RecursivePalindromeStack {


    public static boolean isPalindrome(Stack<Integer> stack) {
        Stack<Integer> clone = (Stack<Integer>) stack.clone();
        return isPalindromeHelper(clone, 0, clone.size());
    }


    private static boolean isPalindromeHelper(Stack<Integer> stack, int index, int size) {

        if (index >= size / 2) {
            return true;
        }

        int left = stack.pop();
        boolean result = isPalindromeHelper(stack, index + 1, size);
        int right = stack.pop();

        stack.push(right);
        stack.push(left);

        return result && (left == right);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(2);
        stack.push(1);

        System.out.println("Is Palindrome: " + isPalindrome(stack));
        System.out.println("Stack after check: " + stack);
    }
}
