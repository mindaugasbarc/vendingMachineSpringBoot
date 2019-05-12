package com.mindaugasb.vending.machine.service.impl;

import com.mindaugasb.vending.machine.exception.InsufficientBalanceException;
import com.mindaugasb.vending.machine.model.Balance;
import com.mindaugasb.vending.machine.repository.BalanceRepository;
import com.mindaugasb.vending.machine.service.MachineState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class MachineStateImpl implements MachineState {

    private final BalanceRepository balanceRepository;

    @Autowired
    public MachineStateImpl(BalanceRepository balanceRepository) {
        this.balanceRepository = balanceRepository;
    }

    @Override
    public Balance getBalance(){
        return balanceRepository.findAll().stream().findFirst().orElseThrow(IllegalStateException::new);
    }

    @Override
    public void addMoney(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("positive amount should be added, but trying to add: " + amount);
        }
        balanceRepository.save(updateBalance(getBalance(), amount));
    }

    @Override
    @Transactional
    public void chargeMoney(double amount) {
        if (getBalance().getAmount() - amount >= 0) {
            balanceRepository.save(updateBalance(getBalance(), amount));
        } else {
            throw new InsufficientBalanceException();
        }
    }

    private Balance updateBalance(Balance balance, double amount) {
        balance.setAmount(balance.getAmount() + amount);
        return balance;
    }
}
