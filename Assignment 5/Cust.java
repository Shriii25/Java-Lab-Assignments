public class Cust {

    public String custID;
    public String firstName;
    public String lastName;
    public String email;
    public String contactNumber;
    public String address;
    protected String aadharNumber;
    protected String panNumber;

    public Cust(String custID, String firstName, String lastName,
                      String email, String contactNumber, String address,
                      String aadharNumber, String panNumber) {

        this.custID = custID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.contactNumber = contactNumber;
        this.address = address;
        this.aadharNumber = aadharNumber;
        this.panNumber = panNumber;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public void printDetails() {
        System.out.println("=== Customer Details ===");
        System.out.println("ID       : " + custID);
        System.out.println("Name     : " + getFullName());
        System.out.println("Email    : " + email);
        System.out.println("Contact  : " + contactNumber);
        System.out.println("Address  : " + address);
        System.out.println("Aadhar   : " + aadharNumber);
        System.out.println("PAN      : " + panNumber);
    }

    @Override
    public String toString() {
        return "Customer[" + custID + " | " + getFullName() + "]";
    }
}