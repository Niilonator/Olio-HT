package com.example.olioht;

public class CoTwo {
    private String restaurantE;
    private Double result;

    public CoTwo(String spending){
        restaurantE = spending;
    }
    // uses the jsonhelper to get stuff from an API and returns it ;
    public void queryCoTwo() {
        jsonhelper jhelp = new jsonhelper();
        jhelp.getJSON(restaurantE);
        jhelp.readJSON();
        result = jhelp.getRestaurant();

    }
    public Double getResult(){
        return result;
    }
}
