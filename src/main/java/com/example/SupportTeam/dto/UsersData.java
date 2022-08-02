package com.example.SupportTeam.dto;

import com.example.SupportTeam.entity.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class UsersData {
    private String name;
    private String contact;
    private String address;
    List<Vehicle> vehicle;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Vehicle> getVehicle() {
        return vehicle;
    }

    public void setVehicle(List<Vehicle> vehicle) {
        this.vehicle = vehicle;
    }


}
