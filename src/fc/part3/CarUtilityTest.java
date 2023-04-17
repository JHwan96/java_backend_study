package fc.java.part3;

import fc.java.model.CarDTO;
import fc.java.model.CarUtility;

public class CarUtilityTest {
    public static void main(String[] args) {
        int carSn = 1111;
        String carName = "BMW828i";
        int carPrice=90000000;
        String carOwner="홍길동";
        int carYear=2015;
        String carType="G"; // 'G'->char

        // 데이터를 하나로 묶는다(이동)
        CarDTO car = new CarDTO();
        car.carSn=carSn;
        car.carName=carName;
        car.carOwner=carOwner;
        car.carYear=carYear;
        car.carType=carType;
        car.carPrice=carPrice;

        CarUtility carUtil = new CarUtility();
        carUtil.carPrint(car);
    }

    // 매개변수로 자동차의 정보를 입력받아서 출력하는 메소드를 정의

}
