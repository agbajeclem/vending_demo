package demo;

import java.util.HashMap;
import java.util.Map;

public class VendingMachine {
    public static final double ONE = 1;
    public static final double FIVE = 5;
    public static final double TEN = 10;
    public static final double TWENTY_FIVE = 25;

    public static final String COKE = "Coke";
    public static final String PEPSI = "Pepsi";
    public static final String SODA = "Soda";

    public Map<String, Double> getItemsDB() {
        return itemsDB;
    }

    private Map<String, Double> itemsDB = new HashMap<>();

    public Map<String, Integer> getInventoriesDB() {
        return inventoriesDB;
    }

    private Map<String, Integer> inventoriesDB = new HashMap<>();

    public double getChange() {
        return change;
    }

    public void setChange(double change) {
        this.change = change;
    }

    private double change;

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    private double balance;

    public void loadItems() {
        itemsDB.put(COKE, 25.0);
        itemsDB.put(PEPSI, 35.0);
        itemsDB.put(SODA, 45.0);
    }

    public void loadInventories() {
        inventoriesDB.put(COKE, 20);
        inventoriesDB.put(PEPSI, 20);
        inventoriesDB.put(SODA, 20);
    }

    public VendingMachine() {
        balance = 0;
    }

    public void insertMoney(double amount) {
        balance += amount;
    }
    
    public double refundMoney() {
        double amount = 0;
        amount = this.balance;
        this.balance = 0;
        return amount;
    }

    public double buyItem(String itemName) {
        if(this.balance < itemsDB.get(itemName)) {
            //User has press select to purchase the item.
            System.out.println("Insufficient funds inserted, please complete payment");
            change = balance;
            balance = 0;
            return change;
        }
        inventoriesDB.put(itemName, inventoriesDB.get(itemName) - 1);

        // Compute change
        setChange(balance - itemsDB.get(itemName));

        System.out.println("Please take your item at the bottom of the vending machine");
        balance = 0;
        return change;
    }






}
