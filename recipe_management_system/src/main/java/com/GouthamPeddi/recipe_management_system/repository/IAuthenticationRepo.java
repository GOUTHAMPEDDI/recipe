package com.GouthamPeddi.recipe_management_system.repository;

import com.GouthamPeddi.recipe_management_system.model.AuthenticationToken;
import com.GouthamPeddi.recipe_management_system.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAuthenticationRepo extends JpaRepository<AuthenticationToken,Long> {

    AuthenticationToken findFirstByTokenValue(String authTokenValue);


    AuthenticationToken findFirstByUser(User user);

}
