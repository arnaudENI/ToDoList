package fr.eni.mvc.service;

import fr.eni.mvc.bean.Utilisateur;
import fr.eni.mvc.dao.UtilisateurDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GestionUtilisateur {

    @Autowired
    UtilisateurDAO dao;

    public List<Utilisateur> listUtilisateurs(){
        return dao.findAll();
    }

    public Utilisateur findUtilisateur(int id){
        return dao.findOne(id);
    }

    public void addUtilisateur(Utilisateur user){
        dao.save(user);
    }

    public void updateUtilisateur(Utilisateur user){
        dao.save(user);
    }
}
