<%@ page language="java" contentType="text/html; charset=UTF-8"
                 pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE>
<html>
<head>
    <meta charset="UTF-8">
    <title>Inscription</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="../css/commun.css">
</head>
<body>
<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <a  href="#" class="navbar-brand active">
                <span class="glyphicon glyphicon-modal-window"></span>
            </a>
            <button class="navbar-toggle" type="button" data-toggle="collapse" data-target="#navbar-main">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
        </div>
        <div class="navbar-collapse collapse" id="navbar-main">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="/">Accueil</a></li>
                <li><a href="inscription">Inscription</a></li>
                <li><a href="connect">Connexion</a></li>
                <li><a href="listeTaches"  class="active">Liste des tâches</a></li>
            </ul>
        </div>
    </div>
</nav>
<div class="container">
    <h1 class="bleu">Liste des tâches</h1>
    <br><br>
    <c:if test="${info != null}">
        <div class="alert alert-info">${info}</div>
    </c:if>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">Description</th>
            <th scope="col">Date</th>
            <th scope="col">Etat</th>
            <th scope="col">Categories</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="tache" items="${pers.taches}" >
            <tr>
                <td>${tache.description}</td>
                <td>${tache.date_tache}</td>
                <td>${tache.fait ? 'Fait' : 'A faire'}</td>
                <td>
                    <c:forEach var="categorie" items="${tache.categories}" >
                        <span class="badge badge-primary">${categorie.libelle}</span>
                    </c:forEach>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<nav class="navbar navbar-default navbar-fixed-bottom">
    <div class="container">
        <ul class="nav navbar-nav  navbar-foot">
            <li class="pull-left"><a>© 2017 Copyright</a></li>
            <li class="pull-right"><a >Formation Eni</a></li>
        </ul>
    </div>
</nav>

</body>
</html>
