package org.oobootcamp.parkinglot;

import java.util.Arrays;

public class ParkingLot {
    int maxCapacity;
    String[] parkingCars = {};

    ParkingLot(int capacity) {
        maxCapacity = capacity;
    }

    public String put(Car car) {
        boolean isParking = Arrays.asList(parkingCars).contains(car.id);
        if (maxCapacity > 0 && !isParking) {
            return "Your car has been parked!";
        }
        return "The car has already been parked";
    }
}
