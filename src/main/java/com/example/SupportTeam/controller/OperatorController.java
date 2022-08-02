package com.example.SupportTeam.controller;
import com.example.SupportTeam.dto.CommentsDTO;
import com.example.SupportTeam.dto.IssueDTO;
import com.example.SupportTeam.dto.UsersData;
import com.example.SupportTeam.entity.Comments;
import com.example.SupportTeam.repository.CommentsRepository;
import com.example.SupportTeam.service.OperatorService;
import com.example.SupportTeam.service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/operator")
public class OperatorController {
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private OperatorService operatorService;

    @PostMapping("/create-operator")
    public void registerOperator(@RequestBody UsersData userDetails) {

        userDetailsService.addNewOperator(userDetails);
    }
    @PostMapping("/issue")
    public void createIssue(@RequestBody IssueDTO issueDTO) throws Exception {
        operatorService.createNewIssue(issueDTO);
    }

    @PostMapping("/comments")
    public void writeComments(@RequestBody CommentsDTO commentsDTO) throws Exception {
        operatorService.createNewComment(commentsDTO);
    }

    @GetMapping("/comments")
    public List<Comments> getComments(@RequestParam Long userId,Long issueId) throws Exception{
        return operatorService.getAllComments(userId,issueId);
    }
}
