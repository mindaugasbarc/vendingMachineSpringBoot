package com.mindaugasb.vending.machine.service;

public interface MachineState {


    double getBalance();
    void addMoney(double amount);
    void chargeMoney(double amount);

}
