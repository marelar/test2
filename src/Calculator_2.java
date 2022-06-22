/* Martyashov Ivan
Module 2. Task 2.9
Calculator *
*/

import java.util.Scanner;

public class Calculator_2 {
    public static void main(String[] args) {

        double operand = 0;
        char operation = ' ';
        double result = 0;
        boolean haveOperand = false;

        Scanner scanner = new Scanner(System.in);

        System.out.println("""
                _____________________________________________
                This is a calculator.
                You can use next operation: + addition
                                            - subtraction
                                            * multiplication
                                            / division
                To exit the calculator, enter character C.
                To stop the calculator, enter character s.
                _____________________________________________""");

        while (true) {
            // Get operation:
            if (haveOperand && operation != 'C') {
                System.out.print("Enter operation: ");
                operation = getOperation(scanner);
            }

            // Get and check operand:
            if (operation != 'C') {
                System.out.print("Enter number: ");
                while (true) {
                    char dataType = checkInputData(scanner);
                    if (dataType == 'd') {
                        operand = scanner.nextDouble();
                        if (operation == '/' && operand == 0) {
                            System.out.print("Error: divisor is zero. Enter another number: ");
                        } else {
                            haveOperand = true;
                            break;
                        }
                    } else if (dataType == 'C') {
                        operation = 'C';
                        break;
                    } else {
                        System.out.println("Sorry, this is clearly not a number. Try again.");
                    }
                }
            }

            // Calculation:
            if (operation != 'C') {
                result = calculate(result, operand, operation);
                if (operation != ' ') {
                    System.out.println("Result = " + result);
                    System.out.println("Continue?");
                }
            } else {
                result = 0;
                haveOperand = false;
                operation = ' ';
            }
        }
    }

    private static double calculate(double result, double operand, char operation) {
        switch (operation) {
            case '+' -> result = addition(result, operand);
            case '-' -> result = subtraction(result, operand);
            case '*' -> result = multiplication(result, operand);
            case '/' -> result = division(result, operand);
            case ' ' -> result = operand;
        }
        return result;
    }

    private static char getOperation(Scanner scanner) {
        char operation;
        while (true) {
            operation = checkInputData(scanner);
            if (operation == 'd') {
                System.out.println("Sorry, this is clearly not an operation.");
                System.out.print("Available operation: +, -, *, /. Try again: ");
                scanner.nextDouble();
            } else if ((operation == '/') || (operation == '+') || (operation == '-') || (operation == '*')) {
                break;
            } else if (operation == 'C') {
                break;
            }
        }
        return operation;
    }

    private static char checkInputData(Scanner scanner) {
        char dataType;
        while (true) {
            if (scanner.hasNextDouble()) {
                dataType = 'd';
                break;
            } else if (scanner.hasNext()) {
                char operationData = scanner.next().charAt(0);
                if (operationData == 'C') {
                    System.out.println("Clean!");
                    System.out.println("_______________");
                    System.out.println();
                    dataType = 'C';
                    break;
                } else if (operationData == 's') {
                    System.out.println("Exit!");
                    System.exit(0);
                } else if (operationData == '+') {
                    dataType = '+';
                    break;
                } else if (operationData == '-') {
                    dataType = '-';
                    break;
                } else if (operationData == '*') {
                    dataType = '*';
                    break;
                } else if (operationData == '/') {
                    dataType = '/';
                    break;
                } else {
                    System.out.println("Error! Try again: ");
                }
            }
        }
        return dataType;
    }

    private static double addition(double result, double operand) {
        return result + operand;
    }

    private static double subtraction(double result, double operand) {
        return result - operand;
    }

    private static double multiplication(double result, double operand) {
        return result * operand;
    }

    private static double division(double result, double operand) {
        return result / operand;
    }
}