package org.example;
import java.util.*;

public class VendingMachine {
    private List<Snack> snacks;
    private StateOfVendingMachine state;
    private SnackDispenseHandler dispenseHandler;//
    private String selectedSnack;
    private double insertedMoney;

    VendingMachine(SnackDispenseHandler dispenseHandler) {
        snacks = new ArrayList<>();
        state = new IdleState();
        this.dispenseHandler = dispenseHandler;
    }

    public void addSnack(Snack snack) {
        snacks.add(snack);
    }

    public List<Snack> getSnacks() {
        return snacks;
    }

    public void setState(StateOfVendingMachine state) {
        this.state = state;
    }

    public StateOfVendingMachine getState() {
        return state;
    }

    public void setSelectedSnack(String selectedSnack) {
        this.selectedSnack = selectedSnack;
    }

    public String getSelectedSnack() {
        return selectedSnack;
    }

    public void setInsertedMoney(double insertedMoney) {
        this.insertedMoney = insertedMoney;
    }

    public double getInsertedMoney() {
        return insertedMoney;
    }

    public SnackDispenseHandler getDispenseHandler() {
        return dispenseHandler;
    }

    public void selectSnack(String snack){
        getState().selectSnack(this, snack);
    }

    public void insertMoney(double moneyInserted){
        getState().insertMoney(this, moneyInserted);
        checkMoneyAndQuantity();
    }

    public void checkMoneyAndQuantity(){
        getState().checkMoneyAndQuantity(this, getSelectedSnack(), getInsertedMoney());
    }

    public void dispenseSnack(){
        getState().dispenseSnack(this);
    }
}
