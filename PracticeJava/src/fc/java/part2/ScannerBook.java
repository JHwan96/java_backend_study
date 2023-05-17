package fc.java.part2;

import java.util.Scanner;

public class ScannerBook {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("제목 : ");
        String name = scan.nextLine();

        System.out.print("가격 : ");
        int price = scan.nextInt();
        scan.nextLine();

        System.out.print("출판사 : ");
        String publish = scan.nextLine();

        System.out.print("저자 : ");
        String author = scan.nextLine();

        System.out.print("페이지수 : ");
        int page = scan.nextInt();
        scan.nextLine();

        System.out.print("ISBN : ");
        String isbn = scan.nextLine();

        scan.close();
        System.out.print(name + " " + price +" "
                    + publish + " " + author + " " + page + " " + isbn);
    }
}
