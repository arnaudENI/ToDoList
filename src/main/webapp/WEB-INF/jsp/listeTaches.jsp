<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<html>
<head>
    <title>Liste des tache</title>
</head>
<body>
<h1>AFFICHE LE LISTE DES TACHES DE L'UTLISATEUR : ${pers}</h1>

<table>
    <th>
        <td>Description</td>
        <td>Date</td>
        <td>Etat</td>
        <td>Categories</td>
        
    </th>
<%--     <c:forEach var="row" items="${pers}" > --%>
<!--     <tr> -->
<%--         <td><c:out value="${row}" /></td> --%>
<!--     </tr> -->
<%--     </c:forEach> --%>
</table>


</body>
</html>
