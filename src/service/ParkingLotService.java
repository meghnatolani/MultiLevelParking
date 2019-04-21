package service;

import model.ParkingLot;
import model.ParkingSpace;
import model.Vehicle;

public interface ParkingLotService {

    Integer addParkingSpace( ParkingLot parkingLot, Vehicle vehicle);

    void fillSlotsAround(String parkingSlotNumber, ParkingSpace[][] parkingSpaces);
}
