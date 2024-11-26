package org.example;
import java.util.*;

public class DispenseKitKatHandler extends SnackDispenseHandler{
    private SnackDispenseHandler next;
    public DispenseKitKatHandler(SnackDispenseHandler next) {
        super(next);
    }

    public void handleRequest(VendingMachine machine) {
        if (machine.getSelectedSnack().equals("KitKat")) {
            System.out.println("One KitKat dispensed.");
            List<Snack> snacks = machine.getSnacks();
            for (Snack snack : snacks) {
                if (snack.getName().equals("KitKat")) {
                    snack.quantityMinusOne();
                    break;
                }
            }
        } else {
            super.handleRequest(machine);
        }
    }
}
