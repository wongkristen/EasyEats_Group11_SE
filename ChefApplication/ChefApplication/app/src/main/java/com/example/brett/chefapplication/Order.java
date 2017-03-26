package com.example.brett.chefapplication;

/**
 * Created by Brett on 3/25/2017.
 */

public class Order {

    private int id;
    private String name;
    private int spare = 0;
    public Order(int id, String name, int spare){
        this.name = name;
        this.id = id;
        this.spare = 0;
    }
    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return this.id;
    }
    public void setSpare(int spare){
        this.spare = 0;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
}
