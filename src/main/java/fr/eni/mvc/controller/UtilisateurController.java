package fr.eni.mvc.controller;

import java.util.logging.Logger;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import fr.eni.mvc.bean.Utilisateur;
import fr.eni.mvc.service.GestionUtilisateur;

@Controller
@SessionAttributes({ "pers" })
public class UtilisateurController {

	private static Logger log = Logger.getLogger(UtilisateurController.class.getName());

	@Autowired
	GestionUtilisateur gu;

	@Resource(name = "ut1")
	Utilisateur ut1;
		

	public void persistUtilisateur(Utilisateur ut1) {
		try {
			gu.ajouterUtilisateur(ut1);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@RequestMapping(method = RequestMethod.GET, path = "/connect")
	public ModelAndView appelConnexion() {
		log.info("[redirection vers page connexion]");
		ModelAndView mav = new ModelAndView();
		try {
			if (gu.listeUtilisateur().isEmpty()) {				
				Utilisateur uc = new Utilisateur();
				mav.addObject("pers", uc);
				mav.addObject("info", "Aucun utilisateur en base");
				mav.setViewName("register");

			} else {
				Utilisateur uc = new Utilisateur();
				mav.addObject("pers", uc);
				mav.setViewName("connect");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
	
	

	@RequestMapping(method = RequestMethod.POST, path = "/connect")
	public ModelAndView utilisateurConnect(@ModelAttribute("pers") Utilisateur u) {

		ModelAndView mav = new ModelAndView();
		log.info("[" + u.getIdentifiant() + " - " + u.getMdp() + "]");
		if (u.getIdentifiant().equals(ut1.getIdentifiant()) && u.getMdp().equals(ut1.getMdp())) {
			mav.addObject("pers", u);
			mav.setViewName("listeTaches");

		} else {
			Utilisateur uc = new Utilisateur();
			mav.addObject("pers", uc);
			mav.addObject("info", "Votre identifiant est inconnu");
			mav.setViewName("connect");
		}
		log.info(mav.getViewName() + " - " + mav.getModel());
		return mav;
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/addUtilisateur")
	public ModelAndView addUtilisateur(Utilisateur ut) {
		ModelAndView mav = new ModelAndView();
		try {
			if(gu.rechercherUtilisateurParIdentifiant(ut.getIdentifiant()).isEmpty()) {
				gu.ajouterUtilisateur(ut);			
				mav.addObject("pers", ut);
				mav.setViewName("connect");
			}else {
				mav.addObject("info", "Cet identifiant existe déjà en base !");
				mav.setViewName("register");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
		
	}

    @RequestMapping(value="/inscription", method=RequestMethod.GET)
    public ModelAndView inscription(){
        Utilisateur u = new Utilisateur();
        ModelAndView mav = new ModelAndView("register", "pers", u);
        return mav;
    }

	@RequestMapping(value="/listeTaches", method=RequestMethod.GET)
	public ModelAndView listerTaches() throws Exception {
		Utilisateur u = gu.rechercherUtilisateur(5);
		ModelAndView mav = new ModelAndView("listeTaches", "pers", u);
		return mav;
	}


}
