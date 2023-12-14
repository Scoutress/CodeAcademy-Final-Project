package lt.codeacademy.javau7.finalproject1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lt.codeacademy.javau7.finalproject1.entities.Recipe;
import lt.codeacademy.javau7.finalproject1.services.RecipeService;

@Controller
@RequestMapping("/user")
public class UserController {

    private final RecipeService recipeService;

    public UserController(RecipeService theRecipeService) {
        this.recipeService = theRecipeService;
    }

    @GetMapping("/recipe/{recipe_id}")
    public String showRecipe(@PathVariable("recipe_id") Long recipeId, Model model) {
        Recipe recipe = recipeService.findById(recipeId);
        model.addAttribute("recipe", recipe);
        return "recipes/recipe-details";
    }

    @GetMapping("/recipe/new")
    public String showNewRecipeForm(Model model){
        Recipe recipe = new Recipe();
        model.addAttribute("recipe", recipe);
        return "recipes/recipe-add";
    }

    @PostMapping("/recipe/save")
    public String saveRecipe(@ModelAttribute("recipe") Recipe recipe){
        recipeService.save(recipe);
        return "redirect:/user";
    }
}
