package lt.codeacademy.javau7.finalproject1.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lt.codeacademy.javau7.finalproject1.entities.Recipe;
import lt.codeacademy.javau7.finalproject1.services.RecipeService;

@Controller
public class GuestController {

    private final RecipeService recipeService;

    public GuestController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }
    
    @GetMapping("")
    public String firstPageTemp(Model model) {
        List<Recipe> recipes = recipeService.getAllRecipes();
        model.addAttribute("recipes", recipes);
        return "firstPage";
    }

    @GetMapping("/login")
    public String showLogin() {
        return "login/login";
    }

    @GetMapping("/register")
    public String showRegister() {
        return "register/registration-form";
    }

    @GetMapping("/recipe/details")
    public String showRecipeDetails(@RequestParam("recipeId") int theId, Model theModel) {
        Recipe theRecipe = recipeService.findById(theId);
        theModel.addAttribute("recipe", theRecipe);
        return "recipes/recipe-details-guest";
    }

    @GetMapping("/recipe/list")
    public String getAllRecipes(Model model) {
        List<Recipe> recipes = recipeService.getAllRecipes();
        model.addAttribute("recipes", recipes);
        return "firstPage";
    }
}
