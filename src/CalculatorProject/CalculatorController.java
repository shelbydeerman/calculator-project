package CalculatorProject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import java.lang.Character;
import java.lang.Math;

/**
 * Defines what to do when each button is clicked
 */
public class CalculatorController {

    @FXML
    private Label expression;

    @FXML
    private Label storage;

    @FXML
    private Label result;

    /**
     * Defines what to do when a number button is clicked
     *
     * @param number is the text on the button that was pushed, allows differentiation between numbers
     */
    public void insertNumber(String number) {
        expression.setText(expression.getText() + number);
    }

    /**
     * Defines what to do when an operator button is clicked
     *
     * @param operator is the text on the button that was pushed, allows differentiation between operators
     */
    public void insertOperator(String operator) {
        expression.setText(expression.getText() + " " + operator + " ");
    }

    /**
     * Defines what to do when the "C" button is pushed
     * Clears all three labels
     */
    public void clearExpression() {
        expression.setText("");
        storage.setText("");
        result.setText("");
    }

    /**
     * Defines what to do when the "CE" button is pushed
     * Clears the "expression" label only
     */
    public void clearEntry() {
        expression.setText("");
    }

    /**
     * Defines what to do when the "DELETE" button is pushed
     * Deletes the last character if it is a number or a decimal point
     */
    public void deleteLast() {
        if (!expression.getText().isEmpty()) {
            StringBuilder text = new StringBuilder(expression.getText());
            if (Character.isDigit(text.charAt(text.length() - 1)) || text.charAt(text.length() - 1) == '.') {
                text.deleteCharAt(text.length() - 1);
                expression.setText(text.toString());
            }
        }
    }

    /**
     * Defines what to do when the "%" button is pushed
     * Multiplies the number by 0.01
     * Will print an error message if the button is pushed with multiple numbers in the "expression" label
     */
    public void percentageCalculation() {
        try {
            String text = expression.getText();
            double percentage = Double.parseDouble(text);
            percentage = percentage * 0.01;
            text = String.valueOf(percentage);
            expression.setText(text);
        } catch (Exception e) {
            System.out.println("Error!");
        }
    }

    /**
     * Defines what to do when the "1/x" button is pushed
     * Makes the number the denominator of a fraction with 1 as the numerator
     * Expresses the answer in decimal form
     * Will print an error message if the button is pushed with multiple numbers in the "expression" label
     */
    public void fractionCalculation() {
        try {
            String text = expression.getText();
            double fraction = Double.parseDouble(text);
            fraction = 1 / fraction;
            text = String.valueOf(fraction);
            expression.setText(text);
        } catch (Exception e) {
            System.out.println("Error!");
        }
    }

    /**
     * Defines what to do when the "x²" button is pushed
     * Squares the number (multiplies it by itself)
     * Will print an error message if the button is pushed with multiple numbers in the "expression" label
     */
    public void squaringCalculation() {
        try {
            String text = expression.getText();
            double squared = Double.parseDouble(text);
            squared = Math.pow(squared, 2);
            text = String.valueOf(squared);
            expression.setText(text);
        } catch (Exception e) {
            System.out.println("Error!");
        }
    }

    /**
     * Defines what to do when the "√x" button is pushed
     * Takes the square root of the number
     * Will print an error message if the button is pushed with multiple numbers in the "expression" label
     * Returns "NaN" if button is pushed for a negative number
     */
    public void squareRootCalculation() {
        try {
            String text = expression.getText();
            double squareRoot = Double.parseDouble(text);
            squareRoot = Math.sqrt(squareRoot);
            text = String.valueOf(squareRoot);
            expression.setText(text);
        } catch (Exception e) {
            System.out.println("Error!");
        }
    }

    /**
     * Defines what to do when the "+/-" button is pushed
     * Negates the number (multiplies it by -1)
     * Will print an error message if the button is pushed with multiple numbers in the "expression" label
     */
    public void negationCalculation() {
        try {
            String text = expression.getText();
            double negation = Double.parseDouble(text);
            negation = -1 * negation;
            text = String.valueOf(negation);
            expression.setText(text);
        } catch (Exception e) {
            System.out.println("Error!");
        }
    }

    /**
     * Defines what to do for each button when pushed using a switch statement
     * @param actionEvent defines which button the action happened on
     */
    public void onMouseClick(ActionEvent actionEvent) {

        // Finds out which button was pushed and stores the text on it in "buttonText"
        Button button = (Button) actionEvent.getSource();
        String buttonText = button.getText();

        // Calls the correct method depending on the button that was pushed
        switch (buttonText){
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":
            case "0":
            case ".":
                insertNumber(buttonText);
                break;
            case "+":
            case "-":
            case "*":
            case "/":
                insertOperator(buttonText);
                break;
            case "C":
                clearExpression();
                break;
            case "CE":
                clearEntry();
                break;
            case "DELETE":
                deleteLast();
                break;
            case "%":
                percentageCalculation();
                break;
            case "1/x":
                fractionCalculation();
                break;
            case "x²":
                squaringCalculation();
                break;
            case "√x":
                squareRootCalculation();
                break;
            case "+/-":
                negationCalculation();
                break;
            // Defines what to do when the equals button is pushed
            case "=":
                try {
                    // Defines what to show on the "result" label if the "expression" label is empty
                    if (expression.getText().isEmpty()) {
                        result.setText("= ");
                        storage.setText("");
                        // Calls the "evaluateString" method in the "Evaluate" class to solve the expression
                        // Displays the answer in the "result" label
                    } else {
                        storage.setText(expression.getText());
                        expression.setText("");
                        String answer = Evaluate.evaluateString(storage.getText());
                        result.setText("= " + answer);
                    }
                } catch (Exception e) {
                    System.out.println("Error!");
                }
                break;
        }
    }
}