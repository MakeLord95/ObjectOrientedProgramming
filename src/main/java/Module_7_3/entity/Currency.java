package Module_7_3.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Currencies")
public class Currency {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Abbreviation")
    private String abbreviation;

    @Column(name = "ExchangeRate")
    private double exchangeRate;

    @Column(name = "Symbol")
    private String symbol;


    public Currency() {
    }

    public Currency(String name, String abbreviation, double exchangeRate, String symbol) {
        this.name = name;
        this.abbreviation = abbreviation;
        this.exchangeRate = exchangeRate;
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(double exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public String getSymbol() {
        return symbol;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %s", name, abbreviation, exchangeRate, symbol);
    }
}
