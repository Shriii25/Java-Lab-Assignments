public class CurrentAccount extends Account {

    private static final double MIN_REQUIRED_BALANCE = 1000.0;

    public CurrentAccount(int accountNumber, double initialBalance, Cust owner) {
        super(accountNumber, initialBalance, owner);
    }

    public void verifyMinimumBalance() {
        if (balance < MIN_REQUIRED_BALANCE)
            System.out.println("Warning: Minimum balance not maintained.");
        else
            System.out.println("Minimum balance requirement met.");
    }

    @Override
    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > balance)
            throw new InsufficientBalanceException("Current account has insufficient funds");
        balance -= amount;
        System.out.printf("Current Acct Withdrawn: Rs. %.2f | Balance: Rs. %.2f%n", amount, balance);
    }
}