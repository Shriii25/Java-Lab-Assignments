import java.util.ArrayList;

public class MainForBook {
    public static void main(String[] args) {
        ArrayList<Book> alb = new ArrayList<Book>();

        Book b1 = new Book("Icon", "Unknown", "NA", "NA", 499, "Fiction");
        alb.add(b1);

        Book b2 = new Book();
        alb.add(b2);

        Book b3 = new Book(b2);
        b3.title = "Harry Potter";
        b3.author = "JK Rowling";
        alb.add(b3);

        Book b4 = new Book("Hunger Games", "Suzanne Collins", "NA", "ABDK223", 370, "Fiction");
        alb.add(b4);

        Book b5 = new Book("Atomic Habits", "James Clear", "NA", "ABCD3101", 549, "Self-Help");
        alb.add(b5);

        Book b6 = new Book("Seven Years in Tibet", "Heinrich Harrer", "NA", "NA67ZI", 999, "Auto-biography");
        alb.add(b6);

        int len = 0;
        for (Book b : alb) {
            if (b.genre.equals("Fiction")) {
                System.out.println("------------------");
                System.out.println(b.title);
                System.out.println(b.price);
                System.out.println(b.author);
                System.out.println(b.ISBN);
                System.out.println(b.genre);
                System.out.println("------------------");
                len += 1;
            }
        }
        System.out.println("Fiction Books: " + len);

        len = 0;
        double temp = 0;
        for (Book b : alb) {
            len += 1;
            temp += b.price;
        }
        System.out.println("Average price: " + temp / len);
    }
}