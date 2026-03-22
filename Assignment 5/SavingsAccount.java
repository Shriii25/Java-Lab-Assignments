public class SavingsAccount extends Account {

    private static final double INTEREST_RATE = 0.04;
    private static final double MIN_BALANCE = 500.0;

    public SavingsAccount(int accountNumber, double initialBalance, Cust owner) {
        super(accountNumber, initialBalance, owner);
    }

    public void applyInterest() {
        double interest = balance * INTEREST_RATE;
        System.out.printf("Interest Accrued (%.0f%%): Rs. %.2f%n", INTEREST_RATE * 100, interest);
    }

    @Override
    public void withdraw(double amount) throws InsufficientBalanceException {
        if (balance - amount < MIN_BALANCE)
            throw new InsufficientBalanceException(
                "Savings account must maintain a minimum balance of Rs. " + MIN_BALANCE
            );
        balance -= amount;
        System.out.printf("Savings Withdrawn: Rs. %.2f | Balance: Rs. %.2f%n", amount, balance);
    }
}