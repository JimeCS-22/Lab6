module ucr.lab7 {
    requires javafx.controls;
    requires javafx.fxml;


    opens ucr.lab7 to javafx.fxml;
    exports ucr.lab7;
    exports controller;
    exports domain.queue.Domain;
    opens controller to javafx.fxml;
    opens domain.queue.Domain to javafx.base;
    opens domain.stack to javafx.base;


}