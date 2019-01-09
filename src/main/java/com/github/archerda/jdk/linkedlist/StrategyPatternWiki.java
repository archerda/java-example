package com.github.archerda.jdk.linkedlist;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by luohd on 16/11/30.
 */
public class StrategyPatternWiki {

    public static void main(String[] args) {
        Customer firstCustomer = new Customer(new NormalStrategy());

        // Normal billing
        firstCustomer.add(1.0, 1);

        // Start Happy Hour
        firstCustomer.setStrategy(new HappyHourStrategy());
        firstCustomer.add(1.0, 2);

        // New Customer
        Customer secondCustomer = new Customer(new HappyHourStrategy());
        secondCustomer.add(0.8, 1);
        // The Customer pays
        firstCustomer.printBill();

        // End Happy Hour
        secondCustomer.setStrategy(new NormalStrategy());
        secondCustomer.add(1.3, 2);
        secondCustomer.add(2.5, 1);
        secondCustomer.printBill();

    }
}

class Customer {

    private List<Double> drinks;
    private BillingStrategy strategy;

    public Customer(BillingStrategy strategy) {
        this.drinks = new ArrayList<Double>();
        this.strategy = strategy;
    }

    public void add(double price, int quantity) {
        drinks.add(strategy.getActPrice(price * quantity));
    }

    // Payment of bill
    public void printBill() {
        double sum = 0;
        for (Double i : drinks) {
            sum += i;
        }
        System.out.println("Total due: " + sum);
        drinks.clear();
    }

    // Set Strategy
    public void setStrategy(BillingStrategy strategy) {
        this.strategy = strategy;
    }

}

interface BillingStrategy {
    public double getActPrice(double rawPrice);
}

// Normal billing strategy (unchanged price)
class NormalStrategy implements BillingStrategy {

    @Override
    public double getActPrice(double rawPrice) {
        return rawPrice;
    }

}

// Strategy for Happy hour (50% discount)
class HappyHourStrategy implements BillingStrategy {

    @Override
    public double getActPrice(double rawPrice) {
        return rawPrice * 0.5;
    }

}