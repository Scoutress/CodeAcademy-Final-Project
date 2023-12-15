// package lt.codeacademy.javau7.finalproject1.security;

// import java.io.IOException;

// import jakarta.servlet.ServletException;
// import jakarta.servlet.http.HttpServletRequest;
// import jakarta.servlet.http.HttpServletResponse;
// import jakarta.servlet.http.HttpSession;
// import lt.codeacademy.javau7.finalproject1.entities.User;
// import lt.codeacademy.javau7.finalproject1.services.UserService;

// import org.springframework.security.core.Authentication;
// import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
// import org.springframework.stereotype.Component;


// @Component
// public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

//     private UserService userService;

//     public CustomAuthenticationSuccessHandler(UserService theUserService) {
//         userService = theUserService;
//     }

//     @Override
//     public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
//             throws IOException, ServletException {

//         System.out.println("In customAuthenticationSuccessHandler");

//         String username = authentication.getName();

//         System.out.println("username=" + username);

//         User theUser = userService.findByUsername(username);

//         HttpSession session = request.getSession();
//         session.setAttribute("user", theUser);

//         response.sendRedirect(request.getContextPath() + "/");
//     }

// }
