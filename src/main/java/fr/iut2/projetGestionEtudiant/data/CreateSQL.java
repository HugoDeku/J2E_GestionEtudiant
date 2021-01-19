package fr.iut2.projetGestionEtudiant.data;


import fr.iut2.projetGestionEtudiant.data.dao.ModuleDAO;
import fr.iut2.projetGestionEtudiant.GestionFactory;
import fr.iut2.projetGestionEtudiant.data.dao.EtudiantDAO;
import fr.iut2.projetGestionEtudiant.data.dao.GroupeDAO;
import fr.iut2.projetGestionEtudiant.data.entities.Groupe;
import fr.iut2.projetGestionEtudiant.data.entities.Module;

public class CreateSQL {

    /**
     * @param args
     */
    public static void main(String[] args) {

        //
        GestionFactory.open();

        Groupe MIAM = GroupeDAO.create("miam");
        Groupe SIMO = GroupeDAO.create("SIMO");
        Groupe MESSI = GroupeDAO.create("MESSI");

        // Creation des étudiants
        EtudiantDAO.create("Francis", "Brunet-Manquat", MIAM);
        EtudiantDAO.create("Philippe", "Martin", MIAM);
        EtudiantDAO.create("Mario", "Cortes-Cornax", MIAM);
        EtudiantDAO.create("Françoise", "Coat", SIMO);
        EtudiantDAO.create("Laurent", "Bonnaud", MESSI);
        EtudiantDAO.create("Sébastien", "Bourdon", MESSI);
        EtudiantDAO.create("Mathieu", "Gatumel", SIMO);

        GroupeDAO.update(MIAM);
        GroupeDAO.update(SIMO);

        GestionFactory.close();
    }

}
