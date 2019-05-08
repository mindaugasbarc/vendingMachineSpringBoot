package com.mindaugasb.vending.machine.service;

import com.mindaugasb.vending.machine.model.Item;

import java.util.List;

public interface VendingService {

    List<Item> fetchAllItems();

    Item fetchItem(long id);

    void dispenseItem(long id);

    void addMoney(double amount);
}
