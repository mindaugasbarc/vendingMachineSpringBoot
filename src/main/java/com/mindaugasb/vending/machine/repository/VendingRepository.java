package com.mindaugasb.vending.machine.repository;

import com.mindaugasb.vending.machine.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendingRepository extends JpaRepository<Item, Long>{


}
