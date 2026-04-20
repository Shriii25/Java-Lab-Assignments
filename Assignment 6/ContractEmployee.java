class ContractEmployee extends Employee {

    ContractEmployee(String name, String panNo, String joiningDate,
                     String designation, int empId, String department) {

        super(name, panNo, joiningDate, designation, empId, department);
    }

    @Override
    double calcCTC(Payroll p) {
        return p.noOfHours * p.hourlyRate;
    }
}