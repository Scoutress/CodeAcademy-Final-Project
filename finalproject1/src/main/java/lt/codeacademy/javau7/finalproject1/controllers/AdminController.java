package lt.codeacademy.javau7.finalproject1.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lt.codeacademy.javau7.finalproject1.entities.Recipe;
import lt.codeacademy.javau7.finalproject1.entities.User;
import lt.codeacademy.javau7.finalproject1.services.RecipeService;
import lt.codeacademy.javau7.finalproject1.services.UserService;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final UserService userService;
    private final RecipeService recipeService;

    public AdminController(UserService userService, RecipeService recipeService) {
        this.userService = userService;
        this.recipeService = recipeService;
    }

    @GetMapping("/dashboard")
    public String dashboard() {
        return "dashboard";
    }

    @GetMapping("/users")
    public String getAllUsers(Model model) {
        List<User> userList = userService.getAllUsers();
        model.addAttribute("users", userList);
        return "users/user-list-admin";
    }

    @GetMapping("/user/edit/{id}")//NEVEIKIA
    public String showEditUserForm(@PathVariable Long id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "users/user-edit";
    }

    @PostMapping("/user/edit/save/{id}")//NEVEIKIA
    public String updateUser(@PathVariable Long id, @ModelAttribute User updatedUser) {
        updatedUser.setId(id);
        userService.updateUser(updatedUser);
        return "redirect:/admin/users";
    }

    @GetMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable int id) {
        userService.deleteById(id);
        return "redirect:/admin/users";
    }

    @PostMapping("/user/delete/{id}")
    public String deleteUserConfirmed(@PathVariable int id) {
        return deleteUser(id);
    }

///////////////////////////////////////////////////////////////////////////////////////////////////
//                                Receptai

    @GetMapping("/recipes")
    public String getAllRecipes(Model model) {
        List<Recipe> recipes = recipeService.getAllRecipes();
        model.addAttribute("recipes", recipes);
        return "recipes/recipe-list-admin";
    }

    // @GetMapping("/user/recipes/{userId}")//NEVEIKIA
    // public String getUserRecipes(@PathVariable Long id, Model model) {
    //     User user = userService.getUserById(id);
    //     List<Recipe> recipes = recipeService.findByUserId(id);
    //     model.addAttribute("user", user);
    //     model.addAttribute("recipes", recipes);
    //     return "users/user-recipes";
    // }







}
