import java.util.Scanner;
import java.util.Stack;

public class Main2{


    public static String reverseString(String input) {
        Stack<Character> stack = new Stack<>();
        for (char ch : input.toCharArray()) {
            stack.push(ch);
        }

        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) {
            reversed.append(stack.pop());
        }

        return reversed.toString();
    }


    public static boolean isBalanced(String expression) {
        Stack<Character> stack = new Stack<>();

        for (char ch : expression.toCharArray()) {
            if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                if (stack.isEmpty()) return false;
                stack.pop();
            }
        }

        return stack.isEmpty();
    }


    public static String decimalToBinary(int number) {
        Stack<Integer> stack = new Stack<>();

        if (number == 0) return "0";

        while (number > 0) {
            stack.push(number % 2);
            number /= 2;
        }

        StringBuilder binary = new StringBuilder();
        while (!stack.isEmpty()) {
            binary.append(stack.pop());
        }

        return binary.toString();
    }


    public static boolean isPalindrome(String text) {
        Stack<Character> stack = new Stack<>();
        text = text.replaceAll("\\s+", "").toLowerCase(); // ignore spaces & case

        for (char ch : text.toCharArray()) {
            stack.push(ch);
        }

        for (char ch : text.toCharArray()) {
            if (stack.pop() != ch) {
                return false;
            }
        }

        return true;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice = -1;

        while (choice != 0) {
            System.out.println("\n--- Stack Menu ---");
            System.out.println("1. Reverse a String");
            System.out.println("2. Check Balanced Parentheses");
            System.out.println("3. Decimal to Binary");
            System.out.println("4. Palindrome Check");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                System.out.print("Enter a string: ");
                String str = sc.nextLine();
                String reversed = reverseString(str);
                System.out.println("Reversed string: " + reversed);
            } else if (choice == 2) {
                System.out.print("Enter an algebraic expression: ");
                String expr = sc.nextLine();
                if (isBalanced(expr))
                    System.out.println("Expression is balanced.");
                else
                    System.out.println("Expression is NOT balanced.");
            } else if (choice == 3) {
                System.out.print("Enter a decimal number: ");
                int num = sc.nextInt();
                String binary = decimalToBinary(num);
                System.out.println("Binary: " + binary);
            } else if (choice == 4) {
                System.out.print("Enter a string: ");
                String text = sc.nextLine();
                if (isPalindrome(text))
                    System.out.println("It is a palindrome.");
                else
                    System.out.println("It is NOT a palindrome.");
            } else if (choice == 0) {
                System.out.println("Exiting...");
            } else {
                System.out.println("Invalid choice!");
            }
        }

        sc.close();
    }
}
