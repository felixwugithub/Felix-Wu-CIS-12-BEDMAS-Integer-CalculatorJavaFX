module com.example.calculatorwithjavafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.calculatorwithjavafx to javafx.fxml;
    exports com.example.calculatorwithjavafx;
}