package vending_machine;

import java.util.Arrays;
import java.util.List;

public class Inventory {
    private double cash = 10.0;

    public double getCash() {
        return cash;
    }

    private final List<Product> products = Arrays.asList(
            new Product("Coke", 25, 1.20),
            new Product("Pepsi", 35, 1.60),
            new Product("Soda", 45, 0.8),
            new Product("Sprite", 55, 1.2),
            new Product("Hell", 65, 1.8),
            new Product("Redbull", 75, 3.2)
    );

    public List<Product> getProducts() {
        return products;
    }

    public  Product getProductObject(int productNumber){
        int indexOfProduct = -1;
        for (int i = 0; i < products.size() ; i++) {
            if(products.get(i).getProductNumber() == productNumber){
                indexOfProduct = i;
                break;
            }
        }
        return products.get(indexOfProduct);
    }

    public void displayProducts() {
        for (Product product : products) {
            System.out.printf("%s - %d - %.2f lv%n", product.getProductName(),
                    product.getProductNumber(), product.getPrice());
        }
    }

    public void updateCash(double money) {
        cash += money;
    }

    public void resetInventory (){
        cash = 10;

        for (Product product : products) {
            product.resetAmount();
        }
    }



}
