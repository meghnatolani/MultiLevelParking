package service;

import model.*;

import java.util.LinkedHashMap;
import java.util.Stack;

public class MultiLevelParkingServiceImpl implements MultiLevelParkingService {

    MultiLevelLot multiLevelLot;

    ParkingLotService parkingLotService = new ParkingSpaceServiceImpl();

    public void processParking(String line, int levels){

        multiLevelLot= MultiLevelLot.getInstance(levels);

        String[] array = line.split(" ");

        if(array[0].equals("IN"))
            insertVehicle(array[1],array[2],array[3],Integer.parseInt(array[4]));
        else
            removeCar(array[1],array[2]);

    }

    public void insertVehicle(String vehicleType, String vehicleNo, String royal, Integer age){

        LinkedHashMap<ParkingLot,Integer[]> parkingLots=multiLevelLot.getParkingLots();

        Vehicle vehicle = checkVehicleType(vehicleType, vehicleNo, royal, age);

        Integer toCheck=0;

        if(vehicle instanceof Bike) toCheck= 1;

        for (ParkingLot key : parkingLots.keySet()) {

            Integer space= parkingLots.get(key)[toCheck];

            if(space>0) {

                Integer parkingSpace=parkingLotService.addParkingSpace(key ,vehicle);

                System.out.println("ENTRY : "+vehicleType+" "+vehicleNo+" Parking Lot : "+key.getId()+" Parking Space : "+parkingSpace);

                Integer[] arr=parkingLots.get(key);

                arr[toCheck]--;

                parkingLots.put(key,arr);

                break;
            }
        }

    }


    public void removeCar(String vehicleType, String vehicleNo){

        LinkedHashMap<ParkingLot,Integer[]> parkingLots=multiLevelLot.getParkingLots();

        Integer toCheck=0; Stack<Vehicle> stack=new Stack<>();

        boolean found=false;

        if(vehicleType.equals("BIKE")) toCheck= 1;

        outerloop : for (ParkingLot key : parkingLots.keySet()) {
            if(parkingLots.get(key)[toCheck]>0){

                 for(int i=0; i<key.getParkingSpaces().length; i++){

                    for(int j=0;j<key.getParkingSpaces()[0].length;j++){

                        while(!key.getParkingSpaces()[i][j].getVehicles().isEmpty() && !found){

                            Vehicle veh = key.getParkingSpaces()[i][j].getVehicles().pop();

                            if(veh.getVehicleNumber()!=null && veh.getVehicleNumber().equals(vehicleNo) && veh.getVehicleType().equals(vehicleType)){

                                System.out.println("EXIT : "+vehicleType+" "+vehicleNo+" Parking Lot : "+key.getId()+" Parking Space : "+key.getHashMap().get(i+""+j));

                                Integer[] arr=parkingLots.get(key);

                                arr[toCheck]++;

                                parkingLots.put(key,arr);

                                found=true;

                            } else {
                                stack.push(veh);
                            }
                        }

                        while(!stack.isEmpty()){
                            Vehicle veh = stack.pop();
                            if(veh.getVehicleNumber()!=null)
                                key.getParkingSpaces()[i][j].getVehicles().push(veh);
                        }

                    }

                }
            }
        }

        if(!found)
            System.out.println(vehicleType+" "+vehicleNo+" not present in the Parking Lot");

    }


    public Vehicle checkVehicleType(String vehicleType, String vehicleNo,String royal, Integer age){

        Vehicle vehicle;

        Travellers travellers = new Travellers(royal, age);

        if(vehicleType.equals("CAR")) {

            vehicle = new Car(travellers, vehicleNo);
        }else{

            vehicle=new Bike(travellers,vehicleNo);
        }

        return vehicle;
    }

}
