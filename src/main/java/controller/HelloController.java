package controller;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import ucr.lab6.HelloApplication;

import java.io.IOException;

public class HelloController {

    @FXML
    private Text txtMessage;
    @FXML
    private BorderPane bp;
    @FXML
    private AnchorPane ap;


    @Deprecated
    private void load(String form) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(form));
        this.bp.setCenter(fxmlLoader.load());
    }

    @FXML
    public void Home(ActionEvent actionEvent) {
        this.bp.setCenter(ap);
        this.txtMessage.setText("Laboratory No. 6");
    }


    @FXML
    public void Exit(ActionEvent actionEvent) {
        System.exit(0);
    }

    @FXML
    public void loadingOnMousePressed(Event event)  {
        this.txtMessage.setText("Estamos cargando tu vista...");
    }


    @FXML
    public void baseView(ActionEvent actionEvent) throws IOException {
        load("base.fxml");
    }

    @FXML
    public void converterView(ActionEvent actionEvent) throws IOException {
        load("converter.fxml");
    }
}