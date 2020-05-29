<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Connexion</title>
</head>
<body>
<h1>CONNEXION</h1>

<div>
 
    <form:form action="conect" method="post" commandName="pers">
        <div>
            <form:label path="identifiant">IDENTIFIANT : </form:label>
            <form:input path="identifiant"/>
        </div>
        <div>
            <form:label path="mdp">MOT DE PASS : </form:label>
            <form:input path="mdp"/>
        </div>
        <div>
            <input type="submit" value="CONNEXION">
        </div>
    </form:form>
</div>

</body>
</html>
