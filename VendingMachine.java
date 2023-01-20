package vending_machine;

import java.util.Scanner;

public class VendingMachine {
    public void machineOperator(Product product, Inventory inventory) {
        Scanner scan = new Scanner(System.in);

        if (product.getAmount() <= 0) {
            System.out.println("The product is out of stock.");
            return;
        }

        System.out.print("Input coin or type stop: ");
        String input = scan.nextLine();
        double currentSum = 0;

        while (currentSum < product.getPrice() && !input.equals("stop")) {
            try {
                currentSum += Coin.coins.get(Integer.parseInt(input));
            } catch (NullPointerException ex) {
                System.out.println("Not valid coin!");
            } catch (NumberFormatException ex) {
                System.out.println("Not a number!");
            }

            if (currentSum < product.getPrice()) {
                System.out.print("Input coin or type stop: ");
                input = scan.nextLine();
            }
        }

        if (currentSum < product.getPrice()) {
            System.out.println("The money isn't enough!");
            System.out.println("Returning inserted cash: " + currentSum);
            return;
        }

        if (inventory.getCash() < (currentSum - product.getPrice())) {
            System.out.println("The device doesn't have change.");
            System.out.println("Returning inserted cash: " + currentSum);
            return;
        }

        product.prepareProduct(currentSum);
        System.out.println();
    }
}
