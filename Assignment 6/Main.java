public class Main {

    public static void main(String[] args) {

        try {

            // ---------------- FULL TIME PAYROLL ----------------
            Payroll fullTimePayroll = new Payroll(
                    500000, 50000, 20000,
                    30000, 15000,
                    0, 0
            );

            // ---------------- CONTRACT PAYROLL ----------------
            Payroll contractPayroll = new Payroll(
                    0, 0, 0,
                    0, 0,
                    500, 120
            );

            // ---------------- INVALID PAYROLL (TEST CASE) ----------------
            Payroll invalidPayroll = new Payroll(
                    -1000, 0, 0,
                    0, 0,
                    -50, -10
            );

            // ---------------- EMPLOYEES ----------------
            Employee emp1 = new FullTimeEmployee(
                    "Amit", "ABCDE1234F", "01-01-2022",
                    "Engineer", 101, "IT"
            );

            Employee emp2 = new ContractEmployee(
                    "Riya", "XYZAB5678K", "01-06-2023",
                    "Consultant", 102, "HR"
            );

            Employee emp3 = new Manager(
                    "Raj", "LMNOP9876Q", "15-03-2021",
                    "Manager", 103, "Finance"
            );

            // ---------------- NORMAL EXECUTION ----------------
            System.out.println("\n=== NORMAL PAYROLL CALCULATION ===\n");

            processEmployee(emp1, fullTimePayroll);
            processEmployee(emp2, contractPayroll);
            processEmployee(emp3, fullTimePayroll);

            // ---------------- VARIATION 1: UNKNOWN DEPARTMENT ----------------
            System.out.println("\n=== VARIATION: UNKNOWN DEPARTMENT ===\n");

            Employee emp4 = new FullTimeEmployee(
                    "Neha", "AAAAA1111A", "10-10-2022",
                    "Analyst", 104, "Marketing"
            );

            processEmployee(emp4, fullTimePayroll);

            // ---------------- VARIATION 2: INVALID PAYROLL ----------------
            System.out.println("\n=== VARIATION: INVALID PAYROLL VALUES ===\n");

            processEmployee(emp2, invalidPayroll);

        } catch (Exception e) {
            System.out.println("[FATAL ERROR] " + e.getMessage());
        }
    }

    // ---------------- HELPER METHOD ----------------
    public static void processEmployee(Employee emp, Payroll p) {

        try {
            validatePayroll(p);

            emp.display();
            double ctc = emp.calcCTC(p);

            if (ctc < 0) {
                throw new Exception("CTC cannot be negative!");
            }

            System.out.println("CTC: " + ctc + "\n");

        } catch (Exception e) {
            System.out.println("[ERROR] Employee ID " + emp.empId + ": " + e.getMessage() + "\n");
        }
    }

    // ---------------- VALIDATION METHOD ----------------
    public static void validatePayroll(Payroll p) throws Exception {

        if (p.baseSalary < 0 || p.bonus < 0 || p.hourlyRate < 0 || p.noOfHours < 0) {
            throw new Exception("Invalid payroll values detected (negative input)");
        }
    }
}