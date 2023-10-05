package Module_7_4.entity;

import jakarta.persistence.*;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private double amount;

    @ManyToOne
    private Currency2 source;

    @ManyToOne
    private Currency2 target;

    public Transaction() {
    }

    public Transaction(double amount, Currency2 source, Currency2 target) {
        this.amount = amount;
        this.source = source;
        this.target = target;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", amount=" + amount +
                ", source=" + source +
                ", target=" + target +
                '}';
    }
}
