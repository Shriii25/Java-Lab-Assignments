public class Vehicle {
    public String brandName;
    public String model;
    public java.time.Year year;
    public String color;
    public char fuelType; //E=Electric, D=Diesel, P=Petrol, C=CNG
    public double price;
    private String MfgCode;
    private int NoOfServices;
    public int seatingCapacity; 
    public void setNoOfServices(int nos){
        NoOfServices=nos;
    }
    public int getNoOfServices(){
        return NoOfServices;
    }
    public void setMfgCode(String mcode){
        MfgCode=mcode;
    }
    public String getMfgCode(){
        return MfgCode;
    }

    public Vehicle(String bName, String mdl, String clr, double prc){
        brandName=bName;
        model=mdl;
        color=clr;
        price=prc;
    }

    public Vehicle(char fType, double prc, String mcode){
       fuelType=fType;
       price=prc;
       MfgCode=mcode;
    }
    public void started(){
        System.out.println("Start the vehicle using the key");
        System.out.println("Vehicle Started");
    }

    public void stopped(){
        System.out.println("Stop the vehicle using the key");
        System.out.println("Vehicle Stopped");
    }

    public void Drive(){
        System.out.println("Use the steering wheel to drive the vehicle");
        System.out.println("Drive Carefully");
    }

    public int accelerate(int initSpeed, int finalSpeed, int time){
        int acceleration=(finalSpeed - initSpeed)/time;
        return acceleration;
    }

    public float CalcMileage(char fuelType, float distance, float fuelConsumed){
        if(fuelType=='E'){
            System.out.println("Electric vehicles do not consume fuel.");
            return 0;
        }else if(fuelType=='D'){
            float mileage=(distance/fuelConsumed)*1.1f; //Diesel vehicles have 10% more efficiency
            return mileage;
        }else if(fuelType=='C'){
            float mileage=(distance/fuelConsumed)*1.2f; //CNG vehicles have 20% more efficiency
            return mileage;
        }else{
            float mileage=distance/fuelConsumed;
            return mileage;
        }
    }

    public void display_deets(Vehicle newV){
        System.out.println("--------------------------------");
        System.out.println("Vehicle Details:");
        System.out.println("Brand Name: "+newV.brandName);
        System.out.println("Model: "+newV.model);
        System.out.println("Year of Manufacture: "+newV.year);
        System.out.println("Color: "+newV.color);
        System.out.println("Fuel Type: "+newV.fuelType);
        System.out.println("Price: "+newV.price);
        System.out.println("Seating Capacity: "+newV.seatingCapacity);
        System.out.println("Number of Services: "+newV.getNoOfServices());
        System.out.println("--------------------------------");
    }
    /*public static void main(String[] args) {
        Vehicle v = new Vehicle();
        v.brandName="Lamborghini";
        v.model="Aventador";
        v.color="Yellow";
        v.year=java.time.Year.of(2020);
        v.fuelType='P';
        v.seatingCapacity=2;
        v.price=15000000.00;
        v.display_deets(v);
        v.started();
        v.Drive();
        int acc=v.accelerate(0,100,10);
        System.out.println("Acceleration is: "+acc+" m/s^2");
        float mileage=v.CalcMileage(v.fuelType, 500,25);
        System.out.println("Mileage is: "+mileage+" km/l");
        v.stopped();
       
    }*/

    public Vehicle(){
        brandName="Toyota";
        model="Camry";
        year=java.time.Year.of(2020);
        color="Blue";
        fuelType='P';
        seatingCapacity=5;
        price=24000000.75;
    }
}