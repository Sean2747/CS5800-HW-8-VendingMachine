package org.example;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class DispenseCokeHandlerTest {

    private VendingMachine machine;
    private SnackDispenseHandler handler;
    private Snack coke;
    private Snack pepsi;

    @BeforeEach
    void setUp() {
        handler = new DispenseCokeHandler(null);
        coke = new Snack("Coke", 5, 2.50);
        pepsi = new Snack("Pepsi", 5, 2.50);
        machine = new VendingMachine(handler);
        machine.addSnack(coke);
        machine.addSnack(pepsi);
    }

    @Test
    void dispenseCokeTest() {
        machine.selectSnack("Coke");
        handler.handleRequest(machine);
        assertEquals(4, coke.getQuantity());
    }

    @Test
    void outOfStockTest() {
        machine = new VendingMachine(handler);
        coke = new Snack("Coke", 0, 2.50);
        machine.addSnack(coke);
        machine.selectSnack("Coke");
        assertEquals(0, coke.getQuantity());
    }
}