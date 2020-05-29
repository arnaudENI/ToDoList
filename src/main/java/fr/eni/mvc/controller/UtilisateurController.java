package fr.eni.mvc.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import fr.eni.mvc.bean.Utilisateur;

@Controller
@SessionAttributes({"pers"})
public class UtilisateurController {

   @Resource(name = "ut1")
   Utilisateur ut1;

   @RequestMapping(method = RequestMethod.GET,path="/connect")
   public ModelAndView appelConnexion(){
       System.out.println("passe ************************");
       Utilisateur uc = new Utilisateur();
       ModelAndView mav = new ModelAndView("connect","pers",uc);
       return mav;
   }
   
   
   
    @RequestMapping(method=RequestMethod.POST, path="/connect")
    public ModelAndView utilisateurConnect(@ModelAttribute("pers") Utilisateur u){
    	
    	 ModelAndView mav = new ModelAndView();
    	 System.out.println(u.getIdentifiant()+" - "+u.getMdp());
    	 System.out.println(ut1.getIdentifiant()+" - "+ut1.getMdp());
        if(u.getIdentifiant().equals(ut1.getIdentifiant()) && u.getMdp().equals(ut1.getMdp())){
             mav.addObject("pers", u);
             mav.setViewName("listeTaches");
         
        }else {
        	   mav.addObject("pers", "inconnu");
               mav.setViewName("connect");
        }
        System.out.println(mav.getViewName()+ " - "+mav.getModel());
        return mav;
    }

}
