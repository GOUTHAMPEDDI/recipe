package com.GouthamPeddi.recipe_management_system.controller;

import com.GouthamPeddi.recipe_management_system.model.Comment;
import com.GouthamPeddi.recipe_management_system.service.AuthenticationService;
import com.GouthamPeddi.recipe_management_system.service.CommentService;
import com.GouthamPeddi.recipe_management_system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {

    @Autowired
    CommentService commentService;

    @Autowired
    AuthenticationService authenticationService;

    @PostMapping("Comment/{recipeId}")
    public String addComment(@PathVariable Long recipeId, @RequestBody Comment comment,@PathVariable String email,@PathVariable String tokenVal){
        if(authenticationService.authenticate(email,tokenVal)){
            return commentService.addComment(comment,recipeId);
        }else{
            return "Not an authorised user to perform this activity!!!";
        }
    }

    @DeleteMapping("Comment/{Id}/{email}/{tokenVal}")
    public String removeCommentById(@PathVariable Long Id,@PathVariable String email,@PathVariable String tokenVal){
        if(authenticationService.authenticate(email,tokenVal)){
            return commentService.removeComment(Id,email);
        }else{
            return "Not an authorised user to perform this activity!!!";
        }
    }

    @GetMapping("Comment/{commentId}")
    public Comment getCommentById(@PathVariable Long commentId){
        return commentService.getCommentById(commentId);
    }

    @GetMapping("Comments/{recipeId}")
    public List<Comment> getAllCommentsOnRecipe(@PathVariable Long recipeId){
        return commentService.getAllCommentsOnRecipe(recipeId);
    }


}
