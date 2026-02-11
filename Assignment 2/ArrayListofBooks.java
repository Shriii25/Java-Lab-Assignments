import java.util.ArrayList;

public class ArrayListofBooks {
    public static void main(String[] args){
        Book b1 = new Book();
        ArrayList<Book> alb = new ArrayList<Book>();
        alb.add(b1);
        Book b2 = new Book("1984", "George Orwell", "Secker & Warburg", "978-0-452-28423-4", 150.00, "Dystopian Fiction");
        alb.add(b2);
        Book b3 = new Book();
        b3.title = "Good Girl's Guide to Murder";
        b3.author = "Holly Jackson";
        b3.publisher = "Electric Monkey";
        b3.ISBN = "978-1-5298-8630-5";
        b3.price = 250.00;
        b3.genre = "Mystery";

        Book b4 = new Book(b3);
        b4.title = "The Odyssey";
        b4.author = "Homer";
        b4.publisher = "Penguin Classics";
        b4.genre="Epics";
        alb.add(b3);
        alb.add(b4);

        System.out.println("Book Details from the ArrayList: ");
        for(Book b: alb){
            System.out.println("--------------------------------");
            System.out.println("Title: "+b.title);
            System.out.println("Author: "+b.author);
            System.out.println("Publisher: "+b.publisher);
            System.out.println("ISBN: "+b.ISBN);
            System.out.println("Price: "+b.price);
            System.out.println("Genre: "+b.genre);
        }

        System.out.println("Is ArrayList empty? "+alb.isEmpty());
        System.out.println("Size of ArrayList: "+alb.size());
        ArrayList<Book> alb2 = new ArrayList<Book>();
        Book b5=new Book("The Illiad", "Homer", "Penguin Classics", "978-0-14-026886-7", 200.00, "Epics");
        alb2.add(b5);
        Book b6=new Book("Anna Karenina", "Leo Tolstoy", "Penguin Classics", "978-0-14-303500-8", 180.00, "Fiction");
        alb2.add(b6);
        alb.addAll(alb2);
        System.out.println("Books in the combined ArrayList: ");
        for(Book b: alb){
            System.out.println("--------------------------------");
            System.out.println("Title: "+b.title);
            System.out.println("Author: "+b.author);
            System.out.println("Publisher: "+b.publisher);
            System.out.println("ISBN: "+b.ISBN);
            System.out.println("Price: "+b.price);
            System.out.println("Genre: "+b.genre);
        System.out.println("Is ArrayList empty? "+alb.isEmpty());
        System.out.println("Size of ArrayList: "+alb.size());
        }
    }


    
}
