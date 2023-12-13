// package lt.codeacademy.javau7.project.controllers;

// import java.util.List;

// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestMapping;

// import lt.codeacademy.javau7.project.entities.Recipe;
// import lt.codeacademy.javau7.project.entities.User;
// import lt.codeacademy.javau7.project.services.RecipeService;
// import lt.codeacademy.javau7.project.services.UserService;

// @Controller
// @RequestMapping("/user")
// public class UserController {

//     private final UserService userService;
//     private final RecipeService recipeService;

//     public UserController(UserService userService, RecipeService recipeService) {
//         this.userService = userService;
//         this.recipeService = recipeService;
//     }

//     @GetMapping("/create")
//     public String showCreateForm(Model model) {
//         model.addAttribute("recipe", new Recipe());
//         return "create-recipe";
//     }

//     @PostMapping("/create")
//     public String createRecipe(Recipe recipe) {
//         User currentUser = getCurrentUser();
//         recipe.setUser(currentUser);
//         recipeService.save(recipe);
//         return "redirect:/user/all-recipes";
//     }

//     @GetMapping("/myrecipes/{username}")
//     public String showMyRecipes(@PathVariable String username, Model model) {
//         User user = userService.findByUsername(username);
//         if (user == null) {
//             throw new RuntimeException("User with username " + username + " not found");
//         }

//         List<Recipe> userRecipes = recipeService.findByUser(user);
//         model.addAttribute("userRecipes", userRecipes);

//         return "my-recipes";
//     }

//     private User getCurrentUser() {
//         // Čia turite grąžinti dabartinio vartotojo informaciją
//         // Pavyzdys su Spring Security:
//         // Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//         // return ((UserDetails) authentication.getPrincipal()).getUser();
//         return null;
//     }
// }
