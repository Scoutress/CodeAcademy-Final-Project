package lt.codeacademy.javau7.finalproject1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import lt.codeacademy.javau7.finalproject1.entities.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {}