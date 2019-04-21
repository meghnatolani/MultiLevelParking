package service;

public interface MultiLevelParkingService {

    void processParking(String line, int levels);

    void insertVehicle(String vehicleType, String vehicleNo, String royal, Integer age);

    void removeCar(String vehicleType, String vehicleNo);
}
