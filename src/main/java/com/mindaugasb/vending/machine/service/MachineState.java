package com.mindaugasb.vending.machine.service;

import com.mindaugasb.vending.machine.model.Balance;

public interface MachineState {


    Balance getBalance();
    void addMoney(double amount);
    void chargeMoney(double amount);

}
