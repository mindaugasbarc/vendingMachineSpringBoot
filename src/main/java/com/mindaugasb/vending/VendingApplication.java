package com.mindaugasb.vending;

import com.mindaugasb.vending.machine.model.Balance;
import com.mindaugasb.vending.machine.model.Item;
import com.mindaugasb.vending.machine.repository.BalanceRepository;
import com.mindaugasb.vending.machine.repository.VendingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VendingApplication implements CommandLineRunner {

	@Autowired
	private VendingRepository vendingRepository;

	@Autowired
	private BalanceRepository balanceRepository;


	public static void main(String[] args) {
		SpringApplication.run(VendingApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		vendingRepository.save(new Item("snickers", 1, 2.0));
		vendingRepository.save(new Item("coca cola", 10, 1));
		balanceRepository.save(new Balance(5));
	}
}
