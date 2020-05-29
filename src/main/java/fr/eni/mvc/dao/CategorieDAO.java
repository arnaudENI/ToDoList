package fr.eni.mvc.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.eni.mvc.bean.Categorie;
import fr.eni.mvc.bean.Tache;

public interface CategorieDAO extends JpaRepository<Categorie, Integer> {

	List<Categorie> findByTaches(Tache tache);
	
}
