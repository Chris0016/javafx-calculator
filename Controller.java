package calculator;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javax.swing.Action;

import javafx.event.ActionEvent;

public class Controller {


    @FXML
    private Label calculationStackLabel;

    @FXML
    private TextField currentCalculationLabel;



    private String currentNumber;
    private String firstNumber;
    private String operation;
    

    public void initialize() {
        currentNumber = "";
        firstNumber = "";
        operation = "";
    }


    void updateCurrentNumber(String newNumber){
        currentNumber += newNumber;
        setCurrentCalculationLabel(currentNumber);
    }

    void setCurrentCalculationLabel(String number){
        currentCalculationLabel.setText(number);
    }

    @FXML
    void clear(ActionEvent event){
        firstNumber =  currentNumber = operation = "";
        setCurrentCalculationLabel("");
    }


    @FXML
    void calculationClicked(ActionEvent event) {
        firstNumber = currentNumber;
        currentNumber = "";
        setCurrentCalculationLabel("");
        operation = ((Button)event.getSource()).getText();


    }


    @FXML
    void calculate(ActionEvent event){
        int num1 = Integer.parseInt(firstNumber);
        int num2= Integer.parseInt(currentNumber);
    
        if (operation.equals("+"))
            currentCalculationLabel.setText(String.valueOf(num1 + num2));
        else if(operation.equals("-"))
            currentCalculationLabel.setText(String.valueOf(num1 - num2));
        else if(operation.equals("*"))
            currentCalculationLabel.setText(String.valueOf(num1 * num2));
        else if(operation.equals("/"))
            currentCalculationLabel.setText(String.valueOf(num1 / num2));

    }


    @FXML
    void numberButtonClicked(ActionEvent event){
        updateCurrentNumber(((Button)event.getSource()).getText());
    }

    
}

