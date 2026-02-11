import java.util.Scanner;

public class ArithmeticOperations{
    public int num1, num2;
    public int addNums(int n1, int n2){
        return n1 + n2;
    } 
    public int subNums(int n1, int n2){
        return n1 - n2;
    }
    public long mulNums(int n1, int n2){
        return n1 * n2;
    }
    public float divNums(int n1, int n2){
        return n1 / n2;}
    
    public int calcMod(int n1, int n2){
        return n1 % n2;
    }

    public static void main(String[] args){
        ArithmeticOperations op= new ArithmeticOperations();

        Scanner scan=new Scanner(System.in);
        System.out.println("Enter first number:");
        op.num1=scan.nextInt();
        System.out.println("Enter second number:");
        op.num2=scan.nextInt();

        int sum=op.addNums(op.num1, op.num2);
        int diff=op.subNums(op.num1, op.num2);
        long prod=op.mulNums(op.num1, op.num2);
        float quot=op.divNums(op.num1, op.num2);
        int mod=op.calcMod(op.num1, op.num2);
        System.out.println("Sum: " + sum +" " + "Difference: " + diff+" " + "Product: " + prod+" " + "Quotient: " + quot+" " + "Modulus: " + mod);
        scan.close();
    }

}
    