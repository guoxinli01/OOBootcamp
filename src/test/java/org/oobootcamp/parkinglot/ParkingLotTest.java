package org.oobootcamp.parkinglot;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ParkingLotTest {
    @Test
    void should_park_car_when_capacity_not_0() {
        Car testCar = new Car();
        ParkingLot parkingLot = new ParkingLot(5);
//        assertThat(parkingLot.put(testCar).equals("Your car has been parked!"));
        Ticket ticket = parkingLot.park(testCar);
        assertThat(ticket != null).isTrue();
    }

    @Test
    void should_not_park_car_when_capacity_is_0() {
        Car testCar = new Car();
        ParkingLot parkingLot = new ParkingLot(0);
        assertThat(parkingLot.park(testCar)).isEqualTo("parking failed");
    }

    @Test
    void should_get_car_with_valid_ticket() {
        Car testCar = new Car();
        ParkingLot parkingLot = new ParkingLot(5);
        Ticket ticket = parkingLot.park(testCar);
        Car resCar = parkingLot.unpark(ticket);
        assertThat(resCar).isEqualTo(testCar);
    }

    @Test
    void should_not_get_car_with_invalid_ticket() {
        Car testCar = new Car();
        ParkingLot parkingLot = new ParkingLot(5);
        Ticket ticket = new Ticket(new Car());
        Car resCar = parkingLot.unpark(ticket);
        assertThat(resCar).isNull();
    }
}
