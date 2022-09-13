package org.oobootcamp.parkinglot;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ParkingBoy {
    List<ParkingLot> parkingLots;

    ParkingBoy(ParkingLot... lots) {
        parkingLots = List.of(lots);
    }

    public Optional<ParkingLot> findFirstLot() {
        return parkingLots.stream().filter(el -> el.parkingCars.size() < el.maxCapacity).findFirst();
    }

    public Ticket park(Car car) {
        if (findFirstLot().isEmpty()) return null;
        else {
            findFirstLot().get().parkingCars.add(car);
            return new Ticket(car);
        }
    }

    public Car unpark(Ticket ticket) {
        for (ParkingLot lot : parkingLots) {
            if (lot.parkingCars.contains(ticket.parkingCar)) {
                lot.parkingCars.remove(ticket.parkingCar);
                return ticket.parkingCar;
            }
        }
        return null;
    }
}

