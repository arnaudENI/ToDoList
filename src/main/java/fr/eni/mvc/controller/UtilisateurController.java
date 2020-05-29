package fr.eni.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.eni.mvc.bean.Utilisateur;

@Controller
@RequestMapping(path="/connect")
public class UtilisateurController {

//   @Resource(name = "ut1")
//   Utilisateur ut1;

   @RequestMapping(method = RequestMethod.GET)
   public ModelAndView appelConnexion(){
       System.out.println("passe ************************");
       Utilisateur uc = new Utilisateur();
       ModelAndView mav = new ModelAndView("connect","msg","spring");
       return mav;
   }
   
   
   
//    @RequestMapping(value = "/connect", method = RequestMethod.POST)
//    public ModelAndView validConnect(@Valid @ModelAttribute("pers") Utilisateur u){
//        System.out.println("connexion de : " + u.getIdentifiant() + " - " + u.getMdp());
//        if(u.getIdentifiant() == ut1.getIdentifiant() && u.getMdp() == ut1.getMdp()){
//            ModelAndView mav = new ModelAndView("listeTaches", "pers", u);
//        }
//        ModelAndView mav = new ModelAndView("connect", "pers", u);
//        return mav;
//    }

}
