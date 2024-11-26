package org.example;

public class WaitForMoneyState implements StateOfVendingMachine{
    public void selectSnack(VendingMachine machine, String snackName){}
    public void insertMoney(VendingMachine machine, double money){
        machine.setInsertedMoney(money);
        machine.setState(new CheckMoneyAndQuantityState());
        System.out.println("Money inserted: " + machine.getInsertedMoney());
    }
    public void checkMoneyAndQuantity(VendingMachine machine, String snackName, double insertedMoney){}
    public void dispenseSnack(VendingMachine machine){}
}
