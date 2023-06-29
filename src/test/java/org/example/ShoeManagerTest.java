package org.example;

import com.google.gson.Gson;
import junit.framework.TestCase;

import java.util.List;

public class ShoeManagerTest extends TestCase {

    public void testGetAll() {
        ShoeManager shoeManager = new ShoeManager();
        List<Shoe> shoeList = shoeManager.getAll();
        assertEquals(4, shoeList.size());
    }

    public void testGetManShoes() {
        ShoeManager shoeManager = new ShoeManager();
        List<Shoe> shoeList = shoeManager.getManShoes();
        Gson gson = new Gson();
        String s = gson.toJson(shoeList);
        System.out.println(s);
    }

    public void testGetWomanShoes() {
        ShoeManager shoeManager = new ShoeManager();
        List<Shoe> shoeList = shoeManager.getWomanShoes();
        Gson gson = new Gson();
        String s = gson.toJson(shoeList);
        System.out.println(s);
    }

    public void testSortedByName() {
        ShoeManager shoeManager = new ShoeManager();
        List<Shoe> shoeList = shoeManager.sortedByName();
        Gson gson = new Gson();
        String s = gson.toJson(shoeList);
        System.out.println(s);
    }

    public void testSortedByPrice() {
        ShoeManager shoeManager = new ShoeManager();
        List<Shoe> shoeList = shoeManager.sortedByPrice();
        Gson gson = new Gson();
        String s = gson.toJson(shoeList);
        System.out.println(s);
    }
}