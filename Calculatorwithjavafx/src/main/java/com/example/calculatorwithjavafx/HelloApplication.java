package com.example.calculatorwithjavafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) {


        try {
            FXMLLoader fxmlLoader;
            fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("gui.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 483, 565);
            stage.setTitle("Integer BEDMAS supported Calculator");
            stage.setResizable(false);
            stage.setScene(scene);
            stage.show();




        }catch (IOException error){
            System.out.println("lol");
        }

    }

    public static void main(String[] args) {
        launch();
    }
}