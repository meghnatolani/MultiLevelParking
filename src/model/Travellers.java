package model;

/**@author Meghna Tolani
 * Travellers : Travellers in a vehicle. Age parameter takes the age of the oldest person, and royal parameter represents if VIP or not.
 * */

public class Travellers {

    private Integer age;

    private boolean isRoyal;

    public Travellers( String isRoyal, Integer age){
        this.setAge(age);
        this.setRoyal(isRoyal);
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public boolean isRoyal() {
        return isRoyal;
    }

    public void setRoyal(String royal) {
        isRoyal = royal.equals("VIP") ? true : false;
    }
}
