package org.isimm.home;


import java.util.List;

import org.isimm.dao.ActualiteRepository;
import org.isimm.dao.MessageRepository;
import org.isimm.entities.Actualite;
import org.isimm.entities.Message;
import org.isimm.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class homeController {
	
	 @GetMapping("/home")
     public String home() {
		 return "home";
	}

	 @GetMapping("/departement")
     public String dep() {
		 return "departement";
	}
   
    @GetMapping(path="/presentation")
	 public String presentation() {
		    return "presentation";
		}
    @GetMapping(path="/formation")
	 public String formation() {
		    return "formation";
		}
    @GetMapping(path="/4C")
	 public String C() {
		    return "4C";
		}
    @GetMapping(path="/foyer")
	 public String foyer() {
		    return "foyer";
		}
    @GetMapping(path="/restaux")
	 public String restaux() {
		    return "restaux";
		}
    
    @GetMapping(path="/transport")
	 public String transport() {
		    return "transport";
		}
    @GetMapping(path="/clubs")
	 public String clubs() {
		    return "clubs";
		}
    @GetMapping(path="/partenaire")
	 public String partenaire() {
		    return "partenaire";
		}
    @GetMapping(path="/admin")
	 public String admin() {
		    return "admin";
		}
   @GetMapping(path="/etudiant")
	 public String etudiant() {
		    return "etudiant";
		}
   @GetMapping(path="/contactUs")
	 public String contactus(Model m) {
	   m.addAttribute("msg", new Message());
		    return "contactus";
		}
   @Autowired
   private MessageRepository messageRepository;

   @PostMapping("/submitMessage")
   public String submitMessage(@ModelAttribute Message msg) {
       messageRepository.save(msg);
       return "redirect:/home"; // Redirect to the home page
   }

   @GetMapping("/notifications")
   public String getNotifications(Model model) {
       List<Message> messages = messageRepository.findAll();
       model.addAttribute("messages", messages);
       return "notifications"; 
   }
/*********************************************************************************************************************************/
//ajout des actualités par l'admin
   @GetMapping(path="/addActualites")
	 public String addact(Model m) {
	   m.addAttribute("actualite", new Actualite());
		    return "addActualites";
		}
 @Autowired
 private ActualiteRepository actualiteRepository;

 @PostMapping("/ajoutActualites")
 public String ajoutActualites(@ModelAttribute Actualite actualite) {
     actualiteRepository.save(actualite);
     return "redirect:/admin"; // Redirect to the home page
 }
 
 /********************************************************************************************************************************/
//voir les actualités par l'etudiant

 @GetMapping("/actualites")
 public String getActualites(Model model) {
     List<Actualite> actualites = actualiteRepository.findAll();
     model.addAttribute("actualites", actualites);
     return "actualites"; 
 }
 /*********************************************************************************************************************************/
 @GetMapping(path="/deleteActualite")
 public String delete( Long id,Model model) {
	 actualiteRepository.deleteById(id)  ;  
	    return "redirect:/actualites";
	}
@GetMapping(path="/editActualite")
public String editact(Model m,Long id) {
	Actualite actualite=actualiteRepository.findById(id).get();
   m.addAttribute("actualite",actualite);
   return "addActualites";
}
}
