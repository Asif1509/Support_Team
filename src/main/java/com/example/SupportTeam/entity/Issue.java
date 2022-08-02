package com.example.SupportTeam.entity;

import com.example.SupportTeam.entity.UsersDetails;
import com.example.SupportTeam.enums.DataTypeEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Entity
@Table
@Getter
@Setter

public class Issue {
    @Id
    @SequenceGenerator(
            name = "issue_sequence",
            sequenceName = "issue_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "issue_sequence"
    )
    private Long id;

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

    public DataTypeEnum.IssueStatusType getIssueStatusType() {
        return issueStatusType;
    }

    public void setIssueStatusType(DataTypeEnum.IssueStatusType issueStatusType) {
        this.issueStatusType = issueStatusType;
    }

    public DataTypeEnum.TextType getTextType() {
        return textType;
    }

    public void setTextType(DataTypeEnum.TextType textType) {
        this.textType = textType;
    }

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UsersDetails userId;
    @ManyToOne
    @JoinColumn(name = "assigned_to")
    private UsersDetails assignedTo;

    public UsersDetails getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(UsersDetails assignedTo) {
        this.assignedTo = assignedTo;
    }

    private DataTypeEnum.IssueStatusType issueStatusType;
    private DataTypeEnum.TextType textType;
}
