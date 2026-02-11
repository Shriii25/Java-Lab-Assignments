import java.util.Scanner;

public class Calculator {
    public int num1, num2, op;

    public int addNums(int n1, int n2) {
        return n1 + n2;
    }

    public int subNums(int n1, int n2) {
        return n1 - n2;
    }

    public long mulNums(int n1, int n2) {
        return (long) n1 * n2;
    }

    public float divNums(int n1, int n2) {
        if (n2 == 0) return 0;
        return (float) n1 / n2;
    }

    public int calcMod(int n1, int n2) {
        return n1 % n2;
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        float result = 0;
        Scanner scan = new Scanner(System.in);

        System.out.println("Welcome to the Calculator Program!");

        do { 
            System.out.println("0. Exit 1. Addition 2. Subtraction 3. Multiplication 4. Division 5. Modulus");
            System.out.print("Select an operation (0-5): ");
            calc.op = scan.nextInt();

            if (calc.op == 0) {
                System.out.println("Exiting program...");
                break;}
            if (calc.op < 1 || calc.op > 5) {
                System.out.println("Invalid operation selected. Please try again.");
                continue; 
            }
            
            System.out.print("Enter first number: ");
            calc.num1 = scan.nextInt();
            System.out.print("Enter second number: ");
            calc.num2 = scan.nextInt();

            switch (calc.op) {
                case 1:
                    result = calc.addNums(calc.num1, calc.num2);
                    break;
                case 2:
                    result = calc.subNums(calc.num1, calc.num2);
                    break;
                case 3:
                    result = calc.mulNums(calc.num1, calc.num2);
                    break;
                case 4:
                    result = calc.divNums(calc.num1, calc.num2);
                    break;
                case 5:
                    result = calc.calcMod(calc.num1, calc.num2);
                    break;
                default:
                    System.out.println("Invalid operation selected.");
                    continue;
            }

            System.out.println("Result: " + result);
            }while (calc.op != 0);

        scan.close();
    }
}