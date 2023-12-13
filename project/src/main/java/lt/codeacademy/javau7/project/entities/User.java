// package lt.codeacademy.javau7.project.entities;

// import java.util.List;

// import jakarta.persistence.*;

// @Entity
// @Table(name = "users")
// public class User {

//     @Id
//     @GeneratedValue(strategy = GenerationType.AUTO)
//     private int id;

//     @Column(name = "first_name", columnDefinition = "VARCHAR(255)")
// 	private String firstName;

// 	@Column(name = "last_name", columnDefinition = "VARCHAR(255)")
// 	private String lastName;

// 	@Column(name = "email", columnDefinition = "VARCHAR(255)")
// 	private String email;

// 	@Column(name = "username", columnDefinition = "VARCHAR(255)")
// 	private String username;

// 	@Column(name = "role", columnDefinition = "VARCHAR(255)")
// 	private String role;

// 	public User(){}

//     public User(String firstName, String lastName, String email, String username, String role) {
// 		this.firstName = firstName;
// 		this.lastName = lastName;
// 		this.email = email;
// 		this.username = username;
// 		this.role = role;
// 	}

// 	@ManyToMany
//     @JoinTable(
//         name = "user_recipe",
//         joinColumns = @JoinColumn(name = "user_id"),
//         inverseJoinColumns = @JoinColumn(name = "recipe_id")
//     )
	
//     private List<Recipe> recipes;

// 	public int getId() {
// 		return id;
// 	}

// 	public void setId(int id) {
// 		this.id = id;
// 	}

// 	public String getFirstName() {
// 		return firstName;
// 	}

// 	public void setFirstName(String firstName) {
// 		this.firstName = firstName;
// 	}

// 	public String getLastName() {
// 		return lastName;
// 	}

// 	public void setLastName(String lastName) {
// 		this.lastName = lastName;
// 	}

// 	public String getEmail() {
// 		return email;
// 	}

// 	public void setEmail(String email) {
// 		this.email = email;
// 	}

// 	public String getUsername() {
// 		return username;
// 	}

// 	public void setUsername(String username) {
// 		this.username = username;
// 	}

// 	public String getRole() {
// 		return role;
// 	}

// 	public void setRole(String role) {
// 		this.role = role;
// 	}

// 	public boolean hasRole(String roleName) {
//         return this.role != null && this.role.equals(roleName);
//     }
// }
