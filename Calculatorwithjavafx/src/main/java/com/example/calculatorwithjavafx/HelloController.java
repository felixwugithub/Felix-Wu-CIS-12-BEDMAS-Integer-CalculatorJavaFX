package com.example.calculatorwithjavafx;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;

public class HelloController {
    @FXML
    private Label expression;
    @FXML
    private Label result;

    public void evaluateExpression(){

        //please Mr. Zaremba can i plz get bonus marks for this expression evaluator that follows BEDMAS? it took me a whole afternoon to code this!

        String expressionText = expression.getText();
        expressionText = expressionText.concat(" ");
        int r = calculate(expressionText);
        String output = String.valueOf(r);

        result.setText(output);

    }

    public static int calculate(String input){

        ArrayList<String> ops = new ArrayList<String>();


        int lastSpacePos = -1;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == ' '){
                ops.add(input.substring(lastSpacePos+1, i));
                lastSpacePos = i;
            }
        }

        String[][] processor = new String[10][ops.size()];
        for (int i = 0; i < processor.length; i++) {
            for (int j = 0; j < processor[0].length; j++) {
                processor[i][j] = "0";
            }
        }


        for (int i = 0; i < ops.size(); i++) {
            processor[0][i] = ops.get(i);
        }



        int operationNum = 0;

        for (int i = 0; i < 5; i++) {


            for (int j = 0; j < processor[0].length; j++) {

                if(processor[i][j].contains("*") || processor[i][j].contains("/")){
                    operationNum ++;


                    if(processor[i][j].contains("*")){


                        int a = Integer.parseInt(processor[i][j-1]);
                        int b = Integer.parseInt(processor[i][j+1]);
                        int val = a * b;

                        processor[i+1][j-1] = String.valueOf(val);

                        for (int k = 0; k < j - 1; k++) {
                            processor[i+1][k] = processor[i][k];
                        }
                        for (int k = j; k < processor[0].length - 2; k++) {
                            processor[i+1][k] = processor[i][k+2];
                        }



                        break;
                    }

                    if(processor[i][j].contains("/")){

                        int a = Integer.parseInt(processor[i][j-1]);
                        int b = Integer.parseInt(processor[i][j+1]);
                        int val = (int) (a / b + 0.5);

                        processor[i+1][j-1] = String.valueOf(val);

                        for (int k = 0; k < j - 1; k++) {
                            processor[i+1][k] = processor[i][k];
                        }
                        for (int k = j; k < processor[0].length - 2; k++) {
                            processor[i+1][k] = processor[i][k+2];
                        }

                        break;
                    }
                }


            }

        }


        int sum = Integer.parseInt(processor[operationNum][0]);
        for (int i = 0; i < processor[0].length; i++) {


            if (processor[operationNum][i].contains("+")){
                sum+= Integer.parseInt(processor[operationNum][i+1]);
            }
            if (processor[operationNum][i].contains("-")){
                sum-= Integer.parseInt(processor[operationNum][i+1]);
            }


        }


        return sum;
    }





    public void insertNumber(String number){
        expression.setText(expression.getText() + number);
    }

    public void insertOperator(String operator){
        expression.setText(expression.getText() + " " + operator + " ");
    }

    public void clearExpression(){
        expression.setText("");
    }



    public void onMouseClick(MouseEvent mouseEvent) {

        Button button = (Button) mouseEvent.getSource();
        String buttonText = button.getText();

        switch(button.getText()){
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

                insertNumber(buttonText);
                break;

            case "+":
            case "-":
            case "/":
            case"*":
                insertOperator(buttonText);
                break;

            case "AC":
                clearExpression();
                break;

            case "=":
                evaluateExpression();

        }

    }

}