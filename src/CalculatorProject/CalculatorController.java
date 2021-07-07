package CalculatorProject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import java.lang.Character;
import java.lang.Math;


public class CalculatorController {

    @FXML
    private Label expression;

    @FXML
    private Label storage;

    @FXML
    private Label result;

    Evaluate evaluate = new Evaluate();

    public Label getExpression() {
        return expression;
    }

    public void insertNumber(String number) {
        expression.setText(expression.getText() + number);
    }

    public void insertOperator(String operator) {
        storage.setText(storage.getText() + expression.getText() + " " + operator + " ");
        expression.setText("");
    }

    public void clearExpression() {
        expression.setText("");
        storage.setText("");
        result.setText("");
    }

    public void clearEntry() {
        expression.setText("");
    }

    public void deleteLast() {
        if (!getExpression().getText().isEmpty()) {
            StringBuilder text = new StringBuilder(getExpression().getText());
            if (Character.isDigit(text.charAt(text.length() - 1)) || text.charAt(text.length() - 1) == '.') {
                text.deleteCharAt(text.length() - 1);
                expression.setText(text.toString());
            }
        }
    }

    public void percentageCalculation() {
        String text = getExpression().getText();
        double percentage = Double.parseDouble(text);
        percentage = percentage * 0.01;
        text = String.valueOf(percentage);
        expression.setText(text);
    }

    public void fractionCalculation() {
        String text = getExpression().getText();
        double fraction = Double.parseDouble(text);
        fraction = 1 / fraction;
        text = String.valueOf(fraction);
        expression.setText(text);
    }

    public void squaringCalculation() {
        String text = getExpression().getText();
        double squared = Double.parseDouble(text);
        squared = Math.pow(squared, 2);
        text = String.valueOf(squared);
        expression.setText(text);
    }

    public void squareRootCalculation() {
        String text = getExpression().getText();
        double squareRoot = Double.parseDouble(text);
        squareRoot = Math.sqrt(squareRoot);
        text = String.valueOf(squareRoot);
        expression.setText(text);
    }

    public void negationCalculation() {
        String text = getExpression().getText();
        double negation = Double.parseDouble(text);
        negation = -1 * negation;
        text = String.valueOf(negation);
        expression.setText(text);
    }

    public void onMouseClick(ActionEvent actionEvent) {

        Button button = (Button) actionEvent.getSource();
        String buttonText = button.getText();

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
            case "=":
                if (storage.getText().isEmpty()) {
                    result.setText("= " + expression.getText());
                    expression.setText("");
                } else {
                    storage.setText(storage.getText() + expression.getText());
                    expression.setText("");
                    double answer = evaluate.evaluateString(storage.getText());
                    result.setText("= " + answer);
                    storage.setText("");
                }
                break;
        }
    }
}