package org.example;

import java.util.ArrayList;
import java.util.List;

public class ShoeManager {
    List<Shoe> shoeList = new ArrayList<Shoe>();

    public ShoeManager() {
        shoeList.add(new Shoe("Nike", 100, "man"));
        shoeList.add(new Shoe("Adidas", 75, "woman"));
        shoeList.add(new Shoe("Puma", 66, "man"));
        shoeList.add(new Shoe("Lpilla shoe", 10, "woman"));
    }

    public List<Shoe> getAll() {
        return shoeList;
    }

    public List<Shoe> getManShoes() {
        List<Shoe> filteredShoes = new ArrayList<Shoe>();

        filteredShoes = shoeList.stream().filter(shoe -> shoe.getGenre().equals("man")).toList();
        return filteredShoes;
    }

    public List<Shoe> getWomanShoes() {
        List<Shoe> filteredShoes = new ArrayList<Shoe>();
        filteredShoes = shoeList.stream().filter(shoe -> shoe.getGenre().equals("woman")).toList();
        return filteredShoes;
    }

    public List<Shoe> sortedByName(){
        List<Shoe> filteredShoes = new ArrayList<Shoe>();
        filteredShoes = shoeList.stream().sorted((shoe1, shoe2) -> shoe1.getName().compareTo(shoe2.getName())).toList();
        return filteredShoes;
    }

    public List<Shoe> sortedByPrice(){
        List<Shoe> filteredShoes =this.shoeList;
        filteredShoes.sort((shoe1, shoe2) -> {
            if(shoe1.getPrice() > shoe2.getPrice()){
                return 1;
            }else{
                return -1;
            }
        });
        return filteredShoes;
    }

}
