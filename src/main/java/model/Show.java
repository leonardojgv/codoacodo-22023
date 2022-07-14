/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author divit
 */
public class Show {

    private int id;
    private String band;
    private int capacity;
    private double price;
    private String direction;
    private String observation;
    private Date eventDate;

    public Show(int id, String band, int capacity, double price, String direction, String observation, String eventDate) {
        this.id = id;
        this.band = band;
        this.capacity = capacity;
        this.price = price;
        this.direction = direction;
        this.observation = observation;
        this.eventDate = java.sql.Date.valueOf(eventDate);
    }

    public Show(String band, int capacity, double price, String direction, String observation, String eventDate) {
        this.band = band;
        this.capacity = capacity;
        this.price = price;
        this.direction = direction;
        this.observation = observation;
        this.eventDate = java.sql.Date.valueOf(eventDate);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBand() {
        return band;
    }

    public void setBand(String band) {
        this.band = band;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = java.sql.Date.valueOf(eventDate);
    }

    @Override
    public String toString() {

        List<String> atributesList = new ArrayList();

        atributesList.add("Entrada N°" + id);
        atributesList.add("Band: " + band);
        atributesList.add("capacity: " + capacity);
        atributesList.add("Price: " + price);
        atributesList.add("Dirección: " + direction);
        atributesList.add("Observation: " + observation);
        atributesList.add("EventDate: " + eventDate);

        return String.join(" | ", atributesList);
    }

}
