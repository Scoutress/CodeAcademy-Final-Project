package lt.codeacademy.javau7.project.controllers;

import lt.codeacademy.javau7.project.entities.Recipe;
import lt.codeacademy.javau7.project.entities.User;
import lt.codeacademy.javau7.project.services.RecipeService;
import lt.codeacademy.javau7.project.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        List<User> users = userService.findAll();
        for (User user : users) {
            int recipeCount = recipeService.findByUserId(user.getId()).size();
            user.setRecipeCount(recipeCount);
        }

        model.addAttribute("users", users);
        return "users/user-list-admin";
    }

    @GetMapping("/user/showNewUserForm")
    public String showAddUserForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "users/user-add";
    }

    @PostMapping("/user/add-new")
    public String addUser(@ModelAttribute User user) {
        userService.save(user);
        return "redirect:/admin/users";
    }

    @GetMapping("/user/edit/{id}")
    public String showEditUserForm(@PathVariable int id, Model model) {
        User user = userService.findById(id);
        model.addAttribute("user", user);
        return "users/user-edit";
    }

    @PostMapping("/user/edit/{id}")
    public String editUser(@PathVariable int userId, @ModelAttribute User updatedUser) {
        userService.save(updatedUser);
        return "redirect:/admin/users";
    }

    @GetMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable int id) {
        List<Recipe> recipes = recipeService.findByUserId(id);
        recipeService.deleteAll(recipes);
        userService.deleteById(id);
        return "redirect:/admin/users";
    }

    @PostMapping("/user/delete/{id}")
    public String deleteUserConfirmed(@PathVariable int id) {
        return deleteUser(id);
    }

///////////////////////////////////////////////////////////////////////////////////////////////////////////

    @GetMapping("/recipes")
    public String getAllRecipes(Model model) {
        List<Recipe> recipes = recipeService.findAll();
        model.addAttribute("recipes", recipes);
        return "recipes/recipe-list-admin";
    }

    @GetMapping("/recipe/new")
    public String showCreateRecipeForm(Model model) {
        Recipe newRecipe = new Recipe();
        model.addAttribute("recipe", newRecipe);
        return "recipes/recipe-add";
    }

    @PostMapping("/recipe/new")
    public String createRecipe(@ModelAttribute Recipe newRecipe) {
        recipeService.save(newRecipe);
        return "redirect:/admin/recipes";
    }

    @GetMapping("/user/recipes/{userId}")
    public String getUserRecipes(@PathVariable int userId, Model model) {
        User user = userService.findById(userId);
        List<Recipe> recipes = recipeService.findByUserId(userId);
        model.addAttribute("user", user);
        model.addAttribute("recipes", recipes);
        return "users/user-recipes";
    }

    @GetMapping("/user/recipe/edit/{recipeId}")
    public String showEditRecipeForm(@PathVariable Long recipeId, Model model) {
        Recipe existingRecipe = recipeService.findById(recipeId);
        if (existingRecipe == null) {
            existingRecipe = new Recipe();
        }
        model.addAttribute("recipe", existingRecipe);
        return "recipes/recipe-edit";
    }

    @PostMapping("/user/recipe/edit/{recipeId}")
    public String editRecipe(@PathVariable Long recipeId, @ModelAttribute Recipe updatedRecipe) {
        recipeService.save(updatedRecipe);
        return "redirect:/admin/user/recipes/{userId}";
    }

    @GetMapping("/user/recipe/delete/{recipeId}")
    public String showDeleteRecipeConfirmation(@PathVariable Long recipeId, Model model) {
        Recipe recipe = recipeService.findById(recipeId);
        model.addAttribute("recipe", recipe);
        return "recipes/recipe-delete-confirmation";
    }

    @PostMapping("/user/recipe/delete/{recipeId}")
    public String deleteRecipe(@PathVariable Long recipeId, @RequestParam Long userId) {
        recipeService.deleteById(recipeId);
        return "redirect:/admin/user/recipes/" + userId;
    }

}
