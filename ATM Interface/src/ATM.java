import java.util.Scanner;

public class ATM {
    private static int userPIN = 1234;
    private static double balance = 10000.0; // Initial balance
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to Console ATM");
        if (authenticate()) {
            int choice;
            do {
                showMenu();
                System.out.print("Enter your choice: ");
                choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        checkBalance();
                        break;
                    case 2:
                        deposit();
                        break;
                    case 3:
                        withdraw();
                        break;
                    case 4:
                        System.out.println("Thank you for using our ATM. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } while (choice != 4);
        } else {
            System.out.println("Too many incorrect attempts. Card blocked.");
        }
    }

    public static boolean authenticate() {
        int attempts = 0;
        while (attempts < 3) {
            System.out.print("Enter your 4-digit PIN: ");
            int enteredPIN = sc.nextInt();
            if (enteredPIN == userPIN) {
                return true;
            } else {
                System.out.println("Incorrect PIN. Try again.");
                attempts++;
            }
        }
        return false;
    }

    public static void showMenu() {
        System.out.println("\nATM Main Menu:");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    public static void checkBalance() {
        System.out.println("Your current balance is: ₹" + balance);
    }

    public static void deposit() {
        System.out.print("Enter amount to deposit: ₹");
        double amount = sc.nextDouble();
        if (amount > 0) {
            balance += amount;
            System.out.println("₹" + amount + " deposited successfully.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public static void withdraw() {
        System.out.print("Enter amount to withdraw: ₹");
        double amount = sc.nextDouble();
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("₹" + amount + " withdrawn successfully.");
        } else {
            System.out.println("Invalid or insufficient balance.");
        }
    }
}
