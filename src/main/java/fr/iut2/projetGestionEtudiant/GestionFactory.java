package fr.iut2.projetGestionEtudiant;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Collection;
import java.util.HashMap;

public class GestionFactory {

	private static final String PERSISTENCE_UNIT_NAME = "projetGestionEtudiantBD";

	public static EntityManagerFactory factory;


	public static void open() {
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	}

	// Fermeture de la factory
	public static void close() {
		factory.close();
	}
}
