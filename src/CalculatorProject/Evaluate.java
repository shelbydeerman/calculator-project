package CalculatorProject;

/**
 * Defines how to evaluate the strings following the rules of the Order of Operations
 */
public class Evaluate {

    /**
     * Defines the logic needed to evaluate the given expression by the Order of Operations
     *
     * @param expression defines the expression to be solved, it is the text that was on the "expression" label
     * @return the double answer to the expression in String form
     */
    public static String evaluateString(String expression) {

        // Creates a string array of the expression separated by spaces
        String[] array = expression.split("\\s+");

        // Creates a string array for the number values used in the expression
        String[] values = new String[array.length / 2 + 1];

        // Creates a character array for the operators used in the expression
        char[] operators = new char[array.length / 2];

        int j = 0;
        int k = 0;

        // Separates the numbers and operators into their respective arrays
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

        // Solves all the instances of multiplication and division in the expression
        for (int i = 0; i < operators.length; i++) {
            if (operators[i] == '*' || operators[i] == '/') {
                values[i] = String.valueOf(applyOperation(operators[i], Double.parseDouble(values[i]),
                Double.parseDouble(values[i + 1])));
                values = newStringArray(values, i);
                operators = newCharArray(operators, i);
                i--;
            }
        }

        // Solves all the instances of addition and subtraction after all of the multiplication and
        // division have been solved
        for (int i = 0; i < operators.length; i++) {
            if (operators[i] == '+' || operators[i] == '-') {
                values[i] = String.valueOf(applyOperation(operators[i], Double.parseDouble(values[i]),
                Double.parseDouble(values[i + 1])));
                values = newStringArray(values, i);
                operators = newCharArray(operators, i);
                i--;
            }
        }
        // After the multiple calls to "newStringArray" and "newCharArray" the only string left in
        // "values" is the final answer
        return values[0];
    }

    /**
     * Defines which operation is being completed currently and returns the answer in double form
     *
     * @param operation defines which operation is being completed (+, -, *, /)
     * @param a defines the first number in the expression
     * @param b defines the second number in the expression
     * @return the answer depending on the operator
     */
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

    /**
     * Creates a new character array without the operator that has already been used
     *
     * @param oldArray defines the array of operations including the operator that has already been used
     * @param index defines which index in the array the unnecessary operator is at
     * @return a new array that does not include the operator that was just used
     */
    public static char[] newCharArray(char[] oldArray, int index) {
        char[] copy = new char[oldArray.length - 1];
        for (int m = 0, n = 0; m < oldArray.length; m++) {
            if (m != index) {
                copy[n++] = oldArray[m];
            }
        }
        return copy;
    }

    /**
     * Creates a new string array without the number that has already been included in the calculations
     *
     * @param oldArray defines the array of numbers that includes the number that has been used in the calculations
     * @param index defines which index in the array the unnecessary number is at
     * @return a new array that does not include the number that was included in the calculations
     */
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
