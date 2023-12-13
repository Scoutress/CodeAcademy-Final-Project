// package lt.codeacademy.javau7.project.controllers;

// import lt.codeacademy.javau7.project.entities.Recipe;
// import lt.codeacademy.javau7.project.entities.User;
// import lt.codeacademy.javau7.project.services.AdminService;
// import lt.codeacademy.javau7.project.services.RecipeService;
// import lt.codeacademy.javau7.project.services.UserService;
// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;

// @Controller
// @RequestMapping("/admin")
// public class AdminController {

//     private final UserService userService;
//     private final RecipeService recipeService;
//     private final AdminService adminService;

//     // private static final String REDIRECT_USERS = "redirect:/admin/users";

//     public AdminController(AdminService adminService, UserService userService, RecipeService recipeService) {
//         this.adminService = adminService;
//         this.userService = userService;
//         this.recipeService = recipeService;
//     }

//     @GetMapping("/users")
//     public String getAllUsers(Model model) {
//         List<User> users = userService.findAll();
//         model.addAttribute("users", users);
//         return "userlist";
//     }

//     // @RequestMapping(value = "/create-new-user", method = {RequestMethod.GET, RequestMethod.POST})
//     // public String handleCreateUserRequest(@ModelAttribute User user, Model model) {
//     //     user.setId(0);
//     //     userService.save(user);
//     //     return REDIRECT_USERS;
//     // }

//     // @GetMapping("/update-user/{id}")
//     // public String showUpdateUserForm(@PathVariable int id, Model model) {
//     //     User user = userService.findById(id);
//     //     model.addAttribute("user", user);
//     //     return "update-user";
//     // }

//     // @PostMapping("/update-user")
//     // public String updateUser(User user) {
//     //     userService.save(user);
//     //     return REDIRECT_USERS;
//     // }

//     // @GetMapping("/delete-user/{id}")
//     // public String deleteUser(@PathVariable int id) {
//     //     userService.deleteById(id);
//     //     return REDIRECT_USERS;
//     // }

//     // @GetMapping("/recipes")
//     // public String getAllRecipes(Model model) {
//     //     List<Recipe> recipes = recipeService.findAll();
//     //     model.addAttribute("recipes", recipes);
//     //     return "recipelist";
//     // }

//     // @GetMapping("/create-new-recipe")
//     // public String showCreateRecipeForm(Model model) {
//     //     model.addAttribute("recipe", new Recipe());
//     //     return "create-recipe";
//     // }

//     // @PostMapping("/create-new-recipe")
//     // public String createNewRecipe(Recipe recipe) {
//     //     recipe.setId(0L);
//     //     recipeService.save(recipe);
//     //     return "redirect:/admin/recipes";
//     // }

//     // @GetMapping("/update-recipe/{id}")
//     // public String showUpdateRecipeForm(@PathVariable Long id, Model model) {
//     //     Recipe recipe = recipeService.findById(id);
//     //     model.addAttribute("recipe", recipe);
//     //     return "update-recipe";
//     // }

//     // @PostMapping("/update-recipe")
//     // public String updateRecipe(Recipe recipe) {
//     //     recipeService.save(recipe);
//     //     return "redirect:/admin/recipes";
//     // }

//     // @GetMapping("/delete-recipe/{id}")
//     // public String deleteRecipe(@PathVariable Long id) {
//     //     recipeService.deleteById(id);
//     //     return "redirect:/admin/recipes";
//     // }
// }