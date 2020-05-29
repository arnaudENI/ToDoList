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
                <span class="glyphicon glyphicon-film"></span>
                <span class="glyphicon glyphicon-film"></span>
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
                <li><a href="app/inscription" class="active">Inscription</a></li>
                <li><a href="app/connect">Connexion</a></li>
                <li><a href="app/listeTaches">Liste des tâches</a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="container">
    <h1 class="bleu">Inscription</h1>
    <br><br>
    <div>
        <form:form action="ajouterValid" method="POST" cssClass="form-horizontal" modelAttribute="utilisateur">
            <div class="form-group">
                <form:label path="identifiant" cssClass="col-xs-2 control-label">Identifiant :</form:label>
                <div class="col-xs-10">
                    <form:input path="identifiant"  placeholder="Babousse"  cssClass="form-control" />
                </div>
            </div>
            <div class="form-group">
                <form:label path="prenom" cssClass="col-xs-2 control-label">Nom :</form:label>
                <div class="col-xs-5">
                    <form:input path="prenom"  placeholder="Maxime"  cssClass="form-control" />
                </div>
                <div class="col-xs-5">
                    <form:input path="nom"  placeholder="Boussin"  cssClass="form-control" />
                </div>
            </div>

            <div class="form-group" >
                <div class="col-xs-offset-2 col-xs-10">
                    <button type="submit" class="btn btn-primary">Envoyer</button>
                </div>
            </div>

        </form:form>
    </div>
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