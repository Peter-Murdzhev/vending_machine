package vending_machine;

import java.util.Scanner;

public class VendingMachine {
    public void machineOperator(Product product,Inventory inventory) {
        boolean isMoneyEnough = false;
        boolean isAvailable = false;

        Scanner scan = new Scanner(System.in);

        System.out.print("Input coin: ");
        String input = scan.nextLine();
        double currentSum = 0;

        while (currentSum < product.getPrice() && !input.equals("stop")) {
            try {
                currentSum += Coin.coins.get(Integer.parseInt(input));
            }catch (NullPointerException ex){
                System.out.println("Not valid coin!");
            }catch (NumberFormatException ex){
                System.out.println("Not a number!");
            }

            if(currentSum < product.getPrice()) {
                System.out.print("Input coin: ");
                input = scan.nextLine();
            }
        }

        if (currentSum >= product.getPrice()) {
            isMoneyEnough = true;
        } else {
            System.out.println("The money isn't enough!");
        }

        if (product.getAmount() > 0) {
            isAvailable = true;
        } else {
            System.out.println("The product is out of stock.");
        }

        if (!isAvailable || inventory.getCash() < currentSum) {
            if (inventory.getCash() < currentSum) {
                System.out.println("The device doesn't have change.");
            }
            currentSum = 0;
            return;
        }

        if (isMoneyEnough && inventory.getCash() >= currentSum) {
            product.prepareProduct(currentSum);
            currentSum = 0;
            System.out.println();
        }
    }


}
