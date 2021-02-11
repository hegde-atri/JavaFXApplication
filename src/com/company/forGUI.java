package com.company;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class forGUI extends Application implements EventHandler<ActionEvent> {
    Button btn;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Hello World!");
        btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(this);

        StackPane layout = new StackPane();
        layout.getChildren().add(btn);

        primaryStage.setScene(new Scene(layout, 300, 250));
        primaryStage.show();
    }

    @Override
    public void handle(ActionEvent event) {
        if(event.getSource()==btn){
            System.out.println("Hello, it works");
        }

    }
}
