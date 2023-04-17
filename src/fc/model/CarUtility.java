package fc.java.model;

import fc.java.model.CarDTO;

public class CarUtility {
    public void carPrint(CarDTO car){
        System.out.println(car.carSn+"\t"+car.carName+"\t"+car.carPrice+"\t"+car.carOwner+"\t"+car.carYear+"\t"+car.carType);
    }

}
