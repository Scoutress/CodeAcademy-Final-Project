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

    
    @GetMapping("")
    public String firstPageTemp() {
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


}
