package fc.java.part2;

public class BookExam {
    public static void main(String[] args) {
        // 한 권의 책 데이터를 저장하기 위해서 객체를 생성하시오 (인스턴스를 만드시오)
        Book b = new Book();
        b.author = "박모씨";
        b.title = "자바";
        b.price = 30000;
        b.company = "패스트캠퍼스";
        b.page = 700;
        b.isbn = "1199110";

        b.printAll();
    }
}
