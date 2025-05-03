package controller;

import domain.queue.Domain.PriorityLinkedQueue;
import domain.queue.Domain.QueueException;
import domain.queue.Domain.Person;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.Random;

public class priorityController {
    @FXML private ChoiceBox<String> priorityBox;
    @FXML private Button enQueueButton;
    @FXML private TextField nameTextField;
    @FXML private TableView<Person> tableView;
    @FXML private TableColumn<Person, String> moodColumn;
    @FXML private ChoiceBox<String> moodBox;
    @FXML private TableColumn<Person, String> priorityColumn;
    @FXML private TableColumn<Person, String> nameColumn;
    @FXML private Button autoButton;
    @FXML private Button attentionButton;
    @FXML private TableColumn<Person, String> attentionColumn;
    @FXML private TextArea textArea;

    private PriorityLinkedQueue priorityQueue;
    private ObservableList<Person> personList;
    private Random random = new Random();

    private final String[] NAMES = {"Sofia", "Mateo", "Valentina", "Santiago", "Isabella",
            "Benjamín", "Camila", "Leonardo", "Antonella", "Thiago"};
    private final String[] MOODS = {"Happiness", "Sadness", "Anger", "Sickness", "Cheerful",
            "Reflective", "Gloomy", "Romantic", "Calm", "Hopeful"};

    @FXML
    public void initialize() {
        priorityBox.setItems(FXCollections.observableArrayList("low", "medium", "high"));
        moodBox.setItems(FXCollections.observableArrayList(MOODS));

        priorityQueue = new PriorityLinkedQueue();
        personList = FXCollections.observableArrayList();

        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        moodColumn.setCellValueFactory(new PropertyValueFactory<>("mood"));
        priorityColumn.setCellValueFactory(new PropertyValueFactory<>("priority"));
        attentionColumn.setCellValueFactory(new PropertyValueFactory<>("attentionTimeFormatted"));

        tableView.setItems(personList);
    }

    @FXML
    public void enQueueOnAction(ActionEvent actionEvent) {
        String name = nameTextField.getText().trim();
        String mood = moodBox.getValue();
        String priorityStr = priorityBox.getValue();

        if (name.isEmpty() || mood == null || priorityStr == null) {
            showAlert("Error", "Por favor complete todos los campos.", Alert.AlertType.WARNING);
            return;
        }

        try {
            int priorityValue = convertPriority(priorityStr);
            int attentionTimeMinutes = random.nextInt(100); // 0-99 minutos

            Person person = new Person(name, mood, attentionTimeMinutes, priorityStr);

            if (containsPerson(person)) {
                showAlert("Advertencia", "Esta persona ya está en la cola.", Alert.AlertType.WARNING);
                return;
            }

            priorityQueue.enQueue(person, priorityValue);
            updateTableData(); // Actualizar la tabla con el nuevo orden
            nameTextField.clear();
            showAlert("Éxito", "Persona agregada a la cola.", Alert.AlertType.INFORMATION);
        } catch (QueueException e) {
            showAlert("Error", "Error al encolar: " + e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    @FXML
    public void autoEnQueueOnAction(ActionEvent actionEvent) {
        int count = 0;
        int maxAttempts = 100; // Para evitar bucles infinitos
        int attempts = 0;

        while (count < 20 && attempts < maxAttempts) {
            attempts++;
            String name = NAMES[random.nextInt(NAMES.length)];
            String mood = MOODS[random.nextInt(MOODS.length)];
            String priorityStr = new String[] {"low", "medium", "high"}[random.nextInt(3)];
            int priorityValue = convertPriority(priorityStr);
            int attentionTimeMinutes = random.nextInt(100);

            Person person = new Person(name, mood, attentionTimeMinutes, priorityStr);

            try {
                if (!containsPerson(person)) {
                    priorityQueue.enQueue(person, priorityValue);
                    personList.add(person);
                    count++;
                }
            } catch (QueueException e) {
                textArea.appendText("Error al encolar automáticamente: " + e.getMessage() + "\n");
            }
        }

        if (count < 20) {
            showAlert("Información", "Solo se pudieron agregar " + count + " personas únicas.", Alert.AlertType.INFORMATION);
        } else {
            showAlert("Éxito", "20 personas agregadas aleatoriamente a la cola.", Alert.AlertType.INFORMATION);
        }
    }

    @FXML
    public void attentionProcessOnAction(ActionEvent actionEvent) {
        try {
            if (priorityQueue.isEmpty()) {
                showAlert("Información", "No hay personas en la cola para atender.", Alert.AlertType.INFORMATION);
                return;
            }

            Person person = (Person) priorityQueue.deQueue();
            textArea.appendText("Atendiendo a: " + person.getName() +
                    "\n- Estado de ánimo: " + person.getMood() +
                    "\n- Prioridad: " + person.getPriority() +
                    "\n- Tiempo de atención: " + person.getAttentionTimeFormatted() + "\n\n");

            updateTableData();
        } catch (QueueException e) {
            showAlert("Error", "Error al atender: " + e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    @FXML
    public void cleanOnAction(ActionEvent actionEvent) {
        priorityQueue.clear();
        personList.clear();
        textArea.clear();
        showAlert("Éxito", "Cola y lista limpiadas exitosamente.", Alert.AlertType.INFORMATION);
    }

    private void updateTableData() throws QueueException {
        personList.clear();
        PriorityLinkedQueue tempQueue = new PriorityLinkedQueue();

        // Extraer y volver a insertar para mantener el orden
        while (!priorityQueue.isEmpty()) {
            Person person = (Person) priorityQueue.deQueue();
            personList.add(person);
            tempQueue.enQueue(person, convertPriority(person.getPriority()));
        }

        priorityQueue = tempQueue;
    }

    private int convertPriority(String priorityStr) {
        switch (priorityStr.toLowerCase()) {
            case "high": return 3;
            case "medium": return 2;
            case "low": return 1;
            default: return 1;
        }
    }

    private boolean containsPerson(Person person) throws QueueException {
        for (Object obj : personList) {
            Person p = (Person) obj;
            if (p.getName().equals(person.getName()) && p.getMood().equals(person.getMood())) {
                return true;
            }
        }
        return false;
    }

    private void showAlert(String title, String message, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}