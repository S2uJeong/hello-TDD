package testCodeLecture.sample;

import java.util.Scanner;

public class SampleApplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter two numbers and an operator (e.g 1 + 2) : ");
        String result = scanner.nextLine();
        String[] parts = result.split(" ");
        long num1 = Long.parseLong(parts[0]);
        long num2 = Long.parseLong(parts[2]);
        String operator = parts[1];
        long answer = switch (operator) {
            case "+" -> num1 + num2;
            case "-" -> num1 - num2;
            case "*" -> num1 * num2;
            case "/" -> num1 / num2;
            default -> throw new InvaildOperatorException();
        };
        System.out.println(answer);

    }
}
