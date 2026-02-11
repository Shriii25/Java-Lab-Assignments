public class practice {
    public static void main(String[] args) {
        // Fix: Declare 'num' inside main so it is not a non-static field
        int num = 1;

        do {
            // LOGIC: If divisible by 2 OR 3 OR 5, print ONCE.
            if (num % 2 == 0 || num % 3 == 0 || num % 5 == 0) {
                System.out.println(num);
            }
            
            num++;
        } while (num <= 50);
    }
}

