import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        try {
            ArrayList<Cust> clients = new ArrayList<>();

            Cust c1 = new Cust("099", "Shriya", "Kurup",
                    "kurupshriya@gmail.com", "7039193534", "Mumbai",
                    "0000000001", "PQRSTUVWXYZ");

            Cust c2 = new Cust("092", "Khushie", "Agrawal",
                    "khushieagrawal@gmail.com", "9819101984", "Bhopal",
                    "98765432109", "LMNOPQRSTU");

            Cust c3 = new Cust("091", "Khushi", "Harkhani",
                    "khushiharkhani@gmail.com", "9820924425", "Mumbai",
                    "12341234123", "ABCDEFGHIJ");

            clients.add(c1);
            clients.add(c2);
            clients.add(c3);

            ArrayList<Account> accounts = new ArrayList<>();

            SavingsAccount sa1 = new SavingsAccount(0001, 3000, c1);
            CurrentAccount ca1 = new CurrentAccount(0002, 10000, c1);
            SavingsAccount sa2 = new SavingsAccount(0003, 8000, c2);
            CurrentAccount ca2 = new CurrentAccount(0004, 15000, c2);
            SavingsAccount sa3 = new SavingsAccount(0005, 3000, c3);

            accounts.add(sa1); accounts.add(ca1);
            accounts.add(sa2); accounts.add(ca2);
            accounts.add(sa3);

            System.out.println("\n========== Transactions ==========\n");

            sa1.deposit(3000);
            sa1.withdraw(4000);
            sa1.applyInterest();

            System.out.println();

            Loan loan = new Loan(12000, 12);
            loan.printLoanDetails();
            loan.deductEMI(sa1);

            // --- NEW STUFF ADDED BELOW TO SHOW EXCEPTIONS ---

            System.out.println("\n========== Testing Different Exceptions ==========\n");

            // 1. Testing InsufficientBalanceException (Savings Min Balance Rule)
            try {
                System.out.println("Attempting to withdraw Rs. 6000 from sa1...");
                sa1.withdraw(6000); 
            } catch (InsufficientBalanceException e) {
                System.out.println("[Caught] " + e.getMessage());
            }

            // 2. Testing InvalidAccountException (Searching for non-existent ID)
            try {
                System.out.println("\nSearching for Account Number: 5555...");
                findAccount(accounts, 5555);
            } catch (InvalidAccountException e) {
                System.out.println("[Caught] " + e.getMessage());
            }

        } catch (InsufficientBalanceException e) {
            System.out.println("[Error] " + e.getMessage());
        }
    }

    // New Helper Method for InvalidAccountException
    public static Account findAccount(ArrayList<Account> accounts, int accNo) throws InvalidAccountException {
        for (Account acc : accounts) {
            if (acc.accountNumber == accNo) return acc;
        }
        throw new InvalidAccountException("Access Denied: Account #" + accNo + " is not registered.");
    }

    public static void displayAllInfo(ArrayList<Cust> clients, ArrayList<Account> accounts) {
        for (Cust client : clients) {
            client.printDetails();

            System.out.println("\n-- Linked Accounts --");
            double totalBalance = 0;
            int count = 0;

            for (Account acc : accounts) {
                if (acc.owner.custID.equals(client.custID)) {
                    acc.printSummary();
                    totalBalance += acc.getBalance();
                    count++;
                    System.out.println();
                }
            }

            if (count > 0) {
                System.out.println("Total Accounts : " + count);
                System.out.printf("Combined Balance: Rs. %.2f%n", totalBalance);
            } else {
                System.out.println("No accounts linked to this client.");
            }

            System.out.println("==================================\n");
        }
    }
}
