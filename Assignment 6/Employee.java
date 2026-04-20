abstract class Employee {
    String name;
    String panNo;
    String joiningDate;
    String designation;
    int empId;
    String department;

    Employee(String name, String panNo, String joiningDate,
             String designation, int empId, String department) {

        this.name = name;
        this.panNo = panNo;
        this.joiningDate = joiningDate;
        this.designation = designation;
        this.empId = empId;
        this.department = department;
    }

    // Abstract method
    abstract double calcCTC(Payroll p);

    void display() {
        System.out.println("ID: " + empId + ", Name: " + name + ", Dept: " + department);
    }
}