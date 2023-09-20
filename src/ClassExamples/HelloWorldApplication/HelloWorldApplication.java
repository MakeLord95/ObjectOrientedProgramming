package ClassExamples.HelloWorldApplication;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class HelloWorldApplication extends Application {
    public void start(Stage window) {
        Label text = new Label("Hello World!");
        Label buttonText = new Label();

        Button button = new Button("Click me!");
        FlowPane componentGroup = new FlowPane();
        componentGroup.getChildren().add(text);
        componentGroup.getChildren().add(button);
        componentGroup.getChildren().add(buttonText);

        button.setOnAction(event -> {
            buttonText.setText("Button clicked!");
        });

        Scene view = new Scene(componentGroup);
        window.setTitle("My Greeting Application");
        window.setScene(view);
        window.show();
    }
}
