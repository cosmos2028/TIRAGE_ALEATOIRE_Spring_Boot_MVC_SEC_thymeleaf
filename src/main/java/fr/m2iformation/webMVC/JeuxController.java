package fr.m2iformation.webMVC;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JeuxController 
{
	@GetMapping("/index")
	public String jeuxAleatoire() 
	{
		return "pageJeux";
	}

}
