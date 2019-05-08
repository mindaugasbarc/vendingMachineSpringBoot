package com.mindaugasb.vending.machine.exception.handler;

import com.mindaugasb.vending.machine.exception.InsufficientBalanceException;
import com.mindaugasb.vending.machine.exception.ItemNotFoundException;
import com.mindaugasb.vending.machine.exception.OutOfStockException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class VendingMachineExceptionHandler {

    @ExceptionHandler(value = InsufficientBalanceException.class)
    public ResponseEntity<String> handleInsufficientBalanceException(InsufficientBalanceException exception) {
        return new ResponseEntity<>("you do not have enough money to buy this, please insert coins",
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = ItemNotFoundException.class)
    public ResponseEntity<String> handleItemNotFoundException(ItemNotFoundException exception) {
        return new ResponseEntity<>("Item not found, please try different code",
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = OutOfStockException.class)
    public ResponseEntity<String> handleOutOfStockException(OutOfStockException exception) {
        return new ResponseEntity<>("item is out of stock, please choose another one",
                HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
