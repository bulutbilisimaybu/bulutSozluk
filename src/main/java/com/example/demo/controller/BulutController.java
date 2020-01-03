package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.services.UserService;

@Controller
public class BulutController {
	@Autowired
	UserRepository userrepo; 
    @Autowired
    private UserService userService;
    
    
	@GetMapping("/bulutPage")
	public ModelAndView passParametersWithModelAndView() {
		ModelAndView modelAndView = new ModelAndView("bulut");
		org.springframework.security.core.Authentication auth = SecurityContextHolder.getContext().getAuthentication(); 
       
        
        User user = userService.findUserByMail(auth.getName());
        modelAndView.addObject("userName", user.getName());
     
      
	    return modelAndView;
	}

	@GetMapping("/register")
	public String register(Model model) {
		model.addAttribute("User", new User());
		return "register";
	}
	
	@GetMapping("/wordAdd")
	public String wordAdd() {
	
		return "wordAdd";
	}
	@GetMapping("/conjuctionAdd")
	public String conjuctionAdd() {
	
		return "conjuction";
	}


	@PostMapping(value = "/register")
	public String duyuru_ekle(@Valid @ModelAttribute("User") User user, BindingResult bindingResult) {
		if (bindingResult.hasErrors())
			return "user";

		userrepo.save(user);
		return "redirect:/bulutPage";
	}

}
