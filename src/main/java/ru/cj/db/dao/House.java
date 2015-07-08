package ru.cj.db.dao;

/**
 * Created by df on 07.07.2015.
 */
public class House {

    private int id;
    private String address;
    private int countFloors;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCountFloors() {
        return countFloors;
    }

    public void setCountFloors(int countFloors) {
        this.countFloors = countFloors;
    }

}
