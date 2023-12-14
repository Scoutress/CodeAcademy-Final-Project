package lt.codeacademy.javau7.project.repositories;

import lt.codeacademy.javau7.project.entities.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {}
