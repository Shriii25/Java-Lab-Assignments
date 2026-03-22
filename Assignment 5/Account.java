public class Account {

    protected int accountNumber;
    protected double balance;
    protected Cust owner;

    public Account(int accountNumber, double initialBalance, Cust owner) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.owner = owner;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.printf("Deposited: Rs. %.2f | New Balance: Rs. %.2f%n", amount, balance);
    }

    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > balance)
            throw new InsufficientBalanceException("Insufficient funds for withdrawal");
        balance -= amount;
        System.out.printf("Withdrawn: Rs. %.2f | Remaining: Rs. %.2f%n", amount, balance);
    }

    public void printSummary() {
        System.out.println("Account No : " + accountNumber);
        System.out.println("Type       : " + this.getClass().getSimpleName());
        System.out.printf("Balance    : Rs. %.2f%n", balance);
        System.out.println("Holder     : " + owner.getFullName());
    }
}