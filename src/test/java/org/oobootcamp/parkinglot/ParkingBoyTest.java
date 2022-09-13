package org.oobootcamp.parkinglot;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ParkingBoyTest {

    @Test
    void should_park_car_in_order_with_multiple_parking_lot() {
        ParkingLot lot1 = new ParkingLot(5);
        ParkingLot lot2 = new ParkingLot(5);
        Car testCar = new Car();

        ParkingBoy group = new ParkingBoy(lot1, lot2);
        Ticket ticket = group.park(testCar);
        assertThat(ticket != null).isTrue();
    }

    @Test
    void should_not_park_car_in_order_with_multiple_full_parking_lot() {
        ParkingLot lot1 = new ParkingLot(0);
        ParkingLot lot2 = new ParkingLot(0);
        Car testCar = new Car();

        ParkingBoy group = new ParkingBoy(lot1, lot2);
        Ticket ticket = group.park(testCar);
        assertThat(ticket == null).isTrue();
    }

    @Test
    void should_unpark_car_with_valid_ticket() {
        Car testCar = new Car();
        ParkingLot lot1 = new ParkingLot(5);
        ParkingLot lot2 = new ParkingLot(5);
        ParkingBoy group = new ParkingBoy(lot1, lot2);

        Ticket ticket = group.park(testCar);
        Car resCar = group.unpark(ticket);
        assertThat(resCar).isEqualTo(testCar);
    }

    @Test
    void should_not_unpark_car_with_invalid_ticket() {
        Car testCar = new Car();
        ParkingLot lot1 = new ParkingLot(5);
        ParkingLot lot2 = new ParkingLot(5);
        ParkingBoy group = new ParkingBoy(lot1, lot2);

        Ticket ticket = new Ticket(new Car());
        Car resCar = group.unpark(ticket);
        assertThat(resCar).isNull();
    }
}
