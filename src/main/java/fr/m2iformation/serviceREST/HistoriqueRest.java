package fr.m2iformation.serviceREST;

import java.time.LocalDateTime;

import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import fr.m2iformation.entities.Historique;
import fr.m2iformation.metier.IHistoriqueMetier;
import lombok.AllArgsConstructor;

/*
 * @RequestBody permet d'indiquer à Spring de recuperer le contenu dans le corps
 * de la requete et aussi que c'est au format json pour désérialization
 * 
 * @ResponseBody permet de retourner la reponse au client la reponse au format
 * JSON en effectuant une serialization mais pas oblige de le preciser car il est implicite
 * 
 * 
 * @Autowired permet d'injecter l'implementation de l'interface désignée
 */
@RestController @AllArgsConstructor
public class HistoriqueRest
{
	

	private IHistoriqueMetier historiqueMetier;
	@ResponseBody
	@PostMapping(value="/jeux_historiqe")
	public  Historique saveHistorique(HttpEntity<String> httpEntity) throws JsonMappingException, JsonProcessingException
	{
		//recuperer l'objet json de la requete
		String json = httpEntity.getBody();
		//mapper de string à json
		ObjectMapper mapper = new ObjectMapper();
	    JsonNode actualObj = mapper.readTree(json);
	    //creation l'objet historique
		Historique historique = new Historique();
		//verifier si on tous les choix
		if ((actualObj.get("choix1"))!=null && (actualObj.get("choix2")!=null) && (actualObj.get("choix3")!=null)) 
		{
			historique.setChoix1(actualObj.get("choix1").asInt());
			historique.setChoix2(actualObj.get("choix2").asInt());
			historique.setChoix3(actualObj.get("choix3").asInt());
		}else if((actualObj.get("choix1")!=null) && (actualObj.get("choix2") ==null))
		{
			historique.setChoix1(actualObj.get("choix1").asInt());
		}else if((actualObj.get("choix1")!=null) && (actualObj.get("choix2")!=null)&& (actualObj.get("choix3") ==null))
		{
			historique.setChoix1(actualObj.get("choix1").asInt());
			historique.setChoix2(actualObj.get("choix2").asInt());
		}
		
		//génerer la date et heure
		/*
		LocalDateTime now = LocalDateTime.now();  
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");  
        LocalDateTime dateTime = LocalDateTime.parse(now.format(format));
        */
		historique.setDateTimeTirage( LocalDateTime.now());
		historique.setNombre_a_trouver(actualObj.get("v_nbAleatoire").asInt());
		historique.setTrouver(actualObj.get("v_trouver").asBoolean());
		
		return historiqueMetier.saveHistorique(historique);
	
	}
	
	
	/*
	 * pour retourner une page html au lieu de JSON 
	
	ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("pageHistorique.html");
    return modelAndView;
   
	public ModelAndView welcome() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login.html");
        return modelAndView;
    } 
	  */
	
}

