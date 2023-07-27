package com.GouthamPeddi.recipe_management_system.controller;

import com.GouthamPeddi.recipe_management_system.model.Recipe;
import com.GouthamPeddi.recipe_management_system.model.User;
import com.GouthamPeddi.recipe_management_system.model.dto.SignInInput;
import com.GouthamPeddi.recipe_management_system.model.dto.SignUpOutput;
import com.GouthamPeddi.recipe_management_system.service.AuthenticationService;
import com.GouthamPeddi.recipe_management_system.service.CommentService;
import com.GouthamPeddi.recipe_management_system.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

    @RestController
    public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    AuthenticationService authenticationService;

    @PostMapping("User/signUp")
    public SignUpOutput signUp(@RequestBody User user){
        return UserService.signUpUser(user);
    }

    @PostMapping("User/signIn")
    public String signInUser(@RequestBody @Valid SignInInput signInInput){
        return userService.signInUser(signInInput);
    }

    @DeleteMapping("User/signOut/{email}/{token}")
    public String signOutUser(@PathVariable String email , @PathVariable String token){
        if(authenticationService.authenticate(email,token)) {
            return UserService.signOutUser(email);
        }
        return "Sign out not allowed for non authenticated user";
    }

    @GetMapping("Recipies")
    public List<Recipe> getAllRecipies(){

        return userService.getAllRecipies();
    }

    @PostMapping("Recipe/{email}/{tokenVal}")
    public String createRecipe(@RequestBody Recipe recipe,@PathVariable String email,@PathVariable String tokenVal){
        if(authenticationService.authenticate(email,tokenVal)){
            return userService.postRecipe(recipe);
        }else{
            return "Not an authorised user for this activity";
        }
    }

    @PutMapping("Recipe/{email}/{tokenVal}")
    public String updateRecipeById(@PathVariable Long Id,@PathVariable String email,@PathVariable String tokenVal,@RequestBody String ingrediants){
        if(authenticationService.authenticate(email,tokenVal)){
            return userService.updateRecipeById(Id,email,ingrediants);
        }else{
            return "Not an authorised user to perform this activity";
        }
    }

    @DeleteMapping("Recipe/{Id}/{email}/{tokenVal}")
    public String removeRecipeById(@PathVariable Long Id,@PathVariable String email,@PathVariable String tokenVal){
        if(authenticationService.authenticate(email,tokenVal)){
            return userService.removeRecipe(Id,email);
        }else{
            return "Not an authorised user to perform this activity!!!";
        }
    }

    @GetMapping("Recipe/{Id}")
    public Recipe getRecipeById(@PathVariable Long Id){
        return userService.getRecipeById(Id);
    }


}
