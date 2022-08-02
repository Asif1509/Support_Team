package com.example.SupportTeam.controller;

import com.example.SupportTeam.dto.CommentsDTO;
import com.example.SupportTeam.dto.UsersData;
import com.example.SupportTeam.entity.Comments;
import com.example.SupportTeam.service.ExecutiveService;
import com.example.SupportTeam.service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "executive")
public class ExecutiveController {
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private ExecutiveService executiveService;

    @PostMapping("/executive")
    public void registerExecutive(@RequestBody UsersData userDetails) {
        userDetailsService.addNewExecutive(userDetails);
    }

    @PostMapping("/comments")
    public void writeComments(@RequestBody CommentsDTO commentsDTO) throws Exception {
        executiveService.createNewComment(commentsDTO);
    }
    @GetMapping("/comments")
    public List<Comments> getComments(@RequestParam Long userId,@RequestParam Long issueId) throws Exception{
        return executiveService.getAllComments(userId,issueId);
    }
}
