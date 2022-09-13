package org.oobootcamp.parkinglot;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    int maxCapacity;
    List<Car> parkingCars = new ArrayList();

    ParkingLot(int capacity) {
        maxCapacity = capacity;
    }

    public Ticket park(Car car) {
//        boolean isParking = parkingCars.contains(car);
        if (maxCapacity - parkingCars.size() > 0) {
            parkingCars.add(car);
            Ticket ticket = new Ticket(car);
            return ticket;
        }
        return null;
    }

    public Car unpark(Ticket ticket) {
        if (parkingCars.contains(ticket.parkingCar)) {
            parkingCars.remove(ticket.parkingCar);
            return ticket.parkingCar;
        }
        return null;
    }
}
