package com.mindaugasb.vending.machine.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Balance {

    @Id
    @GeneratedValue
    private long id;

    private double amount;

    public Balance(double amount) {
        this.amount = amount;
    }

    public Balance() {
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Balance balance = (Balance) o;
        return id == balance.id &&
                Double.compare(balance.amount, amount) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, amount);
    }

    @Override
    public String toString() {
        return "Balance{" +
                "id=" + id +
                ", amount=" + amount +
                '}';
    }
}
