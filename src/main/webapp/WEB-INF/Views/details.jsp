<%@ page import="fr.iut2.projetGestionEtudiant.data.entities.Etudiant" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<jsp:useBean id="etudiant" class="fr.iut2.projetGestionEtudiant.data.entities.Etudiant" scope="request"/>
<html>
<head>
    <title>Détail d'un étudiant</title>
    <%@ include file="css.jsp"%>
</head>
<body>
    <h1>Détail de l'élève <%=etudiant.getId()%></h1>
    <ul>
        <li><p>Nom : <%=etudiant.getNom()%></p></li>
        <li><p>Prénom : <%=etudiant.getPrenom()%></p></li>
        <li><p>Nb absences : <%=etudiant.getNbAbsences()%></p></li>
    </ul>
</body>
</html>
