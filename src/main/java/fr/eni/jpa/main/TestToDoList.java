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
import java.util.ArrayList;
import java.util.List;

public class TestToDoList {


    public static void main(String[] args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        IDAOImpl dao = new IDAOImpl();
        IDAOImpl udao = new IDAOImpl<>(Utilisateur.class);

        /**
         * Ajout categories
         */
        //u1
        Categorie c1 = new Categorie("Developpement");
        Categorie c2 = new Categorie("Analyse");
        Categorie c3 = new Categorie("deploiement");
        List<Categorie> listCateUtilisateur1 = new ArrayList<>();
        listCateUtilisateur1.add(c1);
        listCateUtilisateur1.add(c2);
        listCateUtilisateur1.add(c3);


        
        //u2
        Categorie c21 = new Categorie("developpement");
        Categorie c22 = new Categorie("diagramme");
        Categorie c23 = new Categorie("git");
        List<Categorie> listCateUtilisateur2 = new ArrayList<>();
        listCateUtilisateur2.add(c21);
        listCateUtilisateur2.add(c22);
        listCateUtilisateur2.add(c23);

        /**
         * Ajout d'utilisateurs
         */
        Utilisateur u1 = new Utilisateur("arno", "arnaud", "coste", "abcdef",listCateUtilisateur1);
        Utilisateur u2 = new Utilisateur("Babousse", "Maxime", "Boussin", "ghikl",listCateUtilisateur2);
        dao.add(u1);
        dao.add(u2);
        /**
         * Ajout Etat
         */
        Etat e1 = new Etat("fait");
        Etat e2 = new Etat("A faire");
        Etat e3 = new Etat("en cours");
        /**
         * Ajout Tache
         */
        Tache t2 = new Tache("créer diagrammes", sdf.parse("20/05/2020"),e1);
        Tache t1 = new Tache("ecrire code", sdf.parse("22/05/2020"),e2);
        Tache t3 = new Tache("rendre ecf", sdf.parse("25/05/2020"),e3);
        List<Tache> tachesu1 = new ArrayList<>();
        List<Tache> tachesu2 = new ArrayList<>();
        List<Tache> tachesu3 = new ArrayList<>();
        tachesu1.add(t2);
        tachesu2.add(t1);
        tachesu3.add(t3);




        try {
//            dao.add(u1);
//            dao.add(u2);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            System.out.println("liste des utilisateurs : " + dao.findAll(Utilisateur.class));
            System.out.println("liste findall generic criteria : " + udao.findAll());
        } catch (DAOException e) {
            e.printStackTrace();
        }






    }

}
