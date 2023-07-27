package com.GouthamPeddi.recipe_management_system.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
    public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long recipeId;

    @NotNull(message = "recipe name must not be null")
    @Column(nullable = false)
    private String recipeName;

    @NotBlank(message = "ingredients should not be empty")
    @Column(nullable = false, columnDefinition = "TEXT")
    private String ingredients;

    @NotBlank(message = "Instructions must not be empty")
    @Column(nullable = false, columnDefinition = "TEXT")
    private String instructions;

    @ManyToOne
    @JoinColumn(name = "fk_user_id", nullable = false)
    private User user;

}

