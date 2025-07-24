import java.util.Scanner;


class Task3 {
    private double balance;

    
    public Task3(double initialBalance) {
        balance = initialBalance;
    }

    // Deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Amount deposited: " + amount);
        } else {
            System.out.println("Invalid amount. Please try again.");
        }
    }

    // Withdraw money
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Amount withdrawn: " + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    // Check current balance
    public void checkBalance() {
        System.out.println("Current balance: " + balance);
    }
}

// Class to represent the ATM machine
public class ATM {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Create a bank account with ₹1000 as the starting balance
        Task3 myAccount = new Task3(1000);

        int choice;
        do {
            // Display ATM menu
            System.out.println("\n------ Welcome to INDIAN ATM ------");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    myAccount.checkBalance();
                    break;
                case 2:
                    System.out.print( "Enter amount to deposit: ");
                    double depositAmount = input.nextDouble();
                    myAccount.deposit(depositAmount);
                    break;
                case 3:
                    System.out.print( "Enter amount to withdraw: ");
                    double withdrawAmount = input.nextDouble();
                    myAccount.withdraw(withdrawAmount);
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please choose from 1 to 4.");
            }

        } while (choice != 4);

        input.close();
    }
}
