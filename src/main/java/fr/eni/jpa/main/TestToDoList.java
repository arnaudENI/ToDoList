package fr.eni.jpa.main;

import fr.eni.jpa.bean.Categorie;
import fr.eni.jpa.bean.Tache;
import fr.eni.jpa.bean.Utilisateur;
import fr.eni.jpa.dao.IDAOImpl;
import fr.eni.jpa.exception.DAOException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class TestToDoList {


    public static void main(String[] args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        IDAOImpl udao = new IDAOImpl<>(Utilisateur.class);
        IDAOImpl dao = new IDAOImpl();

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
        dao.add(listCateUtilisateur1);
        dao.add(listCateUtilisateur2);

        System.out.println("*******************Ajout de categories************************");
        afficherTable(dao, Categorie.class);

        /**
         * Ajout d'utilisateurs
         */
        Utilisateur u1 = new Utilisateur("arno", "coste", "arnaud", "abcdef", listCateUtilisateur1);
        Utilisateur u2 = new Utilisateur("Babousse", "Boussin", "Maxime", "ghikl", listCateUtilisateur2);
        Utilisateur u3 = new Utilisateur("Goule12", "Boussin", "Annie", "pass123");
        Utilisateur u4 = new Utilisateur("Foussey", "Boussin", "Fabien", "ggor85");
        List<Utilisateur> listU = new ArrayList<>();
        listU.add(u3);
        listU.add(u4);

        try {
            dao.add(u1);
            dao.add(u2);
            dao.add(u3);
            dao.add(u4);
            dao.add(listU);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("*******************Ajout d'Utilisateurs************************");
        afficherTable(dao, Utilisateur.class);

        System.out.println("recherche de l'utilisateur 3 par findById(3) : " + dao.findById(Utilisateur.class, 3));
        Utilisateur util3av = (Utilisateur) dao.findById(Utilisateur.class, 3);
        System.out.println("Son mot de passe : " + util3av.getMdp() + "\nVa etre modifié (re-findById)");
        util3av.setMdp("pass321");
        dao.update(util3av);
        Utilisateur util3ap = (Utilisateur) dao.findById(Utilisateur.class, 3);
        System.out.println("Le mot de passe est désormais : " + util3ap.getMdp() + "\n");

        System.out.println("Recherche des utilisateurs dont le nom est boussin grace a la namedquery findNameLike : \n");
        afficherBoussins(dao);
        System.out.println("\nEncore plus fort, le prenom Maxime va etre modifié ! \n");
        Utilisateur max = (Utilisateur) dao.findById(Utilisateur.class, 2);
        max.setPrenom("Albert");
        dao.update(max);
        max = (Utilisateur) dao.findById(Utilisateur.class, 2);
        System.out.println("Et voila il s'appel maintenant  : " + max.getPrenom() + " la preuve : ");
        afficherBoussins(dao);


        /**
         * Ajout Tache
         */
        Tache t2 = new Tache("créer diagrammes", sdf.parse("20/05/2020"), true);
        Tache t1 = new Tache("ecrire code", sdf.parse("24/053/2020"), false);
        Tache t3 = new Tache("rendre ecf", sdf.parse("12/01/2020"), true);
        Tache t4 = new Tache("comprendre Git", sdf.parse("257/06/2020"), false);
        List<Tache> listeTaches1 = new ArrayList<>();
        List<Tache> listTaches2 = new ArrayList<>();
        listeTaches1.add(t2);
        listeTaches1.add(t1);
        listeTaches1.add(t3);
        listTaches2.add(t4);
        dao.add(listeTaches1);
        dao.add(listTaches2);
        System.out.println("\n******************Les Taches suivantes ont ete ajoutees :*****************");
        afficherTable(dao,Tache.class);

        System.out.println("\nAffectation de tache a un utilisateur : ");
        System.out.println("\nL'utilisateur 1 avant ajout d'une tache : " + dao.findById(Utilisateur.class, 1));
        /**
         * affecte une tache a un utilisateur
         */
        u1.setTaches(listeTaches1);
        try {
            dao.update(u1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("L'utilisateur 1 apres ajout d'une tache : " + dao.findById(Utilisateur.class, 1) + "\n");


        try {
            System.out.println("liste des utilisateurs s1 : \n" + dao.findAll(Utilisateur.class));
            System.out.println("\nliste findall generic criteria s2 : \n" + udao.findAll());
            System.out.println("\nliste findalljpql : \n" + dao.findAllJpql());
        } catch (DAOException e) {
            e.printStackTrace();
        }

        System.out.println("\n.........................Suppression de divers elements ........................");
        afficherTable(dao,Tache.class);
        System.out.println("\nLa tache : " + dao.findById(Tache.class, 4 ) + " va etre SUPPRIMEE !\n");
        dao.delete(t4);
        afficherTable(dao, Tache.class);

        System.out.println("\nContenue de la table utilisateur : ");
        afficherTable(dao,Utilisateur.class);
        System.out.println("\nSUPPRESSION de l'utilisateur 1 : " + dao.findById(Utilisateur.class,1)+"\n");
        dao.delete(dao.findById(Utilisateur.class,1));
        afficherTable(dao,Utilisateur.class);
    }

    public static void afficherBoussins(IDAOImpl dao) {
        List<Utilisateur> boussins = dao.findByNameLike("boussin");
        for (Utilisateur util : boussins
        ) {
            System.out.println(util);
        }
    }

    public static void afficherTable(IDAOImpl dao, Class classe) {
        List<?> liste = new ArrayList<>();
        try {
            liste = dao.findAll(classe);
        } catch (DAOException e) {
            e.printStackTrace();
        }
        for (Object cat : liste
        ) {
            System.out.println(cat);
        }
        //System.out.println("\n");
    }
}
