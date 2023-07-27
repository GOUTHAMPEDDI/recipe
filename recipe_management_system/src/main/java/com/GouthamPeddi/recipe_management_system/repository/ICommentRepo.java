package com.GouthamPeddi.recipe_management_system.repository;

import com.GouthamPeddi.recipe_management_system.model.Comment;
import com.GouthamPeddi.recipe_management_system.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICommentRepo extends JpaRepository<Comment,Long> {

    List<Comment> findAllByRecipe(Recipe recipe);

}
