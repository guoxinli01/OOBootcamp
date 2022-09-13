package org.oobootcamp.parkinglot;

import java.util.List;
import java.util.Optional;

public class ParkingManager {
    List<ParkingBoy> managedBoy;

    public ParkingManager(ParkingBoy... boys) {
        managedBoy = List.of(boys);
    }

    public Optional<ParkingLot> findFirstLot() {
        for (ParkingBoy boy : managedBoy) {
            return boy.parkingLots.stream().filter(el -> el.parkingCars.size() < el.maxCapacity).findFirst();
        }
        return null;
    }

    public Ticket parkByBoy(ParkingBoy boy, Car car) {
        if (boy.findFirstLot().isEmpty()) return null;
        else {
            boy.findFirstLot().get().parkingCars.add(car);
            return new Ticket(car);
        }
    }

    public Ticket parkByManager(Car car) {
        if (findFirstLot().isEmpty()) return null;
        else {
            findFirstLot().get().parkingCars.add(car);
            return new Ticket(car);
        }
    }

    public Car unpark(Ticket ticket) {
        for (ParkingBoy boy : managedBoy) {
            for (ParkingLot lot : boy.parkingLots) {
                if (lot.parkingCars.contains(ticket.parkingCar)) {
                    lot.parkingCars.remove(ticket.parkingCar);
                    return ticket.parkingCar;
                }
            }
        }
        return null;
    }
}
