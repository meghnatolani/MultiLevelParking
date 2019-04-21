package model;

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
