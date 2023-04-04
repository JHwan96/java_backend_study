package fc.java.part2;

public class Book {
    String title;
    int price;
    String company;
    String author;
    int page;
    String isbn;

    public void printAll(){
        System.out.println("title : "+title);
        System.out.println("price : "+price);
        System.out.println("company : "+company);
        System.out.println("page : "+page);
        System.out.println("isbn : "+isbn);
        System.out.println("author : "+author);
    }
}
