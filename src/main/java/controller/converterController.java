package controller;

import domain.stack.StackException;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class converterController {
    @javafx.fxml.FXML
    private Text txtMessage;
    @javafx.fxml.FXML
    private Pane mainPain;
    @javafx.fxml.FXML
    private Pane buttonPane;
    @javafx.fxml.FXML
    private TextField InfixTextfield;
    @javafx.fxml.FXML
    private RadioButton btpostfix;
    @javafx.fxml.FXML
    private TextField ExpressionTextfield;
    @javafx.fxml.FXML
    private TextField PostfixTextfield;
    @javafx.fxml.FXML
    private RadioButton btprefix;
    @javafx.fxml.FXML
    private RadioButton btinfix;
    @javafx.fxml.FXML
    private AnchorPane AP;
    @javafx.fxml.FXML
    private Label changeL1;//Primer label de las respuestas
    @javafx.fxml.FXML
    private Label changeL2;//Segundo label de las respuestas

    @javafx.fxml.FXML
    public void initialize() {

        InfixTextfield.setEditable(false);
        PostfixTextfield.setEditable(false);

    }

    @javafx.fxml.FXML
    public void cleanOnAction(ActionEvent actionEvent) {

        ExpressionTextfield.clear();
        InfixTextfield.clear();
        PostfixTextfield.clear();
    }


    @javafx.fxml.FXML
    public void prefOnAction(ActionEvent actionEvent) {

        changeL1.setText("Infix:");
        changeL2.setText("Postfix:");

        // ExpressionTextfield.clear();
        InfixTextfield.clear();
        PostfixTextfield.clear();


    }


    @javafx.fxml.FXML
    public void infOnAction(ActionEvent actionEvent) {

        changeL1.setText("Prefix:");
        changeL2.setText("Postfix:");

        //ExpressionTextfield.clear();
        InfixTextfield.clear();
        PostfixTextfield.clear();

    }

    @javafx.fxml.FXML
    public void postOnAction(ActionEvent actionEvent) {

        changeL1.setText("Prefix:");
        changeL2.setText("Infix:");

        //ExpressionTextfield.clear();
        InfixTextfield.clear();
        PostfixTextfield.clear();

    }


    @javafx.fxml.FXML
    public void converterOnAction(ActionEvent actionEvent) throws StackException {

        String expression = ExpressionTextfield.getText();

        if (expression == "")

            util.FXUtility.showAlert("Information", "There is no expression wrote", Alert.AlertType.INFORMATION);

        if (btprefix.isSelected()) {

            PostfixTextfield.setText(util.Utility.prefixToPostfixConverter(expression));
            InfixTextfield.setText(util.Utility.postfixToInfixConverter(PostfixTextfield.getText()));


        } else if (btinfix.isSelected()) {

            InfixTextfield.setText(util.Utility.infixToPrefixConverter(expression));
            PostfixTextfield.setText(util.Utility.prefixToPostfixConverter(InfixTextfield.getText()));


        } else if (btpostfix.isSelected()) {

            PostfixTextfield.setText(util.Utility.postfixToInfixConverter(expression));
            InfixTextfield.setText(util.Utility.infixToPrefixConverter(PostfixTextfield.getText()));

        } else {

            util.FXUtility.showAlert("Information", "You didn't select an arithmetic expression", Alert.AlertType.INFORMATION);

        }

    }


}