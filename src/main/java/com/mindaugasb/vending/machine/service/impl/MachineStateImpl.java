package com.mindaugasb.vending.machine.service.impl;

import com.mindaugasb.vending.machine.exception.InsufficientBalanceException;
import com.mindaugasb.vending.machine.service.MachineState;
import org.springframework.stereotype.Component;

@Component
public class MachineStateImpl implements MachineState {

    private double balance = 0;

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public void addMoney(double amount) {
        if (balance < 0) {
            throw new IllegalArgumentException("positive amount should be added, but trying to add: " + amount);
        }
        balance+= amount;
    }

    @Override
    public void chargeMoney(double amount) {
        if (balance - amount >= 0) {
            balance-=amount;
        } else {
            throw new InsufficientBalanceException();
        }
    }
}
