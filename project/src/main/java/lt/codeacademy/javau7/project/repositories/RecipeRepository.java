package lt.codeacademy.javau7.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import lt.codeacademy.javau7.project.entities.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe, Integer> {}
