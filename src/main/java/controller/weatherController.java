package controller;

import domain.queue.Domain.LinkedQueue;
import domain.queue.Domain.Place;
import domain.queue.Domain.QueueException;
import domain.queue.Domain.Weather;
import domain.stack.LinkedListStack;
import domain.stack.StackException;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import java.util.Random;

public class weatherController {

    public static class WeatherEntry {
        private final ObjectProperty<Place> place = new SimpleObjectProperty<>();
        private final ObjectProperty<Weather> weather = new SimpleObjectProperty<>();

        public WeatherEntry(Place place, Weather weather) {
            this.place.set(place);
            this.weather.set(weather);
        }

        public Place getPlace() {
            return place.get();
        }

        public ObjectProperty<Place> placeProperty() {
            return place;
        }

        public void setPlace(Place place) {
            this.place.set(place);
        }

        public Weather getWeather() {
            return weather.get();
        }

        public ObjectProperty<Weather> weatherProperty() {
            return weather;
        }

        public void setWeather(Weather weather) {
            this.weather.set(weather);
        }
    }

    private LinkedQueue queue;
    private LinkedListStack stack;
    private ObservableList<WeatherEntry> queueData = FXCollections.observableArrayList();
    private ObservableList<WeatherEntry> stackData = FXCollections.observableArrayList();
    private final String[] possiblePlaceNames = {"Paraíso", "Cartago", "Turrialba", "Oreamuno", "La Unión", "Jiménez", "Guácimo", "Siquirres", "Talamanca", "Alvarado", "Pacayas", "Cervantes", "Juan Viñas", "Tres Equis", "Pejibaye", "Tucurrique", "Atirro", "Cachi", "Ujarrás", "Palomo"};
    private final String[] possibleWeatherConditions = {"rainy", "thunderstorm", "sunny", "cloudy", "foggy"};
    private final Random random = new Random();


    //Lugar
    @FXML
    private TextField PlaceTextfield;

    //Clima
    @FXML
    private ComboBox<String> weatherBox;

    //Columnas
    //1 para queue
    @FXML
    private TableColumn<WeatherEntry, Place> placeColum1;
    @FXML
    private TableColumn<WeatherEntry, Weather> weatherColum1;
    //2 para stack
    @FXML
    private TableColumn<WeatherEntry, Place> placeColum2;
    @FXML
    private TableColumn<WeatherEntry, Weather> weatherColum2;

    //Botones
    @FXML
    private Button btAuto;
    @FXML
    private Button enQueue;
    @FXML
    private Button clean;

    //Tables
    @FXML
    private TableView<WeatherEntry> queueTable;
    @FXML
    private TableView<WeatherEntry> stackTable;

    //No codificar
    @FXML
    private Pane buttonPane;
    @FXML
    private AnchorPane AP;
    @FXML
    private Text txtMessage;
    @FXML
    private Pane mainPain;


    @FXML
    public void initialize() {
        queue = new LinkedQueue();
        stack = new LinkedListStack();

        placeColum1.setCellValueFactory(new PropertyValueFactory<>("place"));
        weatherColum1.setCellValueFactory(new PropertyValueFactory<>("weather"));
        queueTable.setItems(queueData);

        placeColum2.setCellValueFactory(new PropertyValueFactory<>("place"));
        weatherColum2.setCellValueFactory(new PropertyValueFactory<>("weather"));
        stackTable.setItems(stackData);

        weatherBox.setItems(FXCollections.observableArrayList(possibleWeatherConditions));

        // Listener para evitar números en PlaceTextfield
        PlaceTextfield.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\D*")) {
                PlaceTextfield.setText(newValue.replaceAll("[^\\D]", ""));
            }
        });
    }

    @FXML
    public void enQueueOnAction(ActionEvent actionEvent) {
        String placeName = PlaceTextfield.getText();
        String weatherCondition = weatherBox.getValue();

        if (placeName != null && !placeName.isEmpty() && weatherCondition != null) {
            Place place = new Place(placeName);
            Weather weather = new Weather(weatherCondition);
            WeatherEntry newEntry = new WeatherEntry(place, weather);
            try {
                queue.enQueue(newEntry);
            } catch (QueueException e) {
                throw new RuntimeException(e);
            }
            queueData.add(newEntry);
            PlaceTextfield.clear();
            weatherBox.setValue(null);

        } else {
            txtMessage.setText("Please enter both place and weather.");
        }
    }

    @FXML
    public void toOnAction(ActionEvent actionEvent) {
        if (!queue.isEmpty()) {
            // Transferir de la cola a la pila
            while (!queue.isEmpty()) {
                try {
                    WeatherEntry dequeuedEntry = (WeatherEntry) queue.deQueue();
                    stack.push(dequeuedEntry);
                    queueData.remove(0);
                    stackData.add(dequeuedEntry);

                } catch (QueueException | StackException e) {
                   util.FXUtility.alert("Error  " , e.getMessage());
                    return;
                }
            }

        } else if (!stack.isEmpty()) {
            // Transferir de la pila a la cola
            while (!stack.isEmpty()) {
                try {
                    WeatherEntry poppedEntry = (WeatherEntry) stack.pop();
                    queue.enQueue(poppedEntry);
                    stackData.remove(stackData.size() - 1);
                    queueData.add(poppedEntry);

                }catch (QueueException | StackException e) {
                    util.FXUtility.alert("Error  " , e.getMessage());
                    return;
                }
            }

        }
    }

    @FXML
    public void autoOnAction(ActionEvent actionEvent) {
        for (int i = 0; i < 20; i++) {
            String randomPlaceName = possiblePlaceNames[random.nextInt(possiblePlaceNames.length)];
            String randomWeatherCondition = possibleWeatherConditions[random.nextInt(possibleWeatherConditions.length)];
            Place place = new Place(randomPlaceName);
            Weather weather = new Weather(randomWeatherCondition);
            WeatherEntry newEntry = new WeatherEntry(place, weather);
            try {
                queue.enQueue(newEntry);
            } catch (QueueException e) {
                throw new RuntimeException(e);
            }
            queueData.add(newEntry);
        }

    }

    @FXML
    public void cleanOnAction(ActionEvent actionEvent) {
        PlaceTextfield.clear();
        weatherBox.setValue(null);
        queue.clear();
        queueData.clear();
        stack.clear();
        stackData.clear();

    }
}