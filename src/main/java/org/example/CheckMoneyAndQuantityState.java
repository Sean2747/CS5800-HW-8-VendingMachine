package org.example;

public class CheckMoneyAndQuantityState implements StateOfVendingMachine{
    public void selectSnack(VendingMachine machine, String snackName){}
    public void insertMoney(VendingMachine machine, double money){}
    public void checkMoneyAndQuantity(VendingMachine machine, String snackName, double insertedMoney){
        for (Snack snack : machine.getSnacks()) {
            if (snack.getName().equals(snackName)) {
                if (snack.getQuantity() == 0) {
                    System.out.println("Sorry. The item is out of stock.");
                    System.out.println("Money Returned.");
                    machine.setState(new IdleState());
                    return;
                }
                if (insertedMoney < snack.getPrice()) {
                    System.out.println("Sorry. Insufficient money inserted.");
                    System.out.println("Money Returned.");
                    machine.setState(new IdleState());
                    return;
                }
                System.out.println("Processing...");
                machine.setState(new DispenseSnackState());
                return;
            }
        }
        System.out.println("Error: Item not found.");
        System.out.println("Money Returned.");
        machine.setState(new IdleState());
    }
    public void dispenseSnack(VendingMachine machine){}
}
