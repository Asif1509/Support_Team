package com.example.SupportTeam.dto;

import com.example.SupportTeam.entity.UsersDetails;
import com.example.SupportTeam.enums.DataTypeEnum;

public class CommentsDTO {
    private Long userId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    private Long issueId;
    public Long getIssueId() {
        return issueId;
    }

    public void setIssueId(Long issueId) {
        this.issueId = issueId;
    }

    private String text;
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
