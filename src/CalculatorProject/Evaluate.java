package CalculatorProject;

public class Evaluate {

    // works for everything with single operations
    public double evaluateString(String expression) {

        String[] array = expression.split("\\s+");
        String[] values = new String[10];

        int j = 0;

        String operator = "";

        for (int i = 0; i < array.length; i++) {

            if (array[i].equals("+") || array[i].equals("-") || array[i].equals("*") ||array[i].equals("/")) {
                operator = array[i];
            } else if ( (array[i].charAt(0) >= '0' && array[i].charAt(0) <= '9') ||
            (array[i].charAt(1) >= '0' && array[i].charAt(1) <= '9') ) {
                values[j] = array[i];
                j++;
            }
        }

        return applyOperation(operator.charAt(0), Double.parseDouble(values[0]), Double.parseDouble(values[1]));
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
