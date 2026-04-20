class FullTimeEmployee extends Employee {

    FullTimeEmployee(String name, String panNo, String joiningDate,
                     String designation, int empId, String department) {

        super(name, panNo, joiningDate, designation, empId, department);
    }

    @Override
    double calcCTC(Payroll p) {

        if (department.equalsIgnoreCase("IT")) {
            return p.baseSalary + p.bonus + p.healthInsurance;

        } else if (department.equalsIgnoreCase("HR")) {
            return p.baseSalary + 20000 + p.healthInsurance;

        } else if (department.equalsIgnoreCase("Finance")) {
            return p.baseSalary + 40000;

        } else {
            return p.baseSalary;
        }
    }
}