package org.oobootcamp.parkinglot;

import java.util.Date;

public class Ticket {
    String id;
    Car parkingCar;

    public Ticket(Car car) {
        id = new Date() + car.id;
        parkingCar = car;
    }
}
