package lt.codeacademy.javau7.finalproject1.controllers;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lt.codeacademy.javau7.finalproject1.entities.Ingredient;
import lt.codeacademy.javau7.finalproject1.entities.Recipe;
import lt.codeacademy.javau7.finalproject1.services.IngredientService;
import lt.codeacademy.javau7.finalproject1.services.RecipeService;
import lt.codeacademy.javau7.finalproject1.services.UserService;

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
        List<Ingredient> ingredients = ingredientService.getAllIngred();
        model.addAttribute("ingredients", ingredients);
        return "ingredients/ingredient-list";
    }

    @GetMapping("/ingr/new")
    public String showIngredientForm(Model model) {
        model.addAttribute("newIngredient", new Ingredient());
        return "ingredients/ingredient-add";
    }

    @PostMapping("/ingr/new")
    public String addIngredient(@ModelAttribute("newIngredient") Ingredient ingredient) {
        ingredientService.addIngredient(ingredient);
        return "redirect:/admin/ingr/list";
    }

    @GetMapping("/ingr/delete")
    public String deleteIngredient(@RequestParam("ingredientId") int theId){
        ingredientService.deleteIngredientById(theId);
        return "redirect:/admin/ingr/list";    
    }

    @GetMapping("/ingr/showEditForm")
    public String showIngrEditForm(@RequestParam("ingredientId") int theId, Model theModel){
        Ingredient theIngredient = ingredientService.findById(theId);
        theModel.addAttribute("ingredient", theIngredient);
        return "ingredients/ingredient-edit";
    }

    @PostMapping("/ingr/save")
    public String saveIngredient(@ModelAttribute Ingredient ingredient) {
        ingredientService.saveIngredient(ingredient);
        return "redirect:/admin/ingr/list";
    }
}
