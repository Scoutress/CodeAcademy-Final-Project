// package lt.codeacademy.javau7.finalproject1.backup.backupRecipes;

// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.Table;
// import lt.codeacademy.javau7.finalproject1.entities.User;

// @Entity
// @Table(name = "recipes")
// public class Recipe {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long recipeId;

//     private String title;

//     private String description;

// //     // @ManyToOne
// //     // @JdbcTypeCode(SqlTypes.JSON)
// //     // @JoinColumn(name = "user_id", nullable = false)
// //     // private User user;

// //     // @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL, orphanRemoval = true)
// //     // private Set<Ingredient> ingredients = new HashSet<>();

//     public Recipe() {}

//     public Recipe(String title, String description, User user) {
//         this.title = title;
//         this.description = description;
//     }

//     public Long getRecipeId() {
//         return recipeId;
//     }

//     public void setRecipeId(Long recipeId) {
//         this.recipeId = recipeId;
//     }

//     public String getTitle() {
//         return title;
//     }

//     public void setTitle(String title) {
//         this.title = title;
//     }

//     public String getDescription() {
//         return description;
//     }

//     public void setDescription(String description) {
//         this.description = description;
//     }

// }
