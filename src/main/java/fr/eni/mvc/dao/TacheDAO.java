package fr.eni.mvc.dao;

import fr.eni.mvc.bean.Tache;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TacheDAO extends JpaRepository<Tache, Integer> {
	
    List<Tache> findByDescription(String description);
//    List<Tache> findAllByCategories();
    
    
}
