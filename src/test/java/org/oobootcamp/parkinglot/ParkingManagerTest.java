package org.oobootcamp.parkinglot;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ParkingManagerTest {

    @Test
    void should_park_car_in_order_with_parking_manager_by_boy() {
        ParkingLot lot1 = new ParkingLot(5);
        ParkingLot lot2 = new ParkingLot(5);
        ParkingBoy boy = new ParkingBoy(lot1, lot2);
        ParkingManager manager = new ParkingManager(boy);

        Car car = new Car();

        Ticket ticket = manager.parkByBoy(boy, car);
        assertThat(ticket != null).isTrue();

    }

    @Test
    void should_park_car_in_order_with_parking_manager_by_manager() {
        ParkingLot lot1 = new ParkingLot(5);
        ParkingLot lot2 = new ParkingLot(5);
        ParkingBoy boy = new ParkingBoy(lot1, lot2);
        ParkingManager manager = new ParkingManager(boy);

        Car car = new Car();

        Ticket ticket = manager.parkByManager(car);
        assertThat(ticket != null).isTrue();

    }

    @Test
    void should_not_park_car_to_full_lot_with_parking_manager_by_manger() {
        ParkingLot lot1 = new ParkingLot(0);
        ParkingLot lot2 = new ParkingLot(0);
        ParkingBoy boy = new ParkingBoy(lot1, lot2);
        ParkingManager manager = new ParkingManager(boy);

        Car testCar = new Car();

        Ticket ticket = manager.parkByManager(testCar);
        assertThat(ticket == null).isTrue();
    }

    @Test
    void should_not_park_car_to_full_lot_with_parking_manager_by_boy() {
        ParkingLot lot1 = new ParkingLot(0);
        ParkingLot lot2 = new ParkingLot(0);
        ParkingBoy boy = new ParkingBoy(lot1, lot2);
        ParkingManager manager = new ParkingManager(boy);

        Car testCar = new Car();

        Ticket ticket = manager.parkByBoy(boy, testCar);
        assertThat(ticket == null).isTrue();
    }

    @Test
    void should_unpark_car_with_valid_ticket() {
        Car testCar = new Car();
        ParkingLot lot1 = new ParkingLot(5);
        ParkingLot lot2 = new ParkingLot(5);
        ParkingBoy boy = new ParkingBoy(lot1, lot2);
        ParkingManager manager = new ParkingManager(boy);

        Ticket ticket = manager.parkByManager(testCar);
        Car resCar = manager.unpark(ticket);

        assertThat(resCar).isEqualTo(testCar);
    }

    @Test
    void should_not_unpark_car_with_invalid_ticket() {
        Car testCar = new Car();
        ParkingLot lot1 = new ParkingLot(5);
        ParkingLot lot2 = new ParkingLot(5);
        ParkingBoy boy = new ParkingBoy(lot1, lot2);
        ParkingManager manager = new ParkingManager(boy);

        manager.parkByManager(testCar);
        Ticket ticket = new Ticket(new Car());
        Car resCar = manager.unpark(ticket);

        assertThat(resCar).isNull();
    }
}
