package fr.iut2.projetGestionEtudiant.data.dao;

import fr.iut2.projetGestionEtudiant.GestionFactory;
import fr.iut2.projetGestionEtudiant.data.entities.Module;

import javax.persistence.EntityManager;

public class ModuleDAO {

    public static Module create(String nom) {

        // Creation de l'entity manager
        EntityManager em = GestionFactory.factory.createEntityManager();

        // create
        em.getTransaction().begin();

        // create new groupe
        Module module = new Module();
        module.setNom(nom);
        em.persist(module);

        // Commit
        em.getTransaction().commit();

        // Close the entity manager
        em.close();

        return module;
    }

    public static Module update(Module module) {

        // Creation de l'entity manager
        EntityManager em = GestionFactory.factory.createEntityManager();

        //
        em.getTransaction().begin();

        // Attacher une entité persistante (etudiant) à l’EntityManager courant  pour réaliser la modification
        em.merge(module);

        // Commit
        em.getTransaction().commit();

        // Close the entity manager
        em.close();

        return module;
    }
}
