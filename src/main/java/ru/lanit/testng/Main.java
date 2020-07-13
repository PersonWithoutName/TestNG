package ru.lanit.testng;

public class Main {
    private static String expression;

    public static void main(String[] args) {
        System.out.println("Write your expression and press Enter button:");
        Console console = new Console();
        expression = console.getPreparedString(console.readingExpression());
        Validator validator = new Validator();
        if (validator.isValid(expression)) {
            try {
                console.printResult(Calculator.calculateExpression(expression));
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
    }
}
