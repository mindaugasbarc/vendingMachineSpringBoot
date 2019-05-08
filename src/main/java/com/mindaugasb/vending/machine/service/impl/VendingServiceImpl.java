package com.mindaugasb.vending.machine.service.impl;

import com.mindaugasb.vending.machine.exception.ItemNotFoundException;
import com.mindaugasb.vending.machine.model.Item;
import com.mindaugasb.vending.machine.repository.VendingRepository;
import com.mindaugasb.vending.machine.service.MachineActions;
import com.mindaugasb.vending.machine.service.VendingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendingServiceImpl implements VendingService {

    private final VendingRepository vendingRepository;
    private final MachineStateImpl machineState;
    private final MachineActions machineActions;

    @Autowired
    public VendingServiceImpl(VendingRepository vendingRepository, MachineStateImpl machineState, MachineActions machineActions) {
        this.vendingRepository = vendingRepository;
        this.machineState = machineState;
        this.machineActions = machineActions;
    }

    @Override
    public List<Item> fetchAllItems() {
        return vendingRepository.findAll();
    }

    @Override
    public Item fetchItem(long id) {
        return vendingRepository.findById(id)
                .orElseThrow(() -> new ItemNotFoundException("Item with id: " + id + " not found"));
    }

    @Override
    public void dispenseItem(long id) {
        Item item = fetchItem(id);
        machineState.chargeMoney(item.getPrice());
        machineActions.dispense(item);
    }

    @Override
    public void addMoney(double amount) {
        machineState.addMoney(amount);
    }
}
