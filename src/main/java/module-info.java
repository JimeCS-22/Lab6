module ucr.lab6 {
    requires javafx.controls;
    requires javafx.fxml;


    opens ucr.lab6 to javafx.fxml;
    exports ucr.lab6;
    exports controller;
    opens controller to javafx.fxml;

    opens domain to javafx.base;

}