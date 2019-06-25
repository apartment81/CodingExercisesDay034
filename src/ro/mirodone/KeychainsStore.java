package ro.mirodone;

import java.util.Scanner;

public class KeychainsStore {


    void Menu() {

        Scanner keyboard = new Scanner(System.in);

        int choice = 1, numKeychains = 0, price = 10, shipping = 5, extraShipping = 1;

        System.out.println("Rachel's Keychain Boutique");
        System.out.println();

        while (choice != 4) {

            System.out.println("1. Add Keychains to Order");
            System.out.println("2. Remove Keychains from Order");
            System.out.println("3. View Current Order");
            System.out.println("4. Checkout");
            System.out.println();
            System.out.print("Please enter your choice: ");
            choice = keyboard.nextInt();
            System.out.println();

            if (choice == 1) {

                numKeychains = addKeychains(numKeychains);
                System.out.println("You now have " + numKeychains + " keychains.");

            } else if (choice == 2) {

                numKeychains = removeKeychains(numKeychains);
                System.out.println("You now have " + numKeychains + " keychains.");

            } else if (choice == 3) {

                viewOrder(numKeychains, price, shipping, extraShipping);

            } else if (choice == 4) {

                checkout(numKeychains, price, shipping, extraShipping);

            } else {

                System.out.println("Please try again.");

            }

            System.out.println();
        }

    }

    private int addKeychains(int keychains) {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("You have " + keychains + " keychains. How many to add? ");
        int add = keyboard.nextInt();
        keychains = keychains + add;
        return keychains;
    }

   private int removeKeychains(int keychains) {
        Scanner keyboard = new Scanner(System.in);
        int remove ;

        do {
            System.out.print("You have " + keychains + " keychains. How many to remove? ");
            remove = keyboard.nextInt();

            if (remove > keychains) {
                System.out.println("You cannot remove that many! Try again.");
            }
        } while (remove > keychains);

        keychains = keychains - remove;
        return keychains;
    }

    private void viewOrder(int num, int cost, int shipping, int extraShipping) {
        int total = num * cost;
        int totalShipping = shipping + (num - 1) * (extraShipping);
        int withShipping = total + totalShipping;

        System.out.println("You have " + num + " keychains.");
        System.out.println("Keychains cost $" + cost + " each.");
        System.out.println("Shipping charges amount to $" + totalShipping + ".");
        System.out.println("Total cost is $" + withShipping + ".");
    }

   private void checkout(int num, int cost, int shipping, int extraShipping) {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("What is your name? ");
        String name = keyboard.next();
        viewOrder(num, cost, shipping, extraShipping);
        System.out.println("Thanks for your order, " + name + "!");
    }

}
