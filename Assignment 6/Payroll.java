class Payroll {
    double baseSalary;
    double bonus;
    double healthInsurance;
    double travelAllowance;
    double educationAllowance;
    double hourlyRate;
    int noOfHours;

    Payroll(double baseSalary, double bonus, double healthInsurance,
            double travelAllowance, double educationAllowance,
            double hourlyRate, int noOfHours) {

        this.baseSalary = baseSalary;
        this.bonus = bonus;
        this.healthInsurance = healthInsurance;
        this.travelAllowance = travelAllowance;
        this.educationAllowance = educationAllowance;
        this.hourlyRate = hourlyRate;
        this.noOfHours = noOfHours;
    }
}