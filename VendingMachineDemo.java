package vending_machine;

import java.util.Scanner;

public class VendingMachineDemo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        VendingMachine vending = new VendingMachine();
        Inventory inventory = new Inventory();

        String input = "";

        while (!input.equalsIgnoreCase("end")) {
            if (input.equals("reset")) {
                inventory.resetInventory();
                System.out.println("Machine is restarted.");
                break;
            }

            inventory.displayProducts();

            System.out.print("Choose product number or type end: ");
            input = scan.nextLine();

            if(input.equalsIgnoreCase("end")){
                break;
            }

            try {
                Product product = inventory.getProductObject(Integer.parseInt(input));
                vending.machineOperator(product, inventory);
            } catch (ArrayIndexOutOfBoundsException exception) {
                System.out.println("You chose wrong number!");
                System.out.println();
            } catch (NumberFormatException e) {
                System.out.println("Choose the number of the product.");
                System.out.println();
            }
        }
    }
}
