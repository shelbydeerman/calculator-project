package CalculatorProject;

public class Evaluate {

    // can do some operations, no more than 1 at a time
    // no negative numbers
    // no double entries
    public double evaluateString(String expression) {

        char[] array = expression.toCharArray();
        double[] values = new double[2];
        char[] operators = new char[1];

        char operator = ' ';
        double value1 = array[0] - 48;
        double value2 = 0;

        for (int i = 1; i < array.length; i++) {

            if (array[i] == '+' || array[i] == '-' ||array[i] == '*' ||array[i] == '/') {
                operator = array[i];
            } else if (array[i] >= '0' && array[i] <= '9') {
                value2 = array[i] - 48;
            }
        }

        return applyOperation(operator, value1, value2);
        // return applyOperation(operators[0], values[0], values[1]);
    }

    public static double applyOperation(char operation, double a, double b) {

        switch (operation) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0) {
                    throw new UnsupportedOperationException("Cannot divide by zero");
                } else {
                    return a / b;
                }
        }
        return 0;
    }

}
