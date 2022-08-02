package com.example.SupportTeam.entity;

import com.example.SupportTeam.enums.DataTypeEnum;

import javax.persistence.*;


@Entity
@Table(name = "executive_availability")
public class ExecutiveAvailability {
    @Id
    @SequenceGenerator(
            name = "availability_sequence",
            sequenceName = "availability_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "availability_sequence"
    )
    private  Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private  UsersDetails userId;
    private DataTypeEnum.OpAvailabilityType opAvailabilityType;

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

    public DataTypeEnum.OpAvailabilityType getOpAvailabilityType() {
        return opAvailabilityType;
    }

    public void setOpAvailabilityType(DataTypeEnum.OpAvailabilityType opAvailabilityType) {
        this.opAvailabilityType = opAvailabilityType;
    }
}
