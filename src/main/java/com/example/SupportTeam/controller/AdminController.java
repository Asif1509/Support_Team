package com.example.SupportTeam.controller;

import com.example.SupportTeam.dto.IssueCommnetsResponseDTO;
import com.example.SupportTeam.dto.UsersData;
import com.example.SupportTeam.entity.Issue;
import com.example.SupportTeam.repository.IssueRepository;
import com.example.SupportTeam.repository.UserDetailsRepository;
import com.example.SupportTeam.service.AdminService;
import com.example.SupportTeam.service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController()
@RequestMapping(path = "admin")
public class AdminController {
    @Autowired
    UserDetailsService userDetailsService;
    @Autowired
    IssueRepository issueRepository;
    @Autowired
    AdminService adminService;
    @PostMapping("/create-admin")
    public void registerAdmin(@RequestBody UsersData userDetails) {
        userDetailsService.addNewAdmin(userDetails);
        System.out.println("admin is created");
    }

    @PostMapping("/assign-issue")
    public void assignIssue() throws Exception {
        adminService.assignToExecutive();
    }
    @PutMapping("/reassign-issue")
    public void reassignIssue() throws Exception {
        adminService.reassignToExecutive();
    }
    @GetMapping("/issue-with-comments")
    public IssueCommnetsResponseDTO issueWithComments(@RequestParam(value="issue-id") Long issueId) throws Exception {
        System.out.println("Very Long Character issue 1");
       return adminService.fetchIssueAndComments(issueId);
    }

    @GetMapping("/health")
    public  String checkhealth(){
        return "Succes!";
    }

}
