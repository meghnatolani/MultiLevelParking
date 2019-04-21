package model;

import java.util.HashMap;

/**@author Meghna Tolani
 * ParkingLot : Represents one parking lot
 * */

public class ParkingLot {

    private Integer id;

    ParkingSpace[][] parkingSpaces;

    HashMap<String,Integer> hashMap;

    /*
     * Creates the pattern for mapping row-column number to Parking space number
     * */
    public ParkingLot(Integer id){

        this.setId(id);

        setParkingSpaces(new ParkingSpace[4][5]);

        initializeParkingSpace();

        setHashMap(new HashMap<>(20));

        initializeMap();

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ParkingSpace[][] getParkingSpaces() {
        return parkingSpaces;
    }

    public HashMap<String, Integer> getHashMap() {
        return hashMap;
    }

    public void setHashMap( HashMap<String, Integer> hashMap ) {
        this.hashMap = hashMap;
    }

    public void setParkingSpaces(ParkingSpace[][] parkingSpaces) {

        this.parkingSpaces = parkingSpaces;
    }

    public void initializeParkingSpace(){

        int tempSlots=5;

        for(int i=0;i<parkingSpaces.length;i++){

            if(i==3 || i==2) tempSlots=2;

            for(int j=0;j<parkingSpaces[0].length;j++){

                parkingSpaces[i][j]=new ParkingSpace(tempSlots);
            }
        }
    }

    public void initializeMap(){

        Integer value=1;

        boolean alternate=false;

        for(int i=0;i<5;i++){

            if(alternate){

                for(int j=4;j>=0;j--){

                    getHashMap().put(String.valueOf(i)+""+j,value++);
                }

            }else {

                for(int j=0;j<5;j++){

                    getHashMap().put(String.valueOf(i)+""+j,value++);
                }
            }
            alternate=!alternate;
        }
    }

}
