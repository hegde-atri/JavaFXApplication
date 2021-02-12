package com.company;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

    Stage window;
    Button button;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
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
    }
}

