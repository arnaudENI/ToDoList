package fr.eni.mvc.controller;


import java.util.logging.Logger;

import javax.annotation.Resource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import fr.eni.mvc.bean.Utilisateur;
import fr.eni.mvc.service.GestionUtilisateur;

import java.util.List;

@Controller
@SessionAttributes({"pers"})
public class UtilisateurController {
	
	private static Logger log = Logger.getLogger(UtilisateurController.class.getName());

	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classPath*:dispatcher-servlet.xml");
	GestionUtilisateur gu = context.getBean("gestionUtilisateur", GestionUtilisateur.class);
	
	
   @Resource(name = "ut1")
   Utilisateur ut1;
   
 
 
 
   @RequestMapping(method = RequestMethod.GET,path="/connect")
   public ModelAndView appelConnexion(){
       log.info("[redirection vers page connexion]");
       ModelAndView mav = new ModelAndView();
       if(gu.listeUtilisateur().isEmpty()) {
    	   mav.addObject("pers", "Pas d'utlisateur en base");
           mav.setViewName("register");
       }else {
    	   Utilisateur uc = new Utilisateur();
    	   mav.addObject("pers",uc);
    	   mav.setViewName("connect");
       }
       
       return mav;
   }
   
   
   
    @RequestMapping(method=RequestMethod.POST, path="/connect")
    public ModelAndView utilisateurConnect(@ModelAttribute("pers") Utilisateur u){
    	
    	 ModelAndView mav = new ModelAndView();
    	 log.info("["+u.getIdentifiant()+" - "+u.getMdp()+"]");
        if(u.getIdentifiant().equals(ut1.getIdentifiant()) && u.getMdp().equals(ut1.getMdp())){
             mav.addObject("pers", u);
             mav.setViewName("listeTaches");
         
        }else {
        	   mav.addObject("pers", "Votre identifiant est inconnu");
               mav.setViewName("connect");
        }
        log.info(mav.getViewName()+ " - "+mav.getModel());
        return mav;
    }

    @RequestMapping(value="/inscription", method=RequestMethod.GET)
    public ModelAndView inscription(){
        Utilisateur u = new Utilisateur();
        ModelAndView mav = new ModelAndView("register", "utilisateur", u);
        return mav;
    }

}
