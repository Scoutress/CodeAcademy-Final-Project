package lt.codeacademy.javau7.finalproject1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lt.codeacademy.javau7.finalproject1.entities.Ingredient;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Integer> {
}
