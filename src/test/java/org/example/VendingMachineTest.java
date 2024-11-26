package org.example;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VendingMachineTest {
    private VendingMachine machine;
    private Snack coke;

    @BeforeEach
    void setUp() {
        SnackDispenseHandler dispenseHandler = new DispenseCokeHandler(null);
        machine = new VendingMachine(dispenseHandler);
        coke = new Snack("Coke", 5, 2.50);
        machine.addSnack(coke);
    }

    @Test
    void addSnackTest() {
        assertTrue(machine.getSnacks().contains(coke));
    }

    @Test
    void selectSnackTest() {
        machine.selectSnack("Coke");
        assertEquals("Coke", machine.getSelectedSnack());
    }

    @Test
    void insertMoneyTest() {
        machine.insertMoney(5.00);
        assertEquals(5.00, machine.getInsertedMoney());
    }

    @Test
    void dispenseSnackTest() {
        machine.selectSnack("Coke");
        machine.insertMoney(5.00);
        machine.dispenseSnack();
        assertEquals(4, coke.getQuantity());
    }

    @Test
    void snackOutOfStockTest() {
        Snack pepsi = new Snack("Pepsi", 0, 2.50);
        machine.addSnack(pepsi);
        machine.selectSnack("Pepsi");
        machine.insertMoney(2.00);
        machine.checkMoneyAndQuantity();
        assertEquals(0, pepsi.getQuantity());
    }
}