package CalculatorProject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


public class CalculatorController {

    @FXML
    private Label expression;

//    @FXML
//    private Label result;

    public void insertNumber(String number) {
        expression.setText(expression.getText() + number);
    }

    public void insertOperator(String operator) {
        expression.setText(expression.getText() + " " + operator + " ");
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
                // number method
                insertNumber(buttonText);
                break;
            case "+":
            case "-":
            case "*":
            case "/":
            case "%":
                // operator method
                insertOperator(buttonText);
                break;
            case "C":
                // clear method
                break;
            case "CE":
                // clear entry method
                break;
            case "DELETE":
                // delete method
                break;
            case "1/x":
                // fraction method
                break;
            case "x²":
                // squaring method
                break;
            case "√x":
                // square root method
                break;
            case "+/-":
                // negation method
                break;
            case "=":
                // link to evaluation class
                // with link to evaluation method (maybe depending on the operator??)
                break;
        }
    }
}