package Module_6_2.model;

public class CurrencyConverter {
    public double convert(double amount, String sourceCurrency, String targetCurrency) {
        double rateUSD2EUR = 0.94;
        double rateUSD2GBP = 0.82;

        double result = 0.0;
        result = switch (sourceCurrency) {
            case "USD" -> switch (targetCurrency) {
                case "USD" -> amount;
                case "EUR" -> amount * rateUSD2EUR;
                case "GBP" -> amount * rateUSD2GBP;
                default -> result;
            };
            case "EUR" -> switch (targetCurrency) {
                case "USD" -> amount / rateUSD2EUR;
                case "EUR" -> amount;
                case "GBP" -> amount * (rateUSD2GBP / rateUSD2EUR);
                default -> result;
            };
            case "GBP" -> switch (targetCurrency) {
                case "USD" -> amount / rateUSD2GBP;
                case "EUR" -> amount * (rateUSD2EUR / rateUSD2GBP);
                case "GBP" -> amount;
                default -> result;
            };
            default -> 0.0;
        };
        return result;
    }
}
