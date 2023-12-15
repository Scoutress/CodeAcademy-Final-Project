package lt.codeacademy.javau7.finalproject1.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lt.codeacademy.javau7.finalproject1.entities.Ingredient;
import lt.codeacademy.javau7.finalproject1.entities.Recipe;
import lt.codeacademy.javau7.finalproject1.services.IngredientService;
import lt.codeacademy.javau7.finalproject1.services.RecipeService;
import lt.codeacademy.javau7.finalproject1.services.UserService;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final RecipeService recipeService;
    private final IngredientService ingredientService;

    public AdminController(UserService userService, RecipeService recipeService, IngredientService ingredientService) {
        this.recipeService = recipeService;
        this.ingredientService = ingredientService;
    }

    @GetMapping("/dashboard")
    public String dashboard() {
        return "dashboard";
    }

/////////////////////////////////////////////////////////////////////////////
//                                Receptai

    @GetMapping("/recipe/new")
    public String showRecipeForm(Model model) {
        model.addAttribute("newRecipe", new Recipe());
        return "recipes/recipe-add";
    }

    @PostMapping("/recipe/new")
    public String addRecipe(@ModelAttribute("recipe") Recipe recipe) {
        recipeService.addRecipe(recipe);
        return "redirect:/recipe/list";
    }

    @GetMapping("/recipe/delete")
    public String deleteRecipe(@RequestParam("recipeId") int theId){
        recipeService.deleteRecipeById(theId);
        return "redirect:/recipe/list";    
    }

    @GetMapping("/recipe/showEditForm")
    public String showEditForm(@RequestParam("recipeId") int theId, Model theModel){
        Recipe theRecipe = recipeService.findById(theId);
        theModel.addAttribute("recipe", theRecipe);
        return "recipes/recipe-edit";
    }

    @PostMapping("/recipe/save")
    public String saveRecipe(@ModelAttribute Recipe recipe) {
        recipeService.saveRecipe(recipe);
        return "redirect:/recipe/list";
    }

/////////////////////////////////////////////////////////////////////////////
//                                Ingridientai

    @GetMapping("/ingr/list")
    public String getAllIngr(Model model) {
        List<Ingredient> ingredients = ingredientService.getAllIngr();
        model.addAttribute("ingredients", ingredients);
        return "ingredients/ingredient-list";
    }

    @GetMapping("/ingr/new")//Nesutvarkyta
    public String showIngredientForm(Model model) {
        model.addAttribute("newRecipe", new Recipe());
        return "recipes/recipe-add";
    }

    @PostMapping("/ingr/new")//Nesutvarkyta
    public String addIngredient(@ModelAttribute("recipe") Recipe recipe) {
        recipeService.addRecipe(recipe);
        return "redirect:/recipe/list";
    }
}
