package fr.iut2.projetGestionEtudiant;

import fr.iut2.projetGestionEtudiant.data.dao.EtudiantDAO;
import fr.iut2.projetGestionEtudiant.data.dao.GroupeDAO;
import fr.iut2.projetGestionEtudiant.data.dao.ModuleDAO;
import fr.iut2.projetGestionEtudiant.data.entities.Etudiant;
import fr.iut2.projetGestionEtudiant.data.entities.Groupe;
import fr.iut2.projetGestionEtudiant.data.entities.Module;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

public class Controleur extends HttpServlet {

    private String urlIndex;
    private String urlDetails;
    private String urlAbsences;

    private final static String LISTE_ETUDIANT = "listeEtudiants";

    private final static String ETUDIANT = "etudiant";
    private final static String ETUDIANTS_ABSENCES = "listEtudiantAbsence";

    @Override
    public void init() throws ServletException {
        urlIndex = getInitParameter("urlIndex");
        urlDetails = getInitParameter("urlDetails");
        urlAbsences = getInitParameter("urlAbsences");

        GestionFactory.open();
    }

    @Override
    public void destroy() {
        super.destroy();

        // Fermeture de la factory
        GestionFactory.close();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getPathInfo();

        action = action == null? "/index" : action;

        switch (action){

            case "/details":
                doDetails(req, resp);
                break;
            case "/absences":
                doAbsences(req, resp);
                break;
            default:
                doIndex(req, resp);
                break;

        }
    }

    private void doAbsences(HttpServletRequest req, HttpServletResponse resp) {

        List<Etudiant> etudiants = EtudiantDAO.getAllByAbsences();
        req.setAttribute(ETUDIANTS_ABSENCES, etudiants);

        loadJSP(urlAbsences, req, resp);
    }

    private void doDetails(HttpServletRequest req, HttpServletResponse resp) {

        int idEtudiant = Integer.parseInt(req.getParameter("idEtudiant"));

        Etudiant etudiant = EtudiantDAO.retrieveById(idEtudiant);

        req.setAttribute(ETUDIANT, etudiant);

        loadJSP(urlDetails, req, resp);
    }

    public void doIndex(HttpServletRequest req, HttpServletResponse resp){
        List<Etudiant> etudiantCollection = EtudiantDAO.getAll();

        req.setAttribute(LISTE_ETUDIANT, etudiantCollection);

        loadJSP(urlIndex, req, resp);
    }

    private void loadJSP(String s, HttpServletRequest req, HttpServletResponse resp) {
        try {
            this.getServletContext().getRequestDispatcher(s).forward(req,resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
