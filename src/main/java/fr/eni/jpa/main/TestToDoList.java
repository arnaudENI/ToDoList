package fr.eni.jpa.main;

import fr.eni.jpa.bean.Categorie;
import fr.eni.jpa.bean.Etat;
import fr.eni.jpa.bean.Tache;
import fr.eni.jpa.bean.Utilisateur;
import fr.eni.jpa.dao.DAOUtil;
import fr.eni.jpa.dao.IDAOImpl;
import fr.eni.jpa.exception.DAOException;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TestToDoList {



    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        /**
         * Ajout d'utilisateurs
         */
        Utilisateur u1 = new Utilisateur("arno", "arnaud", "coste", "abcdef");
        Utilisateur u2 = new Utilisateur("Babousse", "Maxime", "Boussin", "ghikl");
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
         * Ajout categories
         */
        Categorie c1 = new Categorie("Developpement");
        Categorie c2 = new Categorie("Analyse");
        Categorie c3 = new Categorie("deploiement");

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
