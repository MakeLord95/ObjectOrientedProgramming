package Module_6_2.view;

import Module_6_2.controller.CurrencyConverterController;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

import java.util.function.UnaryOperator;
import java.util.regex.Pattern;

public class CurrencyConverterView extends Application {
    private CurrencyConverterController controller;
    private final ChoiceBox<String> sourceCurrency = new ChoiceBox<>();
    private final ChoiceBox<String> targetCurrency = new ChoiceBox<>();
    private TextField amount;
    private final TextField result = new TextField();

    @Override
    public void start(Stage primaryStage) {
        GridPane gridPane = new GridPane();
        gridPane.setPrefSize(400, 100);
        gridPane.setPadding(new Insets(5, 10, 5, 10));
        gridPane.setHgap(5);

        amount = new TextField();

        Pattern validDoubleText = Pattern.compile("-?\\d*(\\.\\d*)?");

        UnaryOperator<TextFormatter.Change> filter = change -> {
            String newText = change.getControlNewText();
            if (validDoubleText.matcher(newText).matches() || newText.isEmpty()) {
                return change;
            } else {
                return null;
            }
        };

        TextFormatter<String> textFormatter = new TextFormatter<>(filter);
        amount.setTextFormatter(textFormatter);

        for (int i = 0; i < 5; i++) {
            ColumnConstraints col = new ColumnConstraints();
            col.setHgrow(Priority.SOMETIMES);
            col.setMinWidth(10.0);
            col.setPrefWidth(100.0);
            gridPane.getColumnConstraints().add(col);
        }

        for (int i = 0; i < 3; i++) {
            RowConstraints row = new RowConstraints();
            row.setMinHeight(10.0);
            row.setPrefHeight(30.0);
            row.setVgrow(Priority.SOMETIMES);
            gridPane.getRowConstraints().add(row);
        }

        result.setEditable(false);
        Button convertButton = new Button("Convert");

        sourceCurrency.setPrefWidth(150.0);
        for (int i = 0; i < controller.getCurrencies().size(); i++) {
            sourceCurrency.getItems().add(controller.getCurrencies().get(i).getName());
        }
        sourceCurrency.setValue(controller.getCurrencies().get(0).getName());

        targetCurrency.setPrefWidth(150.0);
        for (int i = 0; i < controller.getCurrencies().size(); i++) {
            targetCurrency.getItems().add(controller.getCurrencies().get(i).getName());
        }
        targetCurrency.setValue(controller.getCurrencies().get(0).getName());

        Label labelFrom = new Label("From");
        Label labelTo = new Label("To");
        Label labelAmount = new Label("Amount");
        Label labelResult = new Label("Result");
        Label labelArrow = new Label("→");

        GridPane.setRowIndex(amount, 1);
        GridPane.setColumnIndex(result, 4);
        GridPane.setRowIndex(result, 1);
        GridPane.setColumnIndex(convertButton, 2);
        GridPane.setRowIndex(convertButton, 2);
        GridPane.setColumnIndex(sourceCurrency, 1);
        GridPane.setRowIndex(sourceCurrency, 1);
        GridPane.setColumnIndex(targetCurrency, 3);
        GridPane.setRowIndex(targetCurrency, 1);
        GridPane.setColumnIndex(labelFrom, 1);
        GridPane.setColumnIndex(labelTo, 3);
        GridPane.setColumnIndex(labelAmount, 0);
        GridPane.setColumnIndex(labelResult, 4);
        GridPane.setColumnIndex(labelArrow, 2);

        gridPane.getChildren().addAll(
                amount, result, convertButton, sourceCurrency, targetCurrency,
                labelFrom, labelTo, labelAmount, labelResult, labelArrow
        );

        Scene scene = new Scene(gridPane);

        scene.getStylesheets().add("Module_6_2/resources/style.css");

        primaryStage.setScene(scene);
        primaryStage.setTitle("Currency Converter");
        primaryStage.setResizable(false);
        primaryStage.show();

        convertButton.setOnAction(actionEvent -> controller.convert());
    }

    public void init() {
        controller = new CurrencyConverterController(this);
    }

    public String getAmount() {
        return amount.getText();
    }

    public String getSourceCurrency() {
        return sourceCurrency.getValue();
    }

    public String getTargetCurrency() {
        return targetCurrency.getValue();
    }

    public void setResult(String result) {
        this.result.setText(result);
    }
}
