package Module_7_4.entity;

public class CurrencyConverter {
    public double convert(double sourceRate, double targetRate, double amount) {

        return amount * (targetRate / sourceRate);
    }
}
