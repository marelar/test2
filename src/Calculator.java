import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        int operand1;
        int operand2;
        char operation;
        int x = 0;
        System.out.println(x);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter first number");
        operand1 = scanner.nextInt();

        while (true) {
            System.out.println("Enter operation");
            operation = scanner.next().charAt(0);
            if ((operation == '/') || (operation == '+') || (operation == '-') || (operation == '*')) {
                break;
            } else {
                System.out.println("Sorry, operation unavailable");
                System.out.println("Available operation: +, -, *, /");
            }
        }

        while (true) {
            System.out.println("Enter second number");
            operand2 = scanner.nextInt(); //считывает число
            if (operation != '/' || operand2 != 0) {
                break;
            } else {
                System.out.println("Error: divisor is zero. Enter another number");
            }
        }

        System.out.print(operand1 + " " + operation + " " + operand2 + " = ");

        switch (operation) {
            case '+':
                System.out.println(addition(operand1, operand2));
                System.out.println("Result = " + addition(operand1, operand2));
                break;
            case '-':
                System.out.println(subtraction(operand1, operand2));
                System.out.println("Result = " + subtraction(operand1, operand2));
                break;
            case '*':
                System.out.println(multiplication(operand1, operand2));
                System.out.println("Result = " + multiplication(operand1, operand2));
                break;
            case '/':
                System.out.println(division(operand1, operand2));
                System.out.println("Result = " + division(operand1, operand2));
                break;
        }
    }

    private static int addition(int operand1, int operand2) {
        int result;
        result = operand1 + operand2;
        return result;
    }

    private static int subtraction(int operand1, int operand2) {
        int result;
        result = operand1 - operand2;
        return result;
    }

    private static int multiplication(int operand1, int operand2) {
        int result;
        result = operand1 * operand2;
        return result;
    }

    private static double division(int operand1, int operand2) {
        double result;
        result = (double) operand1 / operand2;
        return result;
    }
}