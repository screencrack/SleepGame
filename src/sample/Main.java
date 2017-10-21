package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Main extends Application {
    Opponent Helen = new Opponent(57);
    @Override
    public void start(Stage primaryStage) throws Exception{
        //create opponents
        Helen.setElapsedTime(50);
        TextArea t2 = new TextArea();
        t2.setEditable(false);
        t2.setPrefHeight(20);
        t2.setPrefWidth(40);

        Button b1 = new Button("update time"); //button1
        b1.setOnAction(e -> t2.appendText(LeaderboardUtils.printBoard(Helen)));

        Button b2 = new Button("add opponent"); //button2
        b2.setOnAction(e -> OpponentScreen.display("Create an Opponent", "Add Opponent feature coming soon!"));

        //set up the stage
        BorderPane root = new BorderPane();
        HBox buttonPane = new HBox();
        primaryStage.setTitle("Sleep Game v1.0");
        primaryStage.setScene(new Scene(root, 400, 275));
        primaryStage.show();

        //add buttons
        root.setBottom(buttonPane); // putting buttonPane at the button of a BorderPane
        buttonPane.getChildren().addAll(b1, b2);
        buttonPane.setSpacing(10);
        root.setCenter(t2);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
