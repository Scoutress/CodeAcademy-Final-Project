package lt.codeacademy.javau7.project.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import lt.codeacademy.javau7.project.entities.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    Optional<Recipe> findById(Long recipeId);

    List<Recipe> findByUserId(int userId);}
