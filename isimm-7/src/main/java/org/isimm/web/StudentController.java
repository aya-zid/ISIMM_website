package org.isimm.web;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

import org.isimm.dao.AccountProjection;
import org.isimm.dao.AccountRepository;
import org.isimm.dao.ActualiteRepository;
import org.isimm.dao.EmploiIngInfo1Repository;
import org.isimm.dao.IngInfo1NotesRepository;
import org.isimm.dao.RoleRepository;
import org.isimm.dao.StudentRepository;
import org.isimm.entities.Account;
import org.isimm.entities.Actualite;
import org.isimm.entities.EmploiIngInfo1;
import org.isimm.entities.Inginfo1Notes;
import org.isimm.entities.Message;
import org.isimm.entities.Student;
import org.isimm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
@Controller
public class StudentController {
	@Autowired
	private StudentRepository studentDao;
	 @Autowired
		private IngInfo1NotesRepository inginfo1Dao;
	 
	@GetMapping(path="/students")
	public String search(Model model ,
			             @RequestParam(name="page",defaultValue="0")int page,
			             @RequestParam(name="size",defaultValue="8") int size,
			             @RequestParam(name="key1",defaultValue="") String mc1,
			             @RequestParam(name="key2",defaultValue="") String mc2,
			             @RequestParam(name="key3",defaultValue="0") Long mc3
			             ) {
		 Page<Student> students;
	
		if (mc1.isEmpty() && mc2.isEmpty() && mc3 == 0) {
	        // No search parameters provided, get all students
	        students = studentDao.findAll(PageRequest.of(page, size));
	    } else 
  {students= studentDao.findByCycleAndSpecialiteAndNiveauEtude(mc1,mc2,mc3, PageRequest.of(page, size));} 
	model.addAttribute("students",students.getContent()); 
	model.addAttribute("pages",new int[students.getTotalPages()]);
	model.addAttribute("currentPage", page); 
	model.addAttribute("key1", mc1);
	model.addAttribute("key2", mc2);
	model.addAttribute("key3", mc3);
	    
	return "mystudents"; 
	}
	
	 @GetMapping(path="/searchStudent")
	 public String findStudentById(@RequestParam(name="mc",defaultValue="0") Long mc, Model model) {
		            Student foundStudent = studentDao.findById(mc).orElse(null);       
		            model.addAttribute("foundStudent", foundStudent);
		            model.addAttribute("CIN", mc);
		    return "studentbyid";
		}
	 @GetMapping(path="/deleteStudent")
	 public String delete( Long id,Model model ,
             @RequestParam(name="page",defaultValue="0")int page,
             @RequestParam(name="size",defaultValue="8") int size,
             @RequestParam(name="key1",defaultValue="") String mc1,
             @RequestParam(name="key2",defaultValue="") String mc2,
             @RequestParam(name="key3",defaultValue="0") Long mc3) {
		    studentDao.deleteById(id)  ;  
		    //return search(model,page,size,mc1,mc2,mc3);
		   return "redirect:/students?page="+page+"&key1="+mc1+"&key2="+mc2+"&key3="+mc3;
		}
	
