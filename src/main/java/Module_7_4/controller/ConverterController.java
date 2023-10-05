package Module_7_4.controller;

import Module_7_4.dao.CurrencyDAO;
import Module_7_4.dao.TransactionDAO;
import Module_7_4.entity.Currency2;
import Module_7_4.entity.CurrencyConverter;
import Module_7_4.entity.Transaction;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.Arrays;
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
    @FXML
    public Button newCurrencyButton;

    public void convertCurrency() {
        try {
            String sourceCurrencyAbbreviation = sourceCurrency.getValue();
            String targetCurrencyAbbreviation = targetCurrency.getValue();

            double amount = Double.parseDouble(amountBox.getText());

            double sourceRate = CurrencyDAO.getRate(sourceCurrencyAbbreviation);
            double targetRate = CurrencyDAO.getRate(targetCurrencyAbbreviation);

            resultBox.setText("%.2f".formatted(currencyConverter.convert(sourceRate, targetRate, amount)));

            System.out.println(sourceCurrencyAbbreviation);
            System.out.println(targetCurrencyAbbreviation);

            try {
                Currency2 source = CurrencyDAO.getCurrencyWithAbbreviation(sourceCurrencyAbbreviation);
                Currency2 target = CurrencyDAO.getCurrencyWithAbbreviation(targetCurrencyAbbreviation);
                System.out.println(source);
                System.out.println(target);

                Transaction transaction = new Transaction(amount, source, target);
                System.out.println(transaction);

                TransactionDAO.addTransaction(transaction);

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        } catch (Exception e) {
            amountBox.setStyle("-fx-background-color: red;");
        }
    }

    public void startup() {
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
            addCurrencies();
            enableButtons();

            warningLabel.setVisible(false);

            int currencyCount = CurrencyDAO.getCurrencyCount();

            for (int i = 1; i <= currencyCount; i++) {
                Currency2 currency = CurrencyDAO.getCurrency(i);
                currencyAbbreviations.add(Objects.requireNonNull(currency).getAbbreviation());
            }

            sourceCurrency.getItems().addAll(currencyAbbreviations);
            targetCurrency.getItems().addAll(currencyAbbreviations);

            sourceCurrency.setValue(currencyAbbreviations.get(0));
            targetCurrency.setValue(currencyAbbreviations.get(0));

        } catch (Exception e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
            System.out.println("Unable to connect to database");

            disableButtons();

            warningLabel.setText("Database connection Failed");
            warningLabel.setVisible(true);

            warningLabel.setOnMouseClicked(event -> startup());
        }
    }

    public void disableButtons() {
        convertButton.setDisable(true);
        amountBox.setDisable(true);
        sourceCurrency.setDisable(true);
        targetCurrency.setDisable(true);
        resultBox.setDisable(true);
        newCurrencyButton.setVisible(false);
    }

    public void enableButtons() {
        convertButton.setDisable(false);
        amountBox.setDisable(false);
        sourceCurrency.setDisable(false);
        targetCurrency.setDisable(false);
        resultBox.setDisable(false);
        newCurrencyButton.setVisible(false);
    }

    public void addCurrencies() {
        Currency2 usd = new Currency2("US Dollar", "USD", 1.0, "$");
        Currency2 eur = new Currency2("Euro", "EUR", 0.95, "€");
        Currency2 gbp = new Currency2("British Pound", "GBP", 0.82, "£");
        Currency2 cad = new Currency2("Canadian Dollar", "CAD", 1.35, "$");
        Currency2 jpy = new Currency2("Japanese Yen", "JPY", 149.07, "¥");
        Currency2 sek = new Currency2("Swedish Krona", "SEK", 11.01, "kr");
        Currency2 nok = new Currency2("Norwegian Krone", "NOK", 10.74, "kr");
        Currency2 aud = new Currency2("Australian Dollar", "AUD", 1.56, "$");

        CurrencyDAO.addCurrency(usd);
        CurrencyDAO.addCurrency(eur);
        CurrencyDAO.addCurrency(gbp);
        CurrencyDAO.addCurrency(cad);
        CurrencyDAO.addCurrency(jpy);
        CurrencyDAO.addCurrency(sek);
        CurrencyDAO.addCurrency(nok);
        CurrencyDAO.addCurrency(aud);
    }
}
