package com.GouthamPeddi.recipe_management_system.repository;

import com.GouthamPeddi.recipe_management_system.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepo extends JpaRepository<User,Long> {
    public User findFirstByuserEmail(String userEmail);

}
