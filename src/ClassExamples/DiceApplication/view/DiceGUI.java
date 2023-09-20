package ClassExamples.DiceApplication.view;

import ClassExamples.DiceApplication.controller.DiceController;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class DiceGUI extends Application {

    // initialize components that need to be accessed from multiple methods
    private final Label result = new Label("0");
    private final Spinner<Integer> sidesSpinner = new Spinner<>(1, 20, 6);
    private DiceController controller;

    public void start(Stage stage) {

        Button castButton = new Button("Cast");
        FlowPane pane = new FlowPane();

        stage.setTitle("Dice");

        // add outside margins for components
        Insets insets = new Insets(10, 10, 10, 10);
        FlowPane.setMargin(result, insets);
        FlowPane.setMargin(castButton, insets);
        FlowPane.setMargin(sidesSpinner, insets);

        // reserve space for result
        result.setMinWidth(30);
        result.setAlignment(Pos.CENTER);

        pane.getChildren().add(sidesSpinner);
        pane.getChildren().add(result);
        pane.getChildren().add(castButton);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();

        castButton.setOnAction(event -> controller.cast());

        stage.show();
    }


    public void init() {
        controller = new DiceController(this);
    }

    public int getSides() {
        return sidesSpinner.getValue();
    }

    public void setResult(int result) {
        this.result.setText(String.valueOf(result));
    }
}