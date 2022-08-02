package com.example.SupportTeam.entity;

import com.example.SupportTeam.enums.DataTypeEnum;

import javax.persistence.*;

@Entity
@Table

public class UsersDetails {
    @Id
    @SequenceGenerator(
            name = "user_details_sequence",
            sequenceName = "user_details_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_details_sequence"
    )
    private Long id;
    private String name;
    @Column(unique = true)
    private String contact;
    private String address;
    private DataTypeEnum.UserType userType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public DataTypeEnum.UserType getUserType() {
        return userType;
    }

    public void setUserType(DataTypeEnum.UserType userType) {
        this.userType = userType;
    }

}
