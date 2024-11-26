package org.example;

public abstract class SnackDispenseHandler {
    private SnackDispenseHandler next;
    SnackDispenseHandler(SnackDispenseHandler next) {
    this.next = next;
    }
    public void handleRequest(VendingMachine machine) {
        if(next != null) {
            next.handleRequest(machine);
        }
    }
}
