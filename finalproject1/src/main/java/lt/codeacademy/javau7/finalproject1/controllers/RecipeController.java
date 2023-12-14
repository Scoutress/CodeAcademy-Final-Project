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
@RequestMapping("/recipes")
public class RecipeController {

    //private final IngredientService ingredientService;
    private final RecipeService recipeService;

    // public RecipeController(IngredientService ingredientService, RecipeService recipeService) {
    //     this.ingredientService = ingredientService;
    //     this.recipeService = recipeService;
    // }

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/new")
    public String showRecipeForm(Model model) {
        model.addAttribute("recipe", new Recipe());
        //model.addAttribute("existingIngredients", ingredientService != null ? ingredientService.getAllIngredients() : null);
        return "recipes/recipe-add";
    }

    @PostMapping("/new")
    public String saveRecipe(@ModelAttribute Recipe recipe) {
        if (recipe != null) {
            // User currentUser = getCurrentUser();
            // recipe.setUser(currentUser);

            // Set<Ingredient> ingredients = recipe.getIngredients();
            // if (ingredients != null && !ingredients.isEmpty()) {
            //     for (Ingredient ingredient : ingredients) {
            //         ingredient.setRecipe(recipe);
            //     }
            // }

            recipeService.save(recipe);

            return "redirect:/recipes";
        } else {
            return "recipes/recipe-add";
        }
    }


    @GetMapping("/{recipeId}/edit")
    public String showEditRecipeForm(@PathVariable Long recipeId, Model model) {
        Recipe existingRecipe = recipeService.findById(recipeId);
        model.addAttribute("recipe", existingRecipe);
        //model.addAttribute("existingIngredients", ingredientService != null ? ingredientService.getAllIngredients() : null);
        return "recipes/recipe-edit";
    }

    @PostMapping("/{recipeId}/edit")
    public String editRecipe(@PathVariable Long recipeId, @ModelAttribute Recipe editedRecipe) {
        Recipe existingRecipe = recipeService.findById(recipeId);
        existingRecipe.setTitle(editedRecipe.getTitle());
        existingRecipe.setDescription(editedRecipe.getDescription());
        recipeService.save(existingRecipe);
        return "redirect:/recipes";
    }


    // @GetMapping("/{recipeId}/delete")
    // public String deleteRecipe(@PathVariable Long recipeId) {
    //     // TODO: Įdėkite kodą, kad ištrintumėte receptą duomenų bazėje pagal ID

    //     return "redirect:/recipes";
    // }

    // @PostMapping("/{recipeId}/add-ingredient")
    // public String addIngredientToRecipe(@PathVariable Long recipeId, @ModelAttribute Ingredient ingredient) {
    //     // TODO: Įdėkite kodą, kad pridėtumėte ingridientą prie recepto

    //     return "redirect:/recipes/{recipeId}/edit";
    // }

    // @GetMapping("/{recipeId}/edit-ingredient/{ingredientId}")
    // public String showEditIngredientForm(@PathVariable Long recipeId, @PathVariable Long ingredientId, Model model) {
    //     // TODO: Įdėkite kodą, kad gautumėte ingridientą pagal ID ir perduotumėte jį į modelį

    //     return "recipes/ingredient-edit";
    // }

    // @PostMapping("/{recipeId}/edit-ingredient/{ingredientId}")
    // public String editIngredient(@PathVariable Long recipeId, @PathVariable Long ingredientId, @ModelAttribute Ingredient ingredient) {
    //     // TODO: Įdėkite kodą, kad atnaujintumėte ingridientą duomenų bazėje

    //     return "redirect:/recipes/{recipeId}/edit";
    // }

    // @GetMapping("/{recipeId}/delete-ingredient/{ingredientId}")
    // public String deleteIngredientFromRecipe(@PathVariable Long recipeId, @PathVariable Long ingredientId) {
    //     // TODO: Įdėkite kodą, kad ištrintumėte ingridientą iš recepto

    //     return "redirect:/recipes/{recipeId}/edit";
    // }
}
