package fc.java.model2;

public class Book {
    private String title;
    private int price;
    private String company;
    private String author;

    // 생성자 메소드의 중복 정의 (overloading)
    public Book(String title, int price, String company, String author){
        this.title = title;
        this.price = price;
        this.company = company;
        this.author = author;
    }

    // getter
    public String getTitle() {
        return title;
    }

    public int getPrice() {
        return price;
    }

    public String getCompany() {
        return company;
    }

    public String getAuthor() {
        return author;
    }

    // setter
    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", price=" + price +
                ", company='" + company + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
