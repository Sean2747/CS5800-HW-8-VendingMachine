package org.example;
import java.util.*;

public class DispensePepsiHandler extends SnackDispenseHandler{
    private SnackDispenseHandler next;
    public DispensePepsiHandler(SnackDispenseHandler next) {
        super(next);
    }

    public void handleRequest(VendingMachine machine) {
        if (machine.getSelectedSnack().equals("Pepsi")) {
            System.out.println("One pepsi dispensed.");
            List<Snack> snacks = machine.getSnacks();
            for (Snack snack : snacks) {
                if (snack.getName().equals("Pepsi")) {
                    snack.quantityMinusOne();
                    break;
                }
            }
        } else {
            super.handleRequest(machine);
        }
    }
}