package fr.eni.mvc.dao;

import fr.eni.mvc.bean.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorieDAO extends JpaRepository<Categorie, Integer> {
}
