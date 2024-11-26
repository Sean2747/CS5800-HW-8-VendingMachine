package org.example;

public class IdleState implements StateOfVendingMachine{
    public void selectSnack(VendingMachine machine, String snackName){
        machine.setSelectedSnack(snackName);
        machine.setState(new WaitForMoneyState());
        System.out.println("You selected: " + snackName);
    }
    public void insertMoney(VendingMachine machine, double money){}
    public void checkMoneyAndQuantity(VendingMachine machine, String snackName, double insertedMoney){}
    public void dispenseSnack(VendingMachine machine){}
}
