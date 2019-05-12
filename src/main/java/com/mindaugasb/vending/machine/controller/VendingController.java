package com.mindaugasb.vending.machine.controller;

import com.mindaugasb.vending.machine.model.Item;
import com.mindaugasb.vending.machine.service.VendingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VendingController {

    private final VendingService vendingService;

    @Autowired
    public VendingController(VendingService vendingService) {
        this.vendingService = vendingService;
    }


    @RequestMapping(path = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Item> getThingsInVendingMachine() {
        return vendingService.fetchAllItems();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public void buyItem(@PathVariable("id") long id) {
        vendingService.dispenseItem(id);
    }

    @RequestMapping(path = "/money", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public void addCash(@RequestBody double amount) {
        vendingService.addMoney(amount);
    }
}

