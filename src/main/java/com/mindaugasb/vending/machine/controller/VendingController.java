package com.mindaugasb.vending.machine.controller;

import com.mindaugasb.vending.machine.model.Item;
import com.mindaugasb.vending.machine.service.VendingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
}

