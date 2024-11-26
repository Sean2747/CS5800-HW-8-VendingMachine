package org.example;
import java.util.*;

public class DispenseCheetosHandler extends SnackDispenseHandler{
    private SnackDispenseHandler next;
    public DispenseCheetosHandler(SnackDispenseHandler next) {
        super(next);
    }

    public void handleRequest(VendingMachine machine) {
        if (machine.getSelectedSnack().equals("Cheetos")) {
            System.out.println("One Cheetos dispensed.");
            List<Snack> snacks = machine.getSnacks();
            for (Snack snack : snacks) {
                if (snack.getName().equals("Cheetos")) {
                    snack.quantityMinusOne();
                    break;
                }
            }
        } else {
            super.handleRequest(machine);
        }
    }
}