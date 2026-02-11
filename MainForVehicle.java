public class MainForVehicle {
    public static void main(String[] args) {
        Vehicle v1 = new Vehicle();
        displayDetails(v1);
        v1.setMfgCode("MFG2024001");
        v1.seatingCapacity = 4;

        // FIXED: Swapped "Red" and 250000.00 to match the Vehicle constructor
        Vehicle v2 = new Vehicle("Honda", "Civic", "Red", 250000.00);
        displayDetails(v2);

        Vehicle v3 = new Vehicle('D', 180000.00, "MFG12345");
        displayDetails(v3);

        v1.started();
        v1.Drive();
        float m1 = v1.CalcMileage(v1.fuelType,150, 30);
        System.out.println("Mileage of Vehicle 1: " + m1 + " km/l");
        v1.stopped();

        v2.started();
        v2.Drive();
        float m2 = v2.CalcMileage(v2.fuelType, 200, 25);
        System.out.println("Mileage of Vehicle 2: " + m2 + " km/l");
        v2.stopped();

        Vehicle[] fleet = new Vehicle[]{v1, v2, v3};
        for (Vehicle v : fleet) {
            displayDetails(v);
            v.started();
            v.Drive();
            v.accelerate(20, 60, 10);
            float mileage = v.CalcMileage(v.fuelType, 300, 40); // Changed variable name to avoid conflict with m1
            System.out.println("Mileage: " + mileage + " km/l");
            v.stopped();
        }
    }
    public static void displayDetails(Vehicle newV) {
        System.out.println("┌────────────────────────────────┐");
        System.out.println("│      VEHICLE DETAILS           │");
        System.out.println("├────────────────────────────────┤");
        System.out.printf("│ %-27s │ %s │%n", "Brand Name", newV.brandName);
        System.out.printf("│ %-27s │ %s │%n", "Model", newV.model);
        System.out.printf("│ %-27s │ %s │%n", "Year", newV.year);
        System.out.printf("│ %-27s │ %s │%n", "Color", newV.color);
        System.out.printf("│ %-27s │ %s │%n", "Fuel Type", newV.fuelType);
        System.out.printf("│ %-27s │ %.2f │%n", "Price", newV.price);
        System.out.printf("│ %-27s │ %d │%n", "Seating Capacity", newV.seatingCapacity);
        System.out.printf("│ %-27s │ %s │%n", "Mfg Code", newV.getMfgCode());
        System.out.printf("│ %-27s │ %d │%n", "No. of Services", newV.getNoOfServices());
        System.out.println("└────────────────────────────────┘");
    }
}