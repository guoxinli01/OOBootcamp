package org.oobootcamp.parkinglot;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ParkingLotTest {
    @Test
    void should_put_car_if_capacity_not_0() {
        Car testCar = new Car();
        ParkingLot parkingLot = new ParkingLot(5);
        assertThat(parkingLot.put(testCar).equals("Your car has been parked!"));
    }
}
