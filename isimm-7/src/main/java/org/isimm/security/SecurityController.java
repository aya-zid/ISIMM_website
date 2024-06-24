package org.isimm.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SecurityController {
     @GetMapping("/notAuthorized")
     public String error() { 
    	 return "notAuthorized";
     }
     
     @GetMapping(path="/login")
	 public String login() {
		    return "login";
		}
     @PostMapping(path ="/login")
     public String doLogin() {
         // Handle login logic
         return "redirect:/home"; // Redirect to homepage or wherever appropriate
     }
    
     @GetMapping("/logout")
     public String logout() {
         return "logout";
     }
     @PostMapping(path ="/logout")
     public String doLogout() {
         // Handle login logic
         return "redirect:/login"; // Redirect to homepage or wherever appropriate
     }
     }
