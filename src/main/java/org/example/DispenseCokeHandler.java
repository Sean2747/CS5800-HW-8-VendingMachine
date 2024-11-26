package org.example;
import java.util.*;

public class DispenseCokeHandler extends SnackDispenseHandler{
    private SnackDispenseHandler next;
    public DispenseCokeHandler(SnackDispenseHandler next) {
        super(next);
    }

    public void handleRequest(VendingMachine machine) {
        if (machine.getSelectedSnack().equals("Coke")) {
            System.out.println("One Coke dispensed.");
            List<Snack> snacks = machine.getSnacks();
            for (Snack snack : snacks) {
                if (snack.getName().equals("Coke")) {
                    snack.quantityMinusOne();
                    break;
                }
            }
        } else {
            super.handleRequest(machine);
        }
    }
}
