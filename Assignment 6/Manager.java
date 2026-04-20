class Manager extends FullTimeEmployee {

    Manager(String name, String panNo, String joiningDate,
            String designation, int empId, String department) {

        super(name, panNo, joiningDate, designation, empId, department);
    }

    @Override
    double calcCTC(Payroll p) {

        double deptBonus = 0;

        if (department.equalsIgnoreCase("IT")) {
            deptBonus = 50000;
        } else if (department.equalsIgnoreCase("Finance")) {
            deptBonus = 60000;
        }

        return p.baseSalary + p.bonus +
               p.travelAllowance + p.educationAllowance +
               deptBonus;
    }
}