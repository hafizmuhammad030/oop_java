import java.util.Scanner;

class Stack {
    char[] arr;
    int top;

    Stack(int size) {
        arr = new char[size];
        top = -1;
    }

    void push(char c) {
        if (top < arr.length - 1) {
            top++;
            arr[top] = c;
        }
    }

    char pop() {
        if (top >= 0) {
            char temp = arr[top];
            top--;
            return temp;
        }
        return '\0';
    }

    char peek() {
        if (top >= 0) {
            return arr[top];
        }
        return '\0';
    }

    boolean isEmpty() {
        return top == -1;
    }
}

public class Main2 {


    public static int precedence(char op) {
        if (op == '+' || op == '-') {
            return 1;
        } else if (op == '*' || op == '/') {
            return 2;
        } else if (op == '^') {
            return 3;
        }
        return 0;
    }



    public static boolean isOperand(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || Character.isDigit(c);
    }


    public static String convertToPostfix(String infix) {
        Stack stack = new Stack(infix.length());
        String postfix = "";

        int i = 0;
        while (i < infix.length()) {
            char c = infix.charAt(i);

            if (isOperand(c)) {
                postfix += c;
            } else {
                while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(c)) {
                    postfix += stack.pop();
                }
                stack.push(c);
            }

            i++;
        }


        while (!stack.isEmpty()) {
            postfix += stack.pop();
        }

        return postfix;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter infix expression: ");
        String infix = scanner.nextLine();

        String postfix = convertToPostfix(infix);
        System.out.println("Postfix expression: " + postfix);

        scanner.close();
    }
}

