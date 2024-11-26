package org.example;

public interface StateOfVendingMachine {
    public void selectSnack(VendingMachine machine, String snackName);
    public void insertMoney(VendingMachine machine, double money);
    public void checkMoneyAndQuantity(VendingMachine machine, String snackName, double insertedMoney);
    public void dispenseSnack(VendingMachine machine);
}
