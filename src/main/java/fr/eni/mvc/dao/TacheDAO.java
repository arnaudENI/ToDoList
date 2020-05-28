package fr.eni.mvc.dao;

import fr.eni.mvc.bean.Tache;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TacheDAO extends JpaRepository<Tache, Integer> {
}
