package com.mindaugasb.vending.machine.service.impl;

import com.mindaugasb.vending.machine.exception.OutOfStockException;
import com.mindaugasb.vending.machine.model.Item;
import com.mindaugasb.vending.machine.service.MachineActions;

public class MachineActionsImpl implements MachineActions {

    @Override
    public void dispense(Item item) {
        if (item.getQuantity() > 0) {
            item.setQuantity(item.getQuantity() - 1);
            System.out.println("dispensed " + item.getName());
        } else {
            throw new OutOfStockException(item.toString());
        }
    }
}
