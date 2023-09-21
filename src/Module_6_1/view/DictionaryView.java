package Module_6_1.view;

import Module_6_1.controller.DictionaryController;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

/*
 * This class is the view of the application
 */

public class DictionaryView extends Application {
    private final TextField word = new TextField();
    private final TextField meaning = new TextField();
    private DictionaryController controller;

    @Override
    public void start(Stage stage) {
        Button addWordButton = new Button("Add Word");
        Button getMeaningButton = new Button("Get Meaning");
        Button printLibrary = new Button("Print Library");

        FlowPane pane = new FlowPane();

        stage.setTitle("Dictionary");

        /*
         * Setting the margins for the nodes
         */
        Insets insets = new Insets(10, 10, 10, 10);
        FlowPane.setMargin(word, insets);
        FlowPane.setMargin(meaning, insets);
        FlowPane.setMargin(addWordButton, insets);
        FlowPane.setMargin(getMeaningButton, insets);
        FlowPane.setMargin(printLibrary, insets);

        /*
         * Adding the nodes to the pane
         */
        pane.getChildren().add(word);
        pane.getChildren().add(meaning);
        pane.getChildren().add(addWordButton);
        pane.getChildren().add(getMeaningButton);
        pane.getChildren().add(printLibrary);

        /*
         * Setting the scene
         */
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();

        addWordButton.setOnAction(actionEvent -> controller.addWordToDictionary());

        getMeaningButton.setOnAction(actionEvent -> getWordMeaning());

        printLibrary.setOnAction(actionEvent -> controller.getDictionary());
    }

    /*
     * Initializes the controller
     */
    public void init() {
        controller = new DictionaryController(this);
    }

    /*
     * Gets the text in the text fields
     */
    public String getTextInBoxes() {
        return String.format("%s,%s", word.getText(), meaning.getText());
    }

    /*
     * Gets the meaning of a word
     */
    public void getWordMeaning() {
        String wordMeaning = controller.getWordMeaning(word.getText().toLowerCase());
        if (word.getText().isEmpty()) {
            word.setText("Empty field");
        } else {
            meaning.setText(wordMeaning);
        }
    }

    /*
     * Displays an error message if the user enters an empty field
     */
    public void illegalArgument() {
        if (meaning.getText().isEmpty()) {
            meaning.setText("Empty field");
        }
        if (word.getText().isEmpty()) {
            word.setText("Empty field");
        }
    }
}
