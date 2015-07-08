package ru.cj.db;

import ru.cj.db.dao.House;

import java.util.List;

/**
 * Created by df on 07.07.2015.
 */
public interface DbManagerI {

    public List<House> getAllHouses();

    public void deleteHouse(int id);

    public void insertHouse(String adress, int countFloors);

}
