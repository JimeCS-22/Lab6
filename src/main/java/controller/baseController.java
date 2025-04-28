package controller;

import domain.StackException;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import java.util.function.UnaryOperator;

public class baseController {
    @javafx.fxml.FXML
    private Text txtMessage;
    @javafx.fxml.FXML
    private Pane mainPain;
    @javafx.fxml.FXML
    private Pane buttonPane;
    @javafx.fxml.FXML
    private TextField ResultTextfield;
    @javafx.fxml.FXML
    private RadioButton btoctal;
    @javafx.fxml.FXML
    private TextField DecimalValueTextfield;
    @javafx.fxml.FXML
    private RadioButton btbinary;
    @javafx.fxml.FXML
    private RadioButton bthexadecimal;
    @javafx.fxml.FXML
    private AnchorPane AP;
    @javafx.fxml.FXML
    private Label changeL1;
    @javafx.fxml.FXML
    private ToggleGroup baseConvert;


    @javafx.fxml.FXML
    public void initialize() {

        ResultTextfield.setEditable(false);
        DecimalValueTextfield.setTextFormatter(createNumberTextFormatter());

    }

    @javafx.fxml.FXML
    public void cleanOnAction(ActionEvent actionEvent) {

        DecimalValueTextfield.clear();
        ResultTextfield.clear();
    }


    @javafx.fxml.FXML
    public void binaryOnAction(ActionEvent actionEvent) {

        changeL1.setText("Result:");

        ResultTextfield.clear();

    }


    @javafx.fxml.FXML
    public void hexadecimalOnAction(ActionEvent actionEvent) {

        changeL1.setText("Result:");

        ResultTextfield.clear();

    }

    @javafx.fxml.FXML
    public void octalOnAction(ActionEvent actionEvent) {

        changeL1.setText("Result:");

        ResultTextfield.clear();

    }

    @javafx.fxml.FXML
    public void converterOnAction(ActionEvent actionEvent) {
        try {
            String inputText = DecimalValueTextfield.getText().trim();

            // Validar campo vacío
            if (inputText.isEmpty()) {
                util.FXUtility.showAlert("Information", "Please enter a decimal value", Alert.AlertType.INFORMATION);
                return;
            }

            // Validar selección de opción
            if (!btbinary.isSelected() && !bthexadecimal.isSelected() && !btoctal.isSelected()) {
                util.FXUtility.showAlert("Information", "Please select a conversion type", Alert.AlertType.INFORMATION);
                return;
            }

            // Convertir y validar
            int decimalValue;
            try {
                decimalValue = Integer.parseInt(inputText);
                if (decimalValue < 0) {
                    util.FXUtility.showAlert("Error", "Please enter a positive number", Alert.AlertType.ERROR);
                    return;
                }
            } catch (NumberFormatException e) {
                util.FXUtility.showAlert("Error", "Invalid number format", Alert.AlertType.ERROR);
                return;
            }

            // Realizar conversión
            String result;
            try {
                if (btbinary.isSelected()) {
                    result = util.Utility.convertToBase(decimalValue, 2);
                } else if (bthexadecimal.isSelected()) {
                    result = util.Utility.convertToBase(decimalValue, 16);
                } else {
                    result = util.Utility.convertToBase(decimalValue, 8);
                }
                ResultTextfield.setText(result);
            } catch (StackException e) {
                util.FXUtility.showAlert("Conversion Error", e.getMessage(), Alert.AlertType.ERROR);
            }

        } catch (Exception e) {
            util.FXUtility.showAlert("Error", "An unexpected error occurred", Alert.AlertType.ERROR);
        }
    }

    private TextFormatter<String> createNumberTextFormatter() {
        UnaryOperator<TextFormatter.Change> filter = change -> {
            String newText = change.getControlNewText();
            if (newText.isEmpty()) {
                return change; // Permitir campo vacío
            }

            try {
                // Solo permitir dígitos
                if (newText.matches("-?\\d*")) {
                    return change;
                }
            } catch (NumberFormatException e) {
                return null; // Rechazar cambio
            }
            return null; // Rechazar cambio si no es numérico
        };

        return new TextFormatter<>(filter);
    }
}
