package com.company;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.stage.Window;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main extends Application {

    ComboBox<String> comboBox;
    Button button;
    Scene scene;
    ListView<String> listView;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage window) throws Exception{
        window.setTitle("ListView");

        Button button= new Button("Click");
        button.setOnAction(e -> System.out.println("Clicked!"));

        listView = new ListView<>();
        listView.getItems().addAll("Iron Man", "your name", "i want to eat your pancreas", "weathering with you");
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 20, 20));
        layout.getChildren().addAll(listView, button);

        Scene scene = new Scene(layout, 300, 250);
        window.setScene(scene);
        window.show();
    }


}
/*
HOW TO CLOSE THE WINDOW
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("Hello");
        button = new Button("Click Me");
        window.setOnCloseRequest(e -> {
            e.consume();
            closeProgram();
        });
        button.setOnAction(e -> {
            boolean result = ConfirmBox.display("window title", "Are you sure you want to do this?");
            System.out.println(result);
        });

        StackPane layout = new StackPane();
        layout.getChildren().add(button);
        Scene scene = new Scene(layout, 300, 250);
        window.setScene(scene);
        window.show();
    }

    private void closeProgram(){
        Boolean answer = ConfirmBox.display("Exit", "Are you sure?");
        if(answer){
            window.close();
        }
`````````````````````````````````````````````````````````````````````````````````````````````
EMBEDDED LAYOUTS
        window.setTitle("Title");

        HBox topMenu = new HBox();
        Button buttonA = new Button("File");
        Button buttonB = new Button("Edit");
        Button buttonC = new Button("View");
        topMenu.getChildren().addAll(buttonA, buttonB, buttonC);

        VBox leftMenu = new VBox();
        Button buttonD = new Button("D");
        Button buttonE = new Button("E");
        Button buttonF = new Button("F");
        leftMenu.getChildren().addAll(buttonD, buttonE, buttonF);

        BorderPane borderPane = new BorderPane();
        borderPane.setTop(topMenu);
        borderPane.setLeft(leftMenu);

        Scene scene = new Scene(borderPane, 300, 250);
        window.setScene(scene);
        window.show();
`````````````````````````````````````````````````````````````````````````````````````````````
ADD USER INPUT FIELDS + GRID LAYOUT
   public void start(Stage window) {
        window.setTitle("Title");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);

        Label name = new Label("Username: ");
        GridPane.setConstraints(name, 0, 0);
        TextField nameInput = new TextField();
        nameInput.setPromptText("username");
        GridPane.setConstraints(nameInput, 1, 0);

        Label pass = new Label("Password: ");
        GridPane.setConstraints(pass, 0, 1);
        PasswordField passInput = new PasswordField();
        passInput.setPromptText("password");
        GridPane.setConstraints(passInput, 1, 1);

        Button logIn = new Button("Log in");
        GridPane.setConstraints(logIn, 1, 2);
        logIn.setOnAction(e -> isInt(nameInput, nameInput.getText()));

        grid.getChildren().addAll(name, nameInput, pass, passInput, logIn);


        Scene scene = new Scene(grid, 300, 200);
        window.setScene(scene);
        window.show();
`````````````````````````````````````````````````````````````````````````````````````````
ADD CHECKBOXES

public void start(Stage window) {
        window.setTitle("Title");

        CheckBox box1 = new CheckBox("Honey");
        CheckBox box2 = new CheckBox("Sugar");

        Button button= new Button("Order Now");
        button.setOnAction(e -> handleOptions(box1, box2));

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 20, 20));
        layout.getChildren().addAll(box1, box2, button);

        Scene scene = new Scene(layout, 300, 200);
        window.setScene(scene);
        window.show();
    }

    private void handleOptions(CheckBox box1, CheckBox box2){
        String message = "User's order\n";
        if(box1.isSelected()){
            message += "yes honey\n";
        }
        if(box2.isSelected()){
            message += "yes sugar\n";
        }
        System.out.println(message);
    }
```````````````````````````````````````````````````````````````````````````````````````
GET INPUT FROM FIELDS
    private boolean isInt(TextField input, String message){
        try{
            int age= Integer.parseInt(input.getText());
            System.out.println("User is: " + age);
            return true;
        }catch(NumberFormatException e){
            System.out.println("Error: " + message + " is not a number!");
            return false;
        }
```````````````````````````````````````````````````````````````````````````````````````
CHOICE BOXES (DROP DOWN MENU) AND LISTEN FOR CHANGES
    public void start(Stage window) {
        window.setTitle("ChoiceBox");

        String[] fruits = {"Orange", "Tangerine"};

        ChoiceBox<String> choiceBox = new ChoiceBox<>();
        choiceBox.getItems().add("<No item selected>");
        choiceBox.getItems().addAll("Apple", "Bananas");
        choiceBox.getItems().addAll(fruits);
        choiceBox.setValue("<No item selected>");

        //LISTEN FOR SELECTION CHANGES
        choiceBox.getSelectionModel().selectedItemProperty().addListener( (v, oldValue, newValue) -> System.out.println("selected value: " + newValue));

        Button button= new Button("Click");

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 20, 20));
        layout.getChildren().addAll(choiceBox, button);

        Scene scene = new Scene(layout, 300, 250);
        window.setScene(scene);
        window.show();
    }
`````````````````````````````````````````````````````````````````````````````````````````````````
COMBO BOXES
    public void start(Stage window) throws Exception{
        window.setTitle("ComboBox");

        comboBox = new ComboBox<>();
        comboBox.getItems().addAll("Hello", "Hey", "Hi", "Good morning");
        comboBox.setPromptText("select greeting");

        Button button= new Button("Click");
        //CONFIRMATION BUTTON
        button.setOnAction(e -> System.out.println(comboBox.getValue()));

        //CHOOSING WITHOUT CONFIRMATION
        comboBox.setOnAction(e -> System.out.println("user selected: " + comboBox.getValue()));


        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 20, 20));
        layout.getChildren().addAll(comboBox, button);

        Scene scene = new Scene(layout, 300, 250);
        window.setScene(scene);
        window.show();
    }
`````````````````````````````````````````````````````````````````````````````````````````````````

 */