    @GetMapping(path="/addStudent")
    public String addstudent(Model m) {
       m.addAttribute("student", new Student());
        return "addstudent";
    }
    @GetMapping(path="/editStudent")
    public String editstudent(Model m,Long id) {
    	Student s=studentDao.findById(id).get();
       m.addAttribute("student",s);
        return "addstudent";
    }
    @GetMapping(path="/infoStudent")
    public String infostudent(Model m,Long id) {
    	Student s=studentDao.findById(id).get();
       m.addAttribute("Student",s);
        return "studentinfo";
    }
    @PostMapping(path="/saveStudent")
    public String saveStudent(@Validated Student student,BindingResult br) {
    	if (br.hasErrors()) return "addstudent";
    	studentDao.save(student);
    	return "redirect:/admin";
    }
   
    
    
    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        return "createaccount";
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam("username") String username,
                               @RequestParam("password") String password,
                               @RequestParam("CIN") Long cin) {
        userService.registerUser(cin, username, password);
        return "redirect:/admin";
    }
   
   
    
    @GetMapping("/profile")
    public String showProfile(Model model) {
        // Get currently authenticated user's username
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        Account account = accountRepository.findByUsername(username);
        // Retrieve student information from the database using username (assuming it's CIN)
        Student s=studentDao.findById(account.getCIN()).get();
       
   
        model.addAttribute("Student", s);

        return "studentinfo";
    }
    @GetMapping("/mesnotes")
    public String mynotes(Model model) {
    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        Account account = accountRepository.findByUsername(username);
        Student s = studentDao.findById(account.getCIN()).get();
        
        // Check if student is ing info 1
        List<Student>students=studentDao.findByCycleAndSpecialiteAndNiveauEtude("Ingénieurs","ingénieur informatique",(long) 1);
    	boolean found=false;
    	for(Student ss:students) {
    		if (ss.getCIN().equals(s.getCIN()))found=true;
    	}
        if (found) {
        Optional<Inginfo1Notes> optionalNotes = inginfo1Dao.findById(account.getCIN());
        
        // Check if the optionalNotes contains a value
        if (optionalNotes.isPresent()) {
            Inginfo1Notes sa = optionalNotes.get();
            model.addAttribute("notes", sa);
        } else {
            // If no notes found, provide a default or handle the case appropriately
            Inginfo1Notes emptyNotes = new Inginfo1Notes(); // You can provide a default instance or null
            model.addAttribute("notes", emptyNotes);}
        return "mynoteinginfo1"; }
        /* we just tried the ing info 1 here but u can keep doing else if for all the other sections , here's an example of how u can do the otheres :
         List<Student>students_ing_info_2=studentDao.findByCycleAndSpecialiteAndNiveauEtude("Ingénieurs","ingénieur informatique",(long) 2);
         boolean found2=false;
    	for(Student ss:students_ing_info_2) {
    		if (ss.getCIN().equals(s.getCIN()))found2=true;}
     //this code should be added in line 159 and now we can do the else if (if the student isn't ing info 1 so let's if it's ing info 2
      else if (found2) {
      Optional<Inginfo2Notes> optionalNotes = inginfo2Dao.findById(account.getCIN());
        
        // Check if the optionalNotes contains a value
        if (optionalNotes.isPresent()) {
            Inginfo2Notes sa = optiona2Notes.get();
            model.addAttribute("notes", sa);
        } else {
            // If no notes found, provide a default or handle the case appropriately
            Inginfo2Notes emptyNotes = new Inginfo2Notes(); // You can provide a default instance or null
            model.addAttribute("notes", emptyNotes);}
        return "mynoteinginfo2"; }
    	}
    	
    	and of course we should be creating entity , repository and view (html file ) for each section 
         */
        else 
        	return "Notesnotready";
    }
    @GetMapping("/emploidetemps")
    public String myemploi(Model model) {
    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        Account account = accountRepository.findByUsername(username);
        Student s = studentDao.findById(account.getCIN()).get();
        // i just made an example of ing info 1 but it's same the code we can do with if else like i explained in my notes for all the other sections
        // Check if student is ing info 1
        List<Student>students=studentDao.findByCycleAndSpecialiteAndNiveauEtude("Ingénieurs","ingénieur informatique",(long) 1);
    	boolean found=false;
    	for(Student ss:students) {
    		if (ss.getCIN().equals(s.getCIN()))found=true;
    	}
        if (found) {
        	EmploiIngInfo1 existingEmploi = emploiinginfo1Dao.findById(1L).orElse(new EmploiIngInfo1());
           model.addAttribute("emploi",existingEmploi );
           return "Emploininginfo1Student";
        } else {
            
        return "erroremploi"; 
    }}
    @Autowired
    private AccountRepository accountRepository;
    @GetMapping(path="/accounts")
	public String accounts(Model model ,
			             @RequestParam(name="page",defaultValue="0")int page,
			             @RequestParam(name="size",defaultValue="8") int size,
			             @RequestParam(name="key1",defaultValue="") String mc
			             ) {
		 Page<AccountProjection> accounts;
		if (mc.isEmpty()) {
	        // No search parameters provided, get all students
			accounts = accountRepository.findAllProjectedBy(PageRequest.of(page, size));
	    } else 
  { accounts = accountRepository.findByUsername(mc, PageRequest.of(page, size));} 
	model.addAttribute("accounts",accounts.getContent()); 
	model.addAttribute("pages",new int[accounts.getTotalPages()]);
	model.addAttribute("currentPage", page); 
	model.addAttribute("key1", mc);
	    
	return "accounts"; 
	}
    @Autowired
    RoleRepository roleRepository;
    @Transactional
    @GetMapping(path="/deleteAccount")
	 public String deleteAccount( Long id,Model model ,
            @RequestParam(name="page",defaultValue="0")int page,
            @RequestParam(name="size",defaultValue="8") int size,
            @RequestParam(name="key1",defaultValue="") String mc) {
    	/*Optional<Account> accountOptional = accountRepository.findById(id);
        if (accountOptional.isPresent()) {
            Account account = accountOptional.get();
            String username = account.getUsername();*/
            roleRepository.deleteById(id);
            accountRepository.deleteById(id);
      //  }
		   return "redirect:/accounts?page="+page+"&key1="+mc;
		}
    @GetMapping(path="/editAccount")
    public String editAccount(Model m,Long id) {
    	Account a=accountRepository.findById(id).get();
       m.addAttribute("account",a);
        return "editaccount";
    }
    @Transactional
    @PostMapping(path="/editAccount")
    public String editAccountS(@RequestParam("username") String username,
                               @RequestParam("password") String password,
                               @RequestParam("CIN") Long cin) {
    	roleRepository.deleteById(cin);
        accountRepository.deleteById(cin);
        userService.registerUser(cin, username, password);
        return "redirect:/admin";
    }
   
    @GetMapping(path="/addmarks")
    public String addmarkspage(Model m) {return "ajoutnote";}
    @PostMapping(path="/ajoutnotes")
	public String searchclass(Model model ,
			             @RequestParam(name="key1",defaultValue="") String mc1,
			             @RequestParam(name="key2",defaultValue="") String mc2,
			             @RequestParam(name="key3",defaultValue="0") Long mc3
			             ) {
		
		if (mc1.equals("Ingénieurs")&& mc2.equals("ingénieur informatique") && mc3==1) 
                 {return "redirect:/inginfo1"; }
		/*else if (mc1.equals("Ingénieurs")&& mc2.equals("ingénieur informatique") && mc3==2) 
                 {return "inginfo2"; }
		else if (mc1.equals("Ingénieurs")&& mc2.equals("ingénieur informatique") && mc3==3) 
                 {return "inginfo3"; } 
		else if (mc1.equals("Ingénieurs")&& mc2.equals("ingénieur électronique et microélectronique") && mc3==1) 
                {return "ingelect1"; }
		else if (mc1.equals("Ingénieurs")&& mc2.equals("ingénieur électronique et microélectronique") && mc3==2) 
                {return "ingelect2"; }
		else if (mc1.equals("Ingénieurs")&& mc2.equals("ingénieur électronique et microélectronique") && mc3==3) 
                 {return "ingelect3"; }
		else if (mc1.equals("Licence")&& (mc2.equals("licence EEA : systèmes embarqués") || mc2.equals("licence EEA : mesure instrumentation et métrologie")) && mc3==1) 
                 {return "EEA1"; }
		else if (mc1.equals("Licence")&& mc2.equals("licence EEA : systèmes embarqués") && mc3==2) 
                 {return "SE2"; }
		else if (mc1.equals("Licence")&& mc2.equals("licence EEA : systèmes embarqués") && mc3==3) 
                 {return "SE3"; }
		else if (mc1.equals("Licence")&& mc2.equals("licence EEA : mesure instrumentation et métrologie") && mc3==2) 
                 {return "MIM2"; }
        else if (mc1.equals("Licence")&& mc2.equals("licence EEA : mesure instrumentation et métrologie") && mc3==3) 
                 {return "MIM3"; }
        else if (mc1.equals("Licence")&& mc2.equals("licence en mathematiques appliquées") && mc3==1) 
                 {return "math1"; }
        else if (mc1.equals("Licence")&& mc2.equals("licence en mathematiques appliquées") && mc3==2) 
                 {return "math2"; }
        else if (mc1.equals("Licence")&& mc2.equals("licence en mathematiques appliquées") && mc3==3) 
                 {return "math3"; }
        else if (mc1.equals("Licence")&& mc2.equals("licence en sciences de l'informatique") && mc3==1) 
                {return "info1"; }
        else if (mc1.equals("Licence")&& mc2.equals("licence en sciences de l'informatique") && mc3==2) 
                {return "info2"; }
        else if (mc1.equals("Licence")&& mc2.equals("licence en sciences de l'informatique") && mc3==3) 
                {return "info3"; }*/
		else {return "redirect:/addmarks";}
		
    }
    @GetMapping(path="/inginfo1")
    public String ingoinfo1(Model m) {
    	return "inginfo1";}
    @PostMapping(path="/inginfo1notes")
    public String ingoinfo1notes(Model model ,RedirectAttributes redirectAttributes,
    		@RequestParam(name = "CIN",defaultValue="0") Long cin,
            @RequestParam(name = "anadonor", defaultValue = "-1.0") Float anadonor,
            @RequestParam(name = "anadonds", defaultValue = "-1.0") Float anadonds,
            @RequestParam(name = "anadontp", defaultValue = "-1.0") Float anadontp,
            @RequestParam(name = "anadonex", defaultValue = "-1.0") Float anadonex,
            @RequestParam(name = "neuronor", defaultValue = "-1.0") Float neuronor,
            @RequestParam(name = "neuronds", defaultValue = "-1.0") Float neuronds,
            @RequestParam(name = "neurontp", defaultValue = "-1.0") Float neurontp,
            @RequestParam(name = "neuronex", defaultValue = "-1.0") Float neuronex,
            @RequestParam(name = "pyor", defaultValue = "-1.0") Float pyor,
            @RequestParam(name = "pyds", defaultValue = "-1.0") Float pyds,
            @RequestParam(name = "pytp", defaultValue = "-1.0") Float pytp,
            @RequestParam(name = "pyex", defaultValue = "-1.0") Float pyex,
            @RequestParam(name = "lexor", defaultValue = "-1.0") Float lexor,
            @RequestParam(name = "lexds", defaultValue = "-1.0") Float lexds,
            @RequestParam(name = "lextp", defaultValue = "-1.0") Float lextp,
            @RequestParam(name = "lexex", defaultValue = "-1.0") Float lexex,
            @RequestParam(name = "entor", defaultValue = "-1.0") Float entor,
            @RequestParam(name = "entds", defaultValue = "-1.0") Float entds,
            @RequestParam(name = "enttp", defaultValue = "-1.0") Float enttp,
            @RequestParam(name = "entex", defaultValue = "-1.0") Float entex,
            @RequestParam(name = "umlor", defaultValue = "-1.0") Float umlor,
            @RequestParam(name = "umlds", defaultValue = "-1.0") Float umlds,
            @RequestParam(name = "umltp", defaultValue = "-1.0") Float umltp,
            @RequestParam(name = "umlex", defaultValue = "-1.0") Float umlex,
            @RequestParam(name = "webor", defaultValue = "-1.0") Float webor,
            @RequestParam(name = "webds", defaultValue = "-1.0") Float webds,
            @RequestParam(name = "webtp", defaultValue = "-1.0") Float webtp,
            @RequestParam(name = "webex", defaultValue = "-1.0") Float webex,
            @RequestParam(name = "mobor", defaultValue = "-1.0") Float mobor,
            @RequestParam(name = "mobds", defaultValue = "-1.0") Float mobds,
            @RequestParam(name = "mobtp", defaultValue = "-1.0") Float mobtp,
            @RequestParam(name = "mobex", defaultValue = "-1.0") Float mobex,
            @RequestParam(name = "pr_webmobor", defaultValue = "-1.0") Float pr_webmobor,
            @RequestParam(name = "pr_webmobds", defaultValue = "-1.0") Float pr_webmobds,
            @RequestParam(name = "pr_webmobtp", defaultValue = "-1.0") Float pr_webmobtp,
            @RequestParam(name = "pr_webmobex", defaultValue = "-1.0") Float pr_webmobex,
            @RequestParam(name = "ang1or", defaultValue = "-1.0") Float ang1or,
            @RequestParam(name = "ang1ds", defaultValue = "-1.0") Float ang1ds,
            @RequestParam(name = "ang1tp", defaultValue = "-1.0") Float ang1tp,
            @RequestParam(name = "ang1ex", defaultValue = "-1.0") Float ang1ex,
            @RequestParam(name = "fr1or", defaultValue = "-1.0") Float fr1or,
            @RequestParam(name = "fr1ds", defaultValue = "-1.0") Float fr1ds,
            @RequestParam(name = "fr1tp", defaultValue = "-1.0") Float fr1tp,
            @RequestParam(name = "fr1ex", defaultValue = "-1.0") Float fr1ex,
            @RequestParam(name = "techcom1or", defaultValue = "-1.0") Float techcom1or,
            @RequestParam(name = "techcom1ds", defaultValue = "-1.0") Float techcom1ds,
            @RequestParam(name = "techcom1tp", defaultValue = "-1.0") Float techcom1tp,
            @RequestParam(name = "techcom1ex", defaultValue = "-1.0") Float techcom1ex,
            @RequestParam(name = "stockor", defaultValue = "-1.0") Float stockor,
            @RequestParam(name = "stockds", defaultValue = "-1.0") Float stockds,
            @RequestParam(name = "stocktp", defaultValue = "-1.0") Float stocktp,
            @RequestParam(name = "stockex", defaultValue = "-1.0") Float stockex,
            @RequestParam(name = "optor", defaultValue = "-1.0") Float optor,
            @RequestParam(name = "optds", defaultValue = "-1.0") Float optds,
            @RequestParam(name = "opttp", defaultValue = "-1.0") Float opttp,
            @RequestParam(name = "optex", defaultValue = "-1.0") Float optex,
            @RequestParam(name = "concor", defaultValue = "-1.0") Float concor,
            @RequestParam(name = "concds", defaultValue = "-1.0") Float concds,
            @RequestParam(name = "conctp", defaultValue = "-1.0") Float conctp,
            @RequestParam(name = "concex", defaultValue = "-1.0") Float concex,
            @RequestParam(name = "framacor", defaultValue = "-1.0") Float framacor,
            @RequestParam(name = "framacds", defaultValue = "-1.0") Float framacds,
            @RequestParam(name = "framactp", defaultValue = "-1.0") Float framactp,
            @RequestParam(name = "framacex", defaultValue = "-1.0") Float framacex,
            @RequestParam(name = "prSIor", defaultValue = "-1.0") Float prSIor,
            @RequestParam(name = "prSIds", defaultValue = "-1.0") Float prSIds,
            @RequestParam(name = "prSItP", defaultValue = "-1.0") Float prSItP,
            @RequestParam(name = "prSIex", defaultValue = "-1.0") Float prSIex,
            @RequestParam(name = "interoor", defaultValue = "-1.0") Float interoor,
            @RequestParam(name = "interods", defaultValue = "-1.0") Float interods,
            @RequestParam(name = "interotp", defaultValue = "-1.0") Float interotp,
            @RequestParam(name = "interoex", defaultValue = "-1.0") Float interoex,
            @RequestParam(name = "fondIAor", defaultValue = "-1.0") Float fondIAor,
            @RequestParam(name = "fondIAds", defaultValue = "-1.0") Float fondIAds,
            @RequestParam(name = "fondIAtP", defaultValue = "-1.0") Float fondIAtP,
            @RequestParam(name = "fondIAex", defaultValue = "-1.0") Float fondIAex,
            @RequestParam(name = "fr2or", defaultValue = "-1.0") Float fr2or,
            @RequestParam(name = "fr2ds", defaultValue = "-1.0") Float fr2ds,
            @RequestParam(name = "fr2tp", defaultValue = "-1.0") Float fr2tp,
            @RequestParam(name = "fr2ex", defaultValue = "-1.0") Float fr2ex,
            @RequestParam(name = "ang2or", defaultValue = "-1.0") Float ang2or,
            @RequestParam(name = "ang2ds", defaultValue = "-1.0") Float ang2ds,
            @RequestParam(name = "ang2tp", defaultValue = "-1.0") Float ang2tp,
            @RequestParam(name = "ang2ex", defaultValue = "-1.0") Float ang2ex,
            @RequestParam(name = "techcomm2or", defaultValue = "-1.0") Float techcomm2or,
            @RequestParam(name = "techcomm2ds", defaultValue = "-1.0") Float techcomm2ds,
            @RequestParam(name = "techcomm2tp", defaultValue = "-1.0") Float techcomm2tp,
            @RequestParam(name = "techcomm2ex", defaultValue = "-1.0") Float techcomm2ex,
            @RequestParam(name = "mlor", defaultValue = "-1.0") Float mlor,
            @RequestParam(name = "mlds", defaultValue = "-1.0") Float mlds,
            @RequestParam(name = "mltp", defaultValue = "-1.0") Float mltp,
            @RequestParam(name = "mlex", defaultValue = "-1.0") Float mlex) {
    	boolean foundinall=false;
    	List<Student>studentsall=studentDao.findAll();
    	System.out.println("mycin: "+cin+"aaa");
    	for(Student s:studentsall) {
    		System.out.println(s.getCIN());
    		if (s.getCIN().equals(cin))foundinall=true;
    	}
    	if(foundinall) {
    	List<Student>students=studentDao.findByCycleAndSpecialiteAndNiveauEtude("Ingénieurs","ingénieur informatique",(long) 1);
    	boolean found=false;
    	for(Student s:students) {
    		if (s.getCIN().equals(cin))found=true;
    	}
    	//if student is fr ingenenieur info 1
    	if(found) {
    		//check if student already been saved with some notes
    		Inginfo1Notes n= inginfo1Dao.findById(cin).orElse(null);
    		if(n==null) {
    			inginfo1Dao.save(new Inginfo1Notes(cin,neuronor,neurontp,neuronds,neuronex,mobor,mobtp,mobds,mobex,entor,enttp,entds,entex,
    					                            umlor,umltp,umlds,umlex,webor,webtp,webds,webex,pyor,pytp,pyds,pyex,anadonor,anadontp,anadonds,
    					                            anadonex,lexor,lextp,lexds,lexex,ang1or,ang1tp,ang1ds,ang1ex,fr1or,fr1tp,fr1ds,fr1ex,
    					                            techcom1or,techcom1tp,techcom1ds,techcom1ex,stockor,stocktp,stockds,stockex,framacor,
    					                            framactp,framacds,framacex,mlor,mltp,mlds,mlex,fondIAor,fondIAtP,fondIAds,fondIAex,
    					                            optor,opttp,optds,optex,concor,conctp,concds,concex,interoor,interotp,interods,interoex,
    					                            ang2or,ang2tp,ang2ds,ang2ex,fr2or,fr2tp,fr2ds,fr2ex,techcomm2or,techcomm2tp,techcomm2ds,techcomm2ex,
    					                            pr_webmobor,pr_webmobtp,pr_webmobds,pr_webmobex,prSIor,prSItP,prSIds,prSIex));
    	        return "redirect:/admin";
    	     }
    		else {
    			if(neuronor>=0)n.setMathNeurOral(neuronor);
    			if(neurontp>=0)n.setMathNeurTP(neurontp);
    			if(neuronds>=0)n.setMathNeurDS(neuronds);
    		    if (neuronex >= 0) n.setMathNeurExam(mlex);
    		    if (mobor >= 0) n.setProgmobileOral(mobor);
    		    if (mobtp >= 0) n.setProgmobileTP(mobtp);
    		    if (mobds >= 0) n.setProgmobileDS(mobds);
    		    if (mobex >= 0) n.setProgmobileExam(mobex);
    		    if (entor >= 0) n.setJavaCardOral(entor);
    		    if (enttp >= 0) n.setJavaCardTP(enttp);
    		    if (entds >= 0) n.setJavaCardDS(entds);
    		    if (entex >= 0) n.setJavaCardExam(entex);
    		    if (umlor >= 0) n.setUMLOral(umlor);
    		    if (umltp >= 0) n.setUMLTP(umltp);
    		    if (umlds >= 0) n.setUMLDS(umlds);
    		    if (umlex >= 0) n.setUMLExam(umlex);
    		    if (webor >= 0) n.setProgWebeOral(webor);
    		    if (webtp >= 0) n.setProgWebTP(webtp);
    		    if (webds >= 0) n.setProgWebDS(webds);
    		    if (webex >= 0) n.setProgWebExam(webex);
    		    if (pyor >= 0) n.setPythonOral(pyor);
    		    if (pytp >= 0) n.setPythonTP(pytp);
    		    if (pyds >= 0) n.setPythonDS(pyds);
    		    if (pyex >= 0) n.setPythonExam(pyex);
    		    if (anadonor >= 0) n.setAnalyseDataOral(anadonor);
    		    if (anadontp >= 0) n.setAnalyseDataTP(anadontp);
    		    if (anadonds >= 0) n.setAnalyseDataDS(anadonds);
    		    if (anadonex >= 0) n.setAnalyseDataExam(anadonex);
    		    if (lexor >= 0) n.setLexicoOral(lexor);
    		    if (lextp >= 0) n.setLexicoTP(lextp);
    		    if (lexds >= 0) n.setLexicoDS(lexds);
    		    if (lexex >= 0) n.setLexicoExam(lexex);
    		    if (ang1or >= 0) n.setEnglish1Oral(ang1or);
    		    if (ang1tp >= 0) n.setEnglish1TP(ang1tp);
    		    if (ang1ds >= 0) n.setEnglish1DS(ang1ds);
    		    if (ang1ex >= 0) n.setEnglish1Exam(ang1ex);
    		    if (fr1or >= 0) n.setFrench1Oral(fr1or);
    		    if (fr1tp >= 0) n.setFrench1TP(fr1tp);
    		    if (fr1ds >= 0) n.setFrench1DS(fr1ds);
    		    if (fr1ex >= 0) n.setFrench1Exam(fr1ex);
    		    if (techcom1or >= 0) n.setCommunic1Oral(techcom1or);
    		    if (techcom1tp >= 0) n.setCommunic1TP(techcom1tp);
    		    if (techcom1ds >= 0) n.setCommunic1DS(techcom1ds);
    		    if (techcom1ex >= 0) n.setCommunic1Exam(techcom1ex);
    		    if (stockor >= 0) n.setStochaOral(stockor);
    		    if (stocktp >= 0) n.setStochaTP(stocktp);
    		    if (stockds >= 0) n.setStochaDS(stockds);
    		    if (stockex >= 0) n.setStochaExam(stockex);
    		    if (framacor >= 0) n.setFramaOral(framacor);
    		    if (framactp >= 0) n.setFramaTP(framactp);
    		    if (framacds >= 0) n.setFramaDS(framacds);
    		    if (framacex >= 0) n.setFramaExam(framacex);
    		    if (mlor >= 0) n.setMLOral(mlor);
    		    if (mltp >= 0) n.setMLTP(mltp);
    		    if (mlds >= 0) n.setMLDS(mlds);
    		    if (mlex >= 0) n.setMLExam(mlex);
    		    if (fondIAor >= 0) n.setAIOral(fondIAor);
    		    if (fondIAtP >= 0) n.setAITP(fondIAtP);
    		    if (fondIAds >= 0) n.setAIDS(fondIAds);
    		    if (fondIAex >= 0) n.setAIExam(fondIAex);
    		    if (optor >= 0) n.setOptimOral(optor);
    		    if (opttp >= 0) n.setOptimTP(opttp);
    		    if (optds >= 0) n.setOptimDS(optds);
    		    if (optex >= 0) n.setOptimExam(optex);
    		    if (concor >= 0) n.setConceptionOral(concor);
    		    if (conctp >= 0) n.setConceptionTP(conctp);
    		    if (concds >= 0) n.setConceptionDS(concds);
    		    if (concex >= 0) n.setConceptionExam(concex);
    		    if (interoor >= 0) n.setSIOral(interoor);
    		    if (interotp >= 0) n.setSITP(interotp);
    		    if (interods >= 0) n.setSIDS(interods);
    		    if (interoex >= 0) n.setSIExam(interoex);
    		    if (ang2or >= 0) n.setEnglish2Oral(ang2or);
    		    if (ang2tp >= 0) n.setEnglish2TP(ang2tp);
    		    if (ang2ds >= 0) n.setEnglish2DS(ang2ds);
    		    if (ang2ex >= 0) n.setEnglish2Exam(ang2ex);
    		    if (fr2or >= 0) n.setFrench2Oral(fr2or);
    		    if (fr2tp >= 0) n.setFrench2TP(fr2tp);
    		    if (fr2ds >= 0) n.setFrench2DS(fr2ds);
    		    if (fr2ex >= 0) n.setFrench2Exam(fr2ex);
    		    if (techcomm2or >= 0) n.setCommunic2Oral(techcomm2or);
    		    if (techcomm2tp >= 0) n.setCommunic2TP(techcomm2tp);
    		    if (techcomm2ds >= 0) n.setCommunic2DS(techcomm2ds);
    		    if (techcomm2ex >= 0) n.setCommunic2Exam(techcomm2ex);
    		    if (pr_webmobor >= 0) n.setProjetWebOral(pr_webmobor);
    		    if (pr_webmobtp >= 0) n.setProjetWebTP(pr_webmobtp);
    		    if (pr_webmobds >= 0) n.setProjetWebDS(pr_webmobds);
    		    if (pr_webmobex >= 0) n.setProjetWebExam(pr_webmobex);
    		    if (prSIor >= 0) n.setProjetSIOral(prSIor);
    		    if (prSItP >= 0) n.setProjetSITP(prSItP);
    		    if (prSIds >= 0) n.setProjetSIDS(prSIds);
    		    if (prSIex >= 0) n.setProjetSIExam(prSIex);
    		    inginfo1Dao.save(n);
    		    return "redirect:/admin";
    		}
    	
    		
    	} else {
    		//model.addAttribute("errorMessage", "cet etudiant n'appartient pas à cette classe");
    		redirectAttributes.addFlashAttribute("errorMessage", "cet etudiant n'appartient pas à cette classe");
    	return "redirect:/inginfo1"; }

    	}
    	else
    	{redirectAttributes.addFlashAttribute("errorMessage", "Wrong CIN ");
    	return "redirect:/inginfo1"; }
    	}
    @Autowired
    EmploiIngInfo1Repository emploiinginfo1Dao;
    
    @GetMapping(path="/addemploi")
    public String addemploiall(Model m) {return "ajouremplois";}
    
    @PostMapping(path="/addemploi")
	 public String addemploi(Model model ,
		        @RequestParam(name="key1",defaultValue="") String mc1,
		        @RequestParam(name="key2",defaultValue="") String mc2,
		        @RequestParam(name="key3",defaultValue="0") Long mc3
		        ) {
    	 

          if (mc1.equals("Ingénieurs")&& mc2.equals("ingénieur informatique") && mc3==1) 
                  {return "redirect:/ajoutemploiinginfo1"; }
          else {return "redirect:/addemploi";}

		}
    
    
    @GetMapping(path="/ajoutemploiinginfo1")
	 public String addemploiing(Model m) {
	   m.addAttribute("emploi_temps_admin", new EmploiIngInfo1());
		    return "emploiinginfo1admin";
		}

    @PostMapping("/ajoutemploiinginfo1")
    public String ajoutEmploi(@ModelAttribute EmploiIngInfo1 emploi_temps_admin) {
    	EmploiIngInfo1 existingEmploi = emploiinginfo1Dao.findById(1L).orElse(new EmploiIngInfo1());

        // Update fields
        existingEmploi.setLundi1(emploi_temps_admin.getLundi1());
        existingEmploi.setLundi2(emploi_temps_admin.getLundi2());
        existingEmploi.setLundi3(emploi_temps_admin.getLundi3());
        existingEmploi.setLundi4(emploi_temps_admin.getLundi4());
        existingEmploi.setLundi5(emploi_temps_admin.getLundi5());

        existingEmploi.setMardi1(emploi_temps_admin.getMardi1());
        existingEmploi.setMardi2(emploi_temps_admin.getMardi2());
        existingEmploi.setMardi3(emploi_temps_admin.getMardi3());
        existingEmploi.setMardi4(emploi_temps_admin.getMardi4());
        existingEmploi.setMardi5(emploi_temps_admin.getMardi5());

        existingEmploi.setMercredi1(emploi_temps_admin.getMercredi1());
        existingEmploi.setMercredi2(emploi_temps_admin.getMercredi2());
        existingEmploi.setMercredi3(emploi_temps_admin.getMercredi3());
        existingEmploi.setMercredi4(emploi_temps_admin.getMercredi4());
        existingEmploi.setMercredi5(emploi_temps_admin.getMercredi5());

        existingEmploi.setJeudi1(emploi_temps_admin.getJeudi1());
        existingEmploi.setJeudi2(emploi_temps_admin.getJeudi2());
        existingEmploi.setJeudi3(emploi_temps_admin.getJeudi3());
        existingEmploi.setJeudi4(emploi_temps_admin.getJeudi4());
        existingEmploi.setJeudi5(emploi_temps_admin.getJeudi5());

        existingEmploi.setVendredi1(emploi_temps_admin.getVendredi1());
        existingEmploi.setVendredi2(emploi_temps_admin.getVendredi2());
        existingEmploi.setVendredi3(emploi_temps_admin.getVendredi3());
        existingEmploi.setVendredi4(emploi_temps_admin.getVendredi4());
        existingEmploi.setVendredi5(emploi_temps_admin.getVendredi5());

        existingEmploi.setSamedi1(emploi_temps_admin.getSamedi1());
        existingEmploi.setSamedi2(emploi_temps_admin.getSamedi2());
        existingEmploi.setSamedi3(emploi_temps_admin.getSamedi3());
        existingEmploi.setSamedi4(emploi_temps_admin.getSamedi4());
        existingEmploi.setSamedi5(emploi_temps_admin.getSamedi5());

        // Save the updated record
        emploiinginfo1Dao.save(existingEmploi);
            return "redirect:/admin"; // Redirect to the home page
}
}
