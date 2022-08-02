package com.example.SupportTeam.service;

import com.example.SupportTeam.dto.IssueCommnetsResponseDTO;
import com.example.SupportTeam.dto.UsersData;
import com.example.SupportTeam.dto.VehicleDTO;
import com.example.SupportTeam.entity.*;
import com.example.SupportTeam.enums.DataTypeEnum;
import com.example.SupportTeam.repository.CommentsRepository;
import com.example.SupportTeam.repository.ExecutiveAvailabilityRepository;
import com.example.SupportTeam.repository.IssueRepository;
import com.example.SupportTeam.repository.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class AdminService  {
    @Autowired

    IssueRepository issueRepository ;
    @Autowired

    UserDetailsRepository usersDetailsRepository;
    @Autowired

    ExecutiveAvailabilityRepository executiveAvailabilityRepository;
    @Autowired
    CommentsRepository commentsRepository;
    public void assignToExecutive() throws Exception {
        List<Issue> allIssues=issueRepository.findByAssignedToIsNull();
        if (allIssues.isEmpty()) {
            throw new Exception("No Issue to be solve");
        }
        ExecutiveAvailability topExecutive= executiveAvailabilityRepository.findTopByOpAvailabilityType(DataTypeEnum.OpAvailabilityType.AVAILABLE);
        System.out.println(topExecutive.getUserId().getId());
        if(topExecutive==null){
            throw new Exception("No Executive to Assign");
        }
        for(Issue oneIssue : allIssues) {
            oneIssue.setAssignedTo(topExecutive.getUserId());
            oneIssue.setIssueStatusType(DataTypeEnum.IssueStatusType.IN_PROGRESS);
            issueRepository.save(oneIssue);
        }
        topExecutive.setOpAvailabilityType(DataTypeEnum.OpAvailabilityType.BUSY);
        executiveAvailabilityRepository.save(topExecutive);
    }
// Vikram Reassign to -- Check assign to method also is it ok?
    public void reassignToExecutive() throws Exception {
        List<Issue> allIssues=issueRepository.findByAssignedToIsNotNull();
        if (allIssues.isEmpty()) {
            throw new Exception("No Issue to be solve");
        }
        ExecutiveAvailability topExecutive= executiveAvailabilityRepository.findTopByOpAvailabilityType(DataTypeEnum.OpAvailabilityType.AVAILABLE);
        System.out.println(topExecutive.getUserId().getId());
        if(topExecutive==null){
            throw new Exception("No Executive to Assign");
        }
        for(Issue oneIssue : allIssues) {
            oneIssue.setAssignedTo(topExecutive.getUserId());
            oneIssue.setIssueStatusType(DataTypeEnum.IssueStatusType.IN_PROGRESS);
            issueRepository.save(oneIssue);
        }
        topExecutive.setOpAvailabilityType(DataTypeEnum.OpAvailabilityType.BUSY);
        executiveAvailabilityRepository.save(topExecutive);
    }
    public void addNewAdmin(UsersData usersData) {
        UsersDetails usersDetails=new UsersDetails();
        usersDetails.setName(usersData.getName());
        usersDetails.setAddress(usersData.getAddress());
        usersDetails.setContact(usersData.getContact());
        usersDetails.setUserType(DataTypeEnum.UserType.ADMIN);
        usersDetails=usersDetailsRepository.save(usersDetails);
    }

    public IssueCommnetsResponseDTO fetchIssueAndComments(Long issueId) throws Exception {
        IssueCommnetsResponseDTO issueCommnetsResponseDTO=new IssueCommnetsResponseDTO();
        Optional<Issue>optionalIssue=issueRepository.findById(issueId);
        if (optionalIssue.isEmpty()) {
            throw new Exception("No Issue is there");
        }
        issueCommnetsResponseDTO.setIssueStatusType(optionalIssue.get().getIssueStatusType());
        issueCommnetsResponseDTO.setAssignedTo(optionalIssue.get().getAssignedTo());
        issueCommnetsResponseDTO.setUser(optionalIssue.get().getUserId());
        issueCommnetsResponseDTO.setTextType(optionalIssue.get().getTextType());
        //Vikram Change Optional to List
        List<Comments> allcomments=commentsRepository.findByIssueId(issueId);
        if(allcomments.isEmpty()){
            throw  new Exception("No comments");
        }
        //Vikram (List<Comments>) allcomments.get() replace to allcomments
        issueCommnetsResponseDTO.setCommentsdetails(allcomments);
         return issueCommnetsResponseDTO;
    }
}
