package Module_7_4.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Currencies")
public class Currency2 {
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

    public Currency2() {
    }

    public Currency2(String name, String abbreviation, double exchangeRate, String symbol) {
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

    @Override
    public String toString() {
        return String.format("%s %s %s %s", name, abbreviation, exchangeRate, symbol);
    }
}
