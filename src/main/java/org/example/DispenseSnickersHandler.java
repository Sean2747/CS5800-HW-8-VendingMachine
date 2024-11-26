package org.example;
import java.util.*;

public class DispenseSnickersHandler extends SnackDispenseHandler {
    private SnackDispenseHandler next;
    public DispenseSnickersHandler(SnackDispenseHandler next) {
        super(next);
    }

    public void handleRequest(VendingMachine machine) {
        if (machine.getSelectedSnack().equals("Snickers")) {
            System.out.println("One Snickers dispensed.");
            List<Snack> snacks = machine.getSnacks();
            for (Snack snack : snacks) {
                if (snack.getName().equals("Snickers")) {
                    snack.quantityMinusOne();
                    break;
                }
            }
        } else {
            super.handleRequest(machine);
        }
    }
}
