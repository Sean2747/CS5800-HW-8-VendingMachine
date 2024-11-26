package org.example;

public class Main {
    public static void main(String[] args) {
        SnackDispenseHandler chain = new DispenseCokeHandler(new DispensePepsiHandler(new DispenseCheetosHandler(new DispenseDoritosHandler(new DispenseKitKatHandler(new DispenseSnickersHandler(null))))));
        VendingMachine vm = new VendingMachine(chain);
        Snack Coke = new Snack("Coke", 5, 2.50);
        Snack Pepsi = new Snack("Pepsi", 5, 2.50);
        Snack Cheetos = new Snack("Cheetos", 2, 3.00);
        Snack Doritos = new Snack("Doritos", 4, 3.00);
        Snack KitKat = new Snack("KitKat", 2, 2.00);
        Snack Snickers = new Snack("Snickers", 1, 2.00);

        vm.addSnack(Coke);
        vm.addSnack(Pepsi);
        vm.addSnack(Cheetos);
        vm.addSnack(Doritos);
        vm.addSnack(KitKat);
        vm.addSnack(Snickers);

        //not enough money
        vm.selectSnack("Coke");
        vm.insertMoney(1.0);
        vm.dispenseSnack();

        //pass
        System.out.println();
        vm.selectSnack("Snickers");
        vm.insertMoney(5.0);
        vm.dispenseSnack();

        //out of stock
        System.out.println();
        vm.selectSnack("Snickers");
        vm.insertMoney(5.0);
        vm.dispenseSnack();

        //invalid snack
        System.out.println();
        vm.selectSnack("Takis");
        vm.insertMoney(5.0);
        vm.dispenseSnack();

        //pass
        System.out.println();
        vm.selectSnack("Cheetos");
        vm.insertMoney(5.0);
        vm.dispenseSnack();

    }
}