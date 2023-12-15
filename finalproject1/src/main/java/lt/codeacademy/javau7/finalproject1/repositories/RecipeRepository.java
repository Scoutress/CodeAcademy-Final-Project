package lt.codeacademy.javau7.finalproject1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lt.codeacademy.javau7.finalproject1.entities.Recipe;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Integer> {

    void deleteById(Long id);
}
