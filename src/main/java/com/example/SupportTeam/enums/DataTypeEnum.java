package com.example.SupportTeam.enums;

public class DataTypeEnum {

    public enum UserType {
        ADMIN, EXECUTIVE, OPERATOR;
    }

    public enum IssueStatusType {
        IN_PROGRESS,RESOLVED,UNASSIGNED;
    }

    public enum OpAvailabilityType {
        AVAILABLE,BUSY;
    }

    public enum TextType {
        FUEL,ACCIDENT,TYRE;
    }

}
