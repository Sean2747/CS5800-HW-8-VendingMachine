package org.example;
import java.util.*;

public class DispenseDoritosHandler extends SnackDispenseHandler{
    private SnackDispenseHandler next;
    public DispenseDoritosHandler(SnackDispenseHandler next) {
        super(next);
    }

    public void handleRequest(VendingMachine machine) {
        if (machine.getSelectedSnack().equals("Doritos")) {
            System.out.println("One Doritos dispensed.");
            List<Snack> snacks = machine.getSnacks();
            for (Snack snack : snacks) {
                if (snack.getName().equals("Doritos")) {
                    snack.quantityMinusOne();
                    break;
                }
            }
        } else {
            super.handleRequest(machine);
        }
    }
}

