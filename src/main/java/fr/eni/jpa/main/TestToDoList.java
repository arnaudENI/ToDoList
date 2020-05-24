package fr.eni.jpa.main;

import fr.eni.jpa.bean.Categorie;
import fr.eni.jpa.bean.Etat;
import fr.eni.jpa.bean.Tache;
import fr.eni.jpa.bean.Utilisateur;
import fr.eni.jpa.dao.DAOUtil;
import fr.eni.jpa.dao.IDAOImpl;
import fr.eni.jpa.exception.DAOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class TestToDoList {


    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        /**
         * Ajout d'utilisateurs
         */
        Utilisateur u1 = new Utilisateur("arno", "arnaud", "coste", "abcdef");
        Utilisateur u2 = new Utilisateur("Babousse", "Maxime", "Boussin", "ghikl");
        Utilisateur u3 = new Utilisateur("Goule12", "Annie", "Boussin", "pass123");
        Utilisateur u4 = new Utilisateur("Foussey", "Fabien", "Boussin", "ggor85");
        List<Utilisateur> listU = new ArrayList<>();
        listU.add(u3);
        listU.add(u4);

        IDAOImpl dao = new IDAOImpl();
        try {
            dao.add(u1);
            dao.add(u2);
            dao.add(listU);
        } catch (Exception e) {
            e.printStackTrace();
        }
        u3.setMdp("pass321");
        listU.set(0, u3);
        u1.setPrenom("Albert");
        try {
            dao.update(u1);
            dao.delete(u2);
            dao.update(listU);
        } catch (Exception e) {
            e.printStackTrace();
        }


        /**
         * Ajout categories
         */
        //u1
        Categorie c1 = new Categorie("Developpement");
        Categorie c2 = new Categorie("Analyse");
        Categorie c3 = new Categorie("deploiement");
        List<Categorie> listCateu1 = new ArrayList<>();
        listCateu1.add(c1);
        listCateu1.add(c2);
        listCateu1.add(c3);
        //u2
        Categorie c21 = new Categorie("developpement");
        Categorie c22 = new Categorie("diagramme");
        Categorie c23 = new Categorie("git");
        List<Categorie> listCateu2 = new ArrayList<>();
        listCateu2.add(c21);
        listCateu2.add(c22);
        listCateu2.add(c23);


        /**
         * Ajout d'utilisateurs
         */
        Utilisateur u1 = new Utilisateur("arno", "arnaud", "coste", "abcdef",listCateu1);
        Utilisateur u2 = new Utilisateur("Babousse", "Maxime", "Boussin", "ghikl",listCateu2);
        Utilisateur u3 = new Utilisateur("Jean", "Jean", "Jean", "ghqsdgvikl");
        IDAOImpl dao = new IDAOImpl();
        IDAOImpl udao = new IDAOImpl<>(Utilisateur.class);
        try {
            dao.add(u1);
            dao.add(u2);
            dao.add(u3);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            System.out.println("liste des utilisateurs : " + dao.findAll(Utilisateur.class));
            System.out.println("liste findall generic criteria : " + udao.findAll());
        } catch (DAOException e) {
            e.printStackTrace();
        }


        /**
         * Ajout Etat
         */
        Etat e1 = new Etat("fait");
        Etat e2 = new Etat("A faire");
        Etat e3 = new Etat("en cours");

        /**
         * Ajout Tache
         */
        Tache t2 = new Tache("créer diagrammes", sdf.parse("20/05/2020"));
        Tache t1 = new Tache("ecrire code", sdf.parse("22/05/2020"));
        Tache t3 = new Tache("rendre ecf", sdf.parse("25/05/2020"));
    }

}
