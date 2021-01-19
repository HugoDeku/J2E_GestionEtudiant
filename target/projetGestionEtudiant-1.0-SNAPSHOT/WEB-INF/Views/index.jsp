<%@ page import="fr.iut2.projetGestionEtudiant.data.entities.Etudiant" %>
<jsp:useBean id="listeEtudiants" type="java.util.Collection<fr.iut2.projetGestionEtudiant.data.entities.Etudiant>" scope="request"/>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
    <html>
        <head>
            <%@ include file="css.jsp"%>
            <title>Affichage des étudiants</title>
        </head>
        <body>
            <h1>Affichage de tous les étudiants</h1>
                <ul>
                    <%
                        for(Etudiant etudiant : listeEtudiants){
                            out.println("<li><a href=\"" +  application.getContextPath() + "/do/details?idEtudiant=" + etudiant.getId() + "\">Etudiant <strong>" +etudiant.getPrenom() + " " + etudiant.getNom() +"</strong></a></li>");
                        }
                    %>
                </ul>
                <a class="buttonPerso" href="<%=application.getContextPath() + "/do/absences"%>">Absences par étudiant</a>
        </body>
    </html>