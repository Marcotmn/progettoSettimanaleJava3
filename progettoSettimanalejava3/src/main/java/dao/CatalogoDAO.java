package dao;

import java.util.List;

import entities.Prestito;
import entities.Users;
import entities.ElementoCatalogo;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;


import org.jboss.logging.Logger;

public class CatalogoDAO {
	private final EntityManager em;
	private static Logger log = Logger.getLogger(CatalogoDAO.class);

	public CatalogoDAO(EntityManager em) {
		this.em = em;
	}

	public void addItem(ElementoCatalogo e) {
		EntityTransaction t = em.getTransaction();
		t.begin();

		em.persist(e);

		t.commit();
		log.info("Elemento salvato correttamente");
	}

	public void addUser(Users e) {
		EntityTransaction t = em.getTransaction();
		t.begin();

		em.persist(e);

		t.commit();
		log.info("Utente salvato correttamente");
	}

	public void addPrestito(Prestito s) {
		EntityTransaction t = em.getTransaction();
		t.begin();

	
		if (!em.contains(s.getElemento())) {
			em.persist(s.getElemento());
		}

		em.persist(s);

		t.commit();
		log.info("Prestito salvato correttamente");
	}

	public void findByIsbnAndDelete(Long isbn) {
		ElementoCatalogo found = em.find(ElementoCatalogo.class, isbn);
		if (found != null) {
			EntityTransaction t = em.getTransaction();

			t.begin();

			em.remove(found);

			t.commit();
			log.info("Elemento eliminato correttamente");
		} else {
			log.error("Elemento non trovato");
		}
	}

	public ElementoCatalogo ricercaPerISBN(Long isbn) {
		return em.find(ElementoCatalogo.class, isbn);
	}

	public List<ElementoCatalogo> ricercaPerAnnoPubblicazione(int anno) {
		TypedQuery<ElementoCatalogo> query = em.createQuery("SELECT e FROM Elemento e WHERE e.annoPubblicazione = :anno",
				ElementoCatalogo.class);
		query.setParameter("anno", anno);
		return query.getResultList();
	}

	public List<ElementoCatalogo> ricercaPerAutore(String autore) {
		TypedQuery<ElementoCatalogo> query = em.createQuery("SELECT e FROM Book e WHERE e.autore = :autore", ElementoCatalogo.class);
		query.setParameter("autore", autore);
		return query.getResultList();
	}

	public List<ElementoCatalogo> ricercaPerTitolo(String titolo) {
		TypedQuery<ElementoCatalogo> query = em.createQuery("SELECT e FROM Elemento e WHERE e.titolo LIKE :titolo",
				ElementoCatalogo.class);
		query.setParameter("titolo", "%" + titolo + "%");
		return query.getResultList();
	}

	public List<Prestito> ricercaPrestitiUtente(String numeroTessera) {
		TypedQuery<Prestito> query = em.createQuery("SELECT p FROM Prestito p WHERE p.utente.numeroTessera = :tessera",
				Prestito.class);
		query.setParameter("tessera", numeroTessera);
		return query.getResultList();
	}

	public List<Prestito> ricercaPrestitiScaduti() {
		TypedQuery<Prestito> query = em.createQuery(
				"SELECT p FROM Prestito p WHERE p.dataRestituzionePrevista < CURRENT_DATE AND p.dataRestituzioneEffettiva IS NULL",
				Prestito.class);
		return query.getResultList();
	}
}