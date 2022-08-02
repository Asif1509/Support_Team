package com.example.SupportTeam.dto;

import com.example.SupportTeam.entity.Comments;
import com.example.SupportTeam.entity.Issue;
import com.example.SupportTeam.entity.UsersDetails;
import com.example.SupportTeam.enums.DataTypeEnum;


import javax.persistence.*;
import java.util.List;

public class IssueCommnetsResponseDTO {

    private UsersDetails user;
    private UsersDetails assignedTo;
    private DataTypeEnum.IssueStatusType issueStatusType;
    private DataTypeEnum.TextType textType;

    List<Comments> commentsdetails;

    public UsersDetails getUser() {
        return user;
    }

    public void setUser(UsersDetails user) {
        this.user = user;
    }

    public UsersDetails getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(UsersDetails assignedTo) {
        this.assignedTo = assignedTo;
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

    public List<Comments> getCommentsdetails() {
        return commentsdetails;
    }

    public void setCommentsdetails(List<Comments> commentsdetails) {
        this.commentsdetails = commentsdetails;
    }
}
