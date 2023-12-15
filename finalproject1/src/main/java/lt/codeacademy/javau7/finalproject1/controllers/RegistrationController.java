package lt.codeacademy.javau7.finalproject1.controllers;

import java.util.logging.Logger;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lt.codeacademy.javau7.finalproject1.entities.User;
import lt.codeacademy.javau7.finalproject1.entities.WebUser;
import lt.codeacademy.javau7.finalproject1.services.UserService;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class RegistrationController {

	private Logger logger = Logger.getLogger(getClass().getName());

    private UserService userService;

	public RegistrationController(UserService userService) {
		this.userService = userService;
	}

	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}	
	
	@GetMapping("/showRegistrationForm")
	public String showMyLoginPage(Model theModel) {
		
		theModel.addAttribute("webUser", new WebUser());
		
		return "register/registration-form";
	}

	@PostMapping("/processRegistrationForm")
	public String processRegistrationForm(
			@Valid @ModelAttribute("webUser") WebUser theWebUser,
			BindingResult theBindingResult,
			HttpSession session, Model theModel) {

		String userName = theWebUser.getUserName();
		logger.info("Processing registration form for: " + userName);
		
		 if (theBindingResult.hasErrors()){
			 return "register/registration-form";
		 }

        User existing = userService.findByUsername(userName);
        if (existing != null){
        	theModel.addAttribute("webUser", new WebUser());
			theModel.addAttribute("registrationError", "User name already exists.");

			logger.warning("User name already exists.");
        	return "register/registration-form";
        }
        
        userService.save(theWebUser);
        
        logger.info("Successfully created user: " + userName);

		session.setAttribute("user", theWebUser);

        return "register/registration-confirmation";
	}
}