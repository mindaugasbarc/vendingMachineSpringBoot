package com.mindaugasb.vending.machine.service.impl;

import com.mindaugasb.vending.machine.exception.ItemNotFoundException;
import com.mindaugasb.vending.machine.model.Item;
import com.mindaugasb.vending.machine.repository.VendingRepository;
import com.mindaugasb.vending.machine.service.VendingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendingServiceImpl implements VendingService {

    private final VendingRepository vendingRepository;

    @Autowired
    public VendingServiceImpl(VendingRepository vendingRepository) {
        this.vendingRepository = vendingRepository;
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
}
