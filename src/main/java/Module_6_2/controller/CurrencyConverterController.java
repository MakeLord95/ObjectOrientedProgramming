package Module_6_2.controller;

import Module_6_2.model.Currency;
import Module_6_2.model.CurrencyConverter;
import Module_6_2.view.CurrencyConverterView;

import java.util.ArrayList;

public class CurrencyConverterController {
    private final ArrayList<Currency> currencies = new ArrayList<>();
    private final CurrencyConverterView currencyConverterView;
    private final CurrencyConverter currencyConverter = new CurrencyConverter();

    public CurrencyConverterController(CurrencyConverterView currencyConverterView) {
        this.currencyConverterView = currencyConverterView;
        currencies.add(new Currency("USD"));
        currencies.add(new Currency("EUR"));
        currencies.add(new Currency("GBP"));
    }

    public static void main(String[] args) {
        CurrencyConverterView.launch(CurrencyConverterView.class);
    }

    public void convert() {
        double amount = Double.parseDouble(currencyConverterView.getAmount());
        String sourceCurrency = currencyConverterView.getSourceCurrency();
        String targetCurrency = currencyConverterView.getTargetCurrency();
        double result = currencyConverter.convert(amount, sourceCurrency, targetCurrency);
        currencyConverterView.setResult(String.format("%.2f", result));
    }

    public ArrayList<Currency> getCurrencies() {
        return currencies;
    }
}
