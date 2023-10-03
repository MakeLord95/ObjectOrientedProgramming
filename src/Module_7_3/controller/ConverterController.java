package Module_7_3.controller;

import Module_7_3.dao.CurrencyDAO;
import Module_7_3.entity.Currency;
import Module_7_3.entity.CurrencyConverter;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.Objects;

public class ConverterController {
    private final ArrayList<String> currencyAbbreviations = new ArrayList<>();
    private final CurrencyConverter currencyConverter = new CurrencyConverter();
    @FXML
    private Label warningLabel;
    @FXML
    private Button convertButton;
    @FXML
    private TextField amountBox;
    @FXML
    private TextField resultBox;
    @FXML
    private ChoiceBox<String> sourceCurrency;
    @FXML
    private ChoiceBox<String> targetCurrency;

    public void convertCurrency() {
        try {
            String sourceCurrencyAbbreviation = sourceCurrency.getValue();
            String targetCurrencyAbbreviation = targetCurrency.getValue();

            double amount = Double.parseDouble(amountBox.getText());

            double sourceRate = CurrencyDAO.getRate(sourceCurrencyAbbreviation);
            double targetRate = CurrencyDAO.getRate(targetCurrencyAbbreviation);

            resultBox.setText("%.2f".formatted(currencyConverter.convert(sourceRate, targetRate, amount)));
        } catch (Exception e) {
            amountBox.setStyle("-fx-background-color: red;");
        }
    }

    public void initialize() {
        System.out.println("Application started");

        resultBox.setEditable(false);

        amountBox.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*(\\.\\d*)?")) {
                amountBox.setText(oldValue);
            }
        });

        amountBox.setOnMouseClicked(event -> {
            amountBox.setStyle("");
            amountBox.selectAll();
        });

        try {
            enableButtons();

            warningLabel.setVisible(false);

            int currencyCount = CurrencyDAO.getCurrencyCount();

            for (int i = 1; i <= currencyCount; i++) {
                Currency currency = CurrencyDAO.getCurrency(i);
                currencyAbbreviations.add(Objects.requireNonNull(currency).getAbbreviation());
            }

            sourceCurrency.getItems().addAll(currencyAbbreviations);
            targetCurrency.getItems().addAll(currencyAbbreviations);

            sourceCurrency.setValue(currencyAbbreviations.get(0));
            targetCurrency.setValue(currencyAbbreviations.get(0));

        } catch (Exception e) {
            System.out.println("Unable to connect to database");

            disableButtons();

            warningLabel.setText("Database connection Failed");
            warningLabel.setVisible(true);

            warningLabel.setOnMouseClicked(event -> initialize());
        }
    }

    public void disableButtons() {
        convertButton.setDisable(true);
        amountBox.setDisable(true);
        sourceCurrency.setDisable(true);
        targetCurrency.setDisable(true);
        resultBox.setDisable(true);
    }

    public void enableButtons() {
        convertButton.setDisable(false);
        amountBox.setDisable(false);
        sourceCurrency.setDisable(false);
        targetCurrency.setDisable(false);
        resultBox.setDisable(false);
    }
}
