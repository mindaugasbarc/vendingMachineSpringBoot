package com.mindaugasb.vending.machine.service.impl;

import com.mindaugasb.vending.machine.exception.OutOfStockException;
import com.mindaugasb.vending.machine.model.Item;
import com.mindaugasb.vending.machine.repository.VendingRepository;
import com.mindaugasb.vending.machine.service.MachineActions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class MachineActionsImpl implements MachineActions {

    private final VendingRepository vendingRepository;

    @Autowired
    public MachineActionsImpl(VendingRepository vendingRepository) {
        this.vendingRepository = vendingRepository;
    }

    @Override
    @Transactional
    public void dispense(Item item) {
        if (item.getQuantity() > 0) {
            item.setQuantity(item.getQuantity() - 1);
            vendingRepository.save(item);
            System.out.println("dispensed " + item.getName());
        } else {
            throw new OutOfStockException(item.toString());
        }
        throw new RuntimeException();
    }
}
