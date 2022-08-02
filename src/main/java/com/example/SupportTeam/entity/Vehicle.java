package com.example.SupportTeam.entity;

import com.example.SupportTeam.dto.VehicleDTO;

import javax.persistence.*;

@Entity
@Table
public class Vehicle extends VehicleDTO {
    @Id
    @SequenceGenerator(
            name = "vehicle_sequence",
            sequenceName = "vehicle_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "vehicle_sequence"
    )
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UsersDetails userId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UsersDetails getUserId() {
        return userId;
    }

    public void setUserId(UsersDetails userId) {
        this.userId = userId;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    private String vehicleNo;
    private String model;
}
