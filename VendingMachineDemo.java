package vending_machine;

import java.util.Scanner;

public class VendingMachineDemo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        VendingMachine vend = new VendingMachine();
        Inventory inventory = new Inventory();

        String input = "";

        while (!input.equalsIgnoreCase("end")) {
            if (input.equals("reset")) {
                inventory.resetInventory();
                System.out.println("Machine is restarted.");
                break;
            }
            for (Product product : inventory.getProducts()) {
                System.out.printf("%s - %d - %.2f%n", product.getProductName(),
                        product.getProductNumber(), product.getPrice());
            }

            System.out.print("Choose product: ");
            input = scan.nextLine();

            try {
                Product product = inventory.getProductObject(Integer.parseInt(input));
                vend.machineOperator(product, inventory);
            } catch (ArrayIndexOutOfBoundsException exception) {
                System.out.println("You chose wrong number!");
            } catch (NumberFormatException e) {
                System.out.println();
            }
            System.out.println();
        }
    }
}
