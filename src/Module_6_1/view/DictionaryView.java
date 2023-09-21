package Module_6_1.view;

import Module_6_1.controller.DictionaryController;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class DictionaryView extends Application {
    private final TextField word = new TextField();
    private final TextField meaning = new TextField();
    private DictionaryController controller;

    @Override
    public void start(Stage stage) {
        Button addWordButton = new Button("Add Word");
        Button getMeaningButton = new Button("Get Meaning");

        FlowPane pane = new FlowPane();

        stage.setTitle("Dictionary");

        Insets insets = new Insets(10, 10, 10, 10);
        FlowPane.setMargin(word, insets);
        FlowPane.setMargin(meaning, insets);
        FlowPane.setMargin(addWordButton, insets);
        FlowPane.setMargin(getMeaningButton, insets);

        pane.getChildren().add(word);
        pane.getChildren().add(meaning);
        pane.getChildren().add(addWordButton);
        pane.getChildren().add(getMeaningButton);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();

        addWordButton.setOnAction(actionEvent -> controller.addWordToDictionary());

        getMeaningButton.setOnAction(actionEvent -> getWordMeaning());


        word.setOnMouseClicked(event -> {
            word.clear();
            word.setPromptText("");
            word.setStyle("");
        });

        meaning.setOnMouseClicked(event -> {
            meaning.clear();
            meaning.setPromptText("");
            meaning.setStyle("");
        });
    }

    public void init() {
        controller = new DictionaryController(this);
    }

    public String getTextInBoxes() {
        return String.format("%s,%s", word.getText(), meaning.getText());
    }

    public void getWordMeaning() {
        String wordMeaning = controller.getWordMeaning(word.getText().toLowerCase());
        if (word.getText().isEmpty()) {
            illegalArgument();
        } else {
            meaning.setText(wordMeaning);
        }
    }

    public void illegalArgument() {
        if (meaning.getText().isEmpty()) {
            meaning.setPromptText("Empty field");
            meaning.setStyle("-fx-background-color: red;");
        }
        if (word.getText().isEmpty()) {
            word.setPromptText("Empty field");
            word.setStyle("-fx-background-color: red;");
        }
    }
}
