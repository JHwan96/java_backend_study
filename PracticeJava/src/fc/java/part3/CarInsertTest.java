package fc.java.part3;

import fc.java.model.CarDAO;
import fc.java.model.CarDTO;

import java.util.Scanner;

public class CarInsertTest {
    public static void main(String[] args) {
        // Q. 자동차 정보를 키보드로부터 입력을 받아서 DB에 저장
        Scanner scan = new Scanner(System.in);

        System.out.print("자동차일련번호:");
        int carSn=scan.nextInt();

        scan.nextLine();

        System.out.print("자동차이름:");
        String carName=scan.nextLine();

        System.out.print("자동차가격:");
        int carPrice=scan.nextInt();

        scan.nextLine();

        System.out.print("자동차소유자:");
        String carOwner=scan.nextLine();

        System.out.print("자동차년식:");
        int carYear=scan.nextInt();

        scan.nextLine();

        System.out.print("자동차일련번호");
        String carType=scan.nextLine();

        // Q. 매개변수로 자동차의 정보를 받아서 출력하는 메서드를 정의하세요
        CarDTO car = new CarDTO();
        car.carSn=carSn;
        car.carName=carName;
        car.carPrice=carPrice;
        car.carOwner=carOwner;
        car.carYear=carYear;
        car.carType=carType;

        CarDAO dao = new CarDAO();
        dao.carInsert(car);
        dao.carSelect(car);
    }
}
