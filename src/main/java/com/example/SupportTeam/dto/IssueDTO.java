package com.example.SupportTeam.dto;
import com.example.SupportTeam.entity.UsersDetails;
import com.example.SupportTeam.enums.DataTypeEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@Setter
public class IssueDTO {
    private Long userId;
    private DataTypeEnum.TextType textType;
}
