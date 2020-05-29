package fr.eni.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.eni.mvc.bean.Categorie;
import fr.eni.mvc.bean.Tache;
import fr.eni.mvc.dao.CategorieDAO;

@Service(value="gestionCategorie")
public class GestionCategorie {
	
	@Autowired
	CategorieDAO cdao;
	
	  public List<Categorie> listeTache()throws Exception  {
	        return cdao.findAll();
	    }
	  
	    public void ajouterTache(Categorie c)throws Exception {
	    	cdao.save(c);
	    }

	    public void modifierTache(Categorie c) throws Exception {
	    	cdao.save(c);
	    }

	    public void supprimerTache(Categorie c)throws Exception  {
	    	cdao.delete(c);
	    }
	    
	    public List<Categorie>  findByTaches(Tache tache){
	    	return cdao.findByTaches(tache);
	    }

}
