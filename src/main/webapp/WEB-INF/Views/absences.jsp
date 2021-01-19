<%@ page import="fr.iut2.projetGestionEtudiant.data.entities.Etudiant" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<jsp:useBean id="listEtudiantAbsence" type="java.util.Collection<fr.iut2.projetGestionEtudiant.data.entities.Etudiant>" scope="request"/>
<!DOCTYPE html>
    <html>
        <head>
            <title>Etudiants et absences</title>
            <%@ include file="css.jsp"%>
        </head>
        <body>
            <table class="table">
                <caption>Nombre d'absences par élèves</caption>
                <thead class="thead-dark">
                    <tr>
                        <th>Etudiant</th>
                        <th>Nombre Absences</th>
                    </tr>
                </thead>
                <%

                    for(Etudiant etudiant : listEtudiantAbsence){
                        out.println("<tr>");
                        out.println("<td>" + etudiant.getPrenom()+" "+ etudiant.getNom() + "</td>");
                        out.println("<td>" + etudiant.getNbAbsences() + "</td>");
                        out.println("</tr>");
                    }

                %>
            </table>
        </body>
    </html>
