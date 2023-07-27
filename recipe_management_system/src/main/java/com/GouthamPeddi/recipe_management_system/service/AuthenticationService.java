package com.GouthamPeddi.recipe_management_system.service;

import com.GouthamPeddi.recipe_management_system.model.AuthenticationToken;
import com.GouthamPeddi.recipe_management_system.model.User;
import com.GouthamPeddi.recipe_management_system.repository.IAuthenticationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Autowired
    IAuthenticationRepo authenticationRepo;

    public boolean authenticate(String email, String authTokenValue){

        AuthenticationToken authToken = authenticationRepo.findFirstByTokenValue(authTokenValue);

        if(authToken==null){
            return false;
        }

        String tokenConnectedEmail = authToken.getUser().getUserEmail();

        return tokenConnectedEmail.equals(email);

    }


    public void saveAuthToken(AuthenticationToken authToken) {
        authenticationRepo.save(authToken);
    }

    public AuthenticationToken findFirstByUser(User user) {
        return authenticationRepo.findFirstByUser(user);
    }


    public void removeAuthToken(AuthenticationToken authToken) {
        authenticationRepo.delete(authToken);
    }

}
