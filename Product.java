package vending_machine;

public class Product {
    private String name;
    private int productNumber;
    private double price;
    private int amount = 10;

    public Product(String productName, int productNumber, double price) {
        this.name = productName;
        this.productNumber = productNumber;
        this.price = price;
    }

    public String getProductName() {
        return this.name;
    }

    public int getProductNumber() {
        return this.productNumber;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public int getAmount() {
        return this.amount;
    }

    public void decreaseAmount() {
        amount--;
    }

    public void setAmount (int amount){
        this.amount = amount;
    }

    public void resetAmount (){
        this.amount=10;
    }

    public void prepareProduct(double currentSum){
        this.decreaseAmount();
        if(currentSum > this.getPrice()){
            double change = currentSum - this.getPrice();
            System.out.printf("Change is %.2f%n" ,change);
        }
        System.out.println("ready");
    }
}
