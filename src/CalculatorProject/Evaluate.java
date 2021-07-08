package CalculatorProject;

public class Evaluate {

    public static String evaluateString(String expression) {

        String[] array = expression.split("\\s+");
        String[] values = new String[array.length / 2 + 1];
        char[] operators = new char[array.length / 2];

        int j = 0;
        int k = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i].equals("+") || array[i].equals("-") || array[i].equals("*") ||array[i].equals("/")) {
                operators[j] = array[i].charAt(0);
                j++;
            } else if ( (array[i].charAt(0) >= '0' && array[i].charAt(0) <= '9') ||
            (array[i].charAt(1) >= '0' && array[i].charAt(1) <= '9') ) {
                values[k] = array[i];
                k++;
            }
        }

        for (int i = 0; i < operators.length; i++) {
            if (operators[i] == '*' || operators[i] == '/') {
                values[i] = String.valueOf(applyOperation(operators[i], Double.parseDouble(values[i]),
                Double.parseDouble(values[i + 1])));
                values = newStringArray(values, i);
                operators = newCharArray(operators, i);
                i--;
            }
        }

        for (int i = 0; i < operators.length; i++) {
            if (operators[i] == '+' || operators[i] == '-') {
                values[i] = String.valueOf(applyOperation(operators[i], Double.parseDouble(values[i]),
                Double.parseDouble(values[i + 1])));
                values = newStringArray(values, i);
                operators = newCharArray(operators, i);
                i--;
            }
        }
        return values[0];
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

    public static char[] newCharArray(char[] oldArray, int index) {
        char[] copy = new char[oldArray.length - 1];
        for (int m = 0, n = 0; m < oldArray.length; m++) {
            if (m != index) {
                copy[n++] = oldArray[m];
            }
        }
        return copy;
    }

    public static String[] newStringArray(String[] oldArray, int index) {
        String[] copy = new String[oldArray.length - 1];
        for (int m = 0, n = 0; m < oldArray.length; m++) {
            if (m != index + 1) {
                copy[n++] = oldArray[m];
            }
        }
        return copy;
    }

}
