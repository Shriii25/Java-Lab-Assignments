public class Loan {

    private double principal;
    private int tenureMonths;
    private double monthlyEMI;

    public Loan(double principal, int tenureMonths) {
        this.principal = principal;
        this.tenureMonths = tenureMonths;
        this.monthlyEMI = principal / tenureMonths;
    }

    public void deductEMI(Account acc) throws InsufficientBalanceException {
        if (acc.getBalance() < monthlyEMI)
            throw new InsufficientBalanceException("Balance too low to cover EMI payment");

        acc.balance -= monthlyEMI;
        System.out.printf("EMI Deducted  : Rs. %.2f%n", monthlyEMI);
        System.out.printf("Balance After : Rs. %.2f%n", acc.balance);
    }

    public void printLoanDetails() {
        System.out.println("=== Loan Summary ===");
        System.out.printf("Principal  : Rs. %.2f%n", principal);
        System.out.printf("Tenure     : %d months%n", tenureMonths);
        System.out.printf("Monthly EMI: Rs. %.2f%n", monthlyEMI);
    }
}