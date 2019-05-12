package com.mindaugasb.vending.machine.repository;

import com.mindaugasb.vending.machine.model.Balance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BalanceRepository extends JpaRepository<Balance, Long> {

}
