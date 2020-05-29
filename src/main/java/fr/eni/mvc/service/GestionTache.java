package fr.eni.mvc.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.eni.mvc.bean.Tache;
import fr.eni.mvc.dao.TacheDAO;

@Service(value="gestionTache")
public class GestionTache {
	
	@Autowired
	TacheDAO tdao;
	
	  public List<Tache> listeTache()throws Exception  {
	        return tdao.findAll();
	    }
	  
	    public void ajouterTache(Tache t)throws Exception {
	    	tdao.save(t);
	    }

	    public void modifierTache(Tache t) throws Exception {
	    	tdao.save(t);
	    }

	    public void supprimerTache(Tache t)throws Exception  {
	    	tdao.delete(t);
	    }
	    
	    public List<Tache> listeTacheParDate(Date date)throws Exception{
	    	return tdao.findByDate(date);
	    }
	    
//	    public List<Tache> listeTacheParCategorie()throws Exception{
//	    	return tdao.findByCategories();
//	    }

}
