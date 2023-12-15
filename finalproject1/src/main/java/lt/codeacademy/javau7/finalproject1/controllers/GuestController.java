package lt.codeacademy.javau7.finalproject1.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GuestController {

    // @GetMapping("")
    // public String getAllRecipes(Model model) {
    //     List<Recipe> recipes = recipeService.findAll();
    //     model.addAttribute("recipes", recipes);
    //     return "recipes/recipe-list";
    // }

    //Laikinas
    @GetMapping("")
    public String firstPageTemp() {
        return "guest-testing-page";
    }

    @GetMapping("/login")
    public String showLogin() {
        return "login";
    }

    @GetMapping("/register")
    public String showRegister() {
        return "register";
    }

    // @GetMapping("/recipe/{recipe_id}")
    // public String showRecipe(@PathVariable("recipe_id") Long recipeId, Model model) {
    //     Recipe recipe = recipeService.findById(recipeId);
    //     model.addAttribute("recipe", recipe);
    //     return "recipes/recipe-details";
    // }
}
