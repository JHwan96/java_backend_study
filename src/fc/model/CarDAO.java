package fc.java.model;

import fc.java.model.CarDTO;

public class CarDAO {
    // C,R,U,D
    public void carInsert(CarDTO car){
        // DB 연결, insert SQL
        System.out.println("car 정보가 DB에 저장되었습니다.");
    }

    public void carSelect(CarDTO car){
        // DB 연결, select SQL
        System.out.println("car 정보가 출력되었습니다.");
    }
}
