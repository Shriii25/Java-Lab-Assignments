//import java.util.ArrayList;

public class Book {
    public String title;
    public String author;
    public String publisher;
    public String ISBN;
    public double price;
    public String genre;

    //Default Constructor
    public Book()
    {
        title="to Kill a Mockingbird";
        author="Harper Lee";
        publisher="J.B. Lippincott & Co.";
        ISBN="978-0-06-112008-4";
        price=200.00;
        genre="Fiction";
    }
    //Parameterized Constructor
    public Book(String t, String a, String p, String i, double prc, String g)
    {
        title=t;
        author=a;
        publisher=p;
        ISBN=i;
        price=prc;
        genre=g;
    }
    //Copy Constructor
    public Book(Book otherBook) {
        this.title = otherBook.title;
        this.author = otherBook.author;
        this.publisher = otherBook.publisher;
        this.ISBN = otherBook.ISBN;
        this.price = otherBook.price;
        this.genre = otherBook.genre;
    }
}
