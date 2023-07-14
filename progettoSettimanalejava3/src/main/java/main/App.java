package main;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.CatalogoDAO;

import org.jboss.logging.Logger;


import entities.Books;
import entities.ElementoCatalogo;

import entities.Periodicità;



import entities.Prestito;
import entities.Rivista;
import entities.Users;

public class App {
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("progettoSettimanalejava3");
	private static Logger log = Logger.getLogger(App.class);

	public static void main(String[] args) {
		EntityManager em = emf.createEntityManager();
		CatalogoDAO ctg = new CatalogoDAO(em);

		
		Users persona1 = new Users("098367", "Marco", "Tumminia", LocalDate.of(1993, 04, 13));
		Users persona2 = new Users("037628", "Bianca", "Schillaci", LocalDate.of(1992, 10, 25));
		
		ctg.addUser(persona1);
		ctg.addUser(persona2);


		Books nuovo = new Books(1234567890L,  "La ragazza delle stelle", 2007, 662, "Elena Rossi", "Romanzo Contemporaneo");
		Books nuovo1 = new Books(1234567891L,  "Le cronache di Eldoria: Il risveglio del potere", 2009, 789, "Mitshuno", "Fantasy");
		
		ctg.addItem(nuovo);
		ctg.addItem(nuovo1);

		Rivista nuovo2 = new Rivista(1234567892L, "Focus", 1998, 45, Periodicità.SETTIMANALE);
		Rivista nuovo3 = new Rivista(1234567893L, "Esplorando il Mondo", 1994, 33, Periodicità.SEMESTRALE);

		ctg.addItem(nuovo2);
		ctg.addItem(nuovo3);

		ctg.findByIsbnAndDelete(1234567893L);

		ElementoCatalogo item = ctg.ricercaPerISBN(1234567893L);
		log.info(item);

		List<ElementoCatalogo> elementiAnno = ctg.ricercaPerAnnoPubblicazione(2007);
		log.info(elementiAnno);

		List<ElementoCatalogo> elementiAutore = ctg.ricercaPerAutore("Elena Rossi");
		log.info(elementiAutore);

		List<ElementoCatalogo> elementiTitolo = ctg.ricercaPerTitolo("Focus");
		log.info(elementiTitolo);

		Prestito user = new Prestito(persona2, nuovo3, LocalDate.of(2022, 5, 30), LocalDate.of(2022, 7, 30),
				LocalDate.of(2022, 9, 10));
		ctg.addPrestito(user);

		List<Prestito> prestitiUtente = ctg.ricercaPrestitiUtente("098367");
		log.info(prestitiUtente);

		List<Prestito> prestitiScadutiNonRestituiti = ctg.ricercaPrestitiScaduti();
		log.info(prestitiScadutiNonRestituiti);

		em.close();
		emf.close();
	}
}
