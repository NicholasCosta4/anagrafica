package it.exolab.login.dao;

import java.util.List;

import factory.EntityManagerProvider;
import it.exolab.login.models.Utente;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;

public class UtenteCrud {

	public List<Utente> findAllUtenti() throws Exception {
		System.out.println("\tsono nel crud di findAllUtenti");

		try {

			return EntityManagerProvider.getEntityManager()
					.createQuery("SELECT u FROM Utente u WHERE u.idRuolo = :idRuolo", Utente.class)
					.setParameter("idRuolo", 2).getResultList();

		} catch (Exception e) {

			System.out.println("Eccezione Nel Crud Utente ");
			e.printStackTrace();
			throw new Exception();
		}
	}

	public Utente insertUtente(Utente utente) throws Exception {
		System.out.println("\tsono nel crud di insertUtente");

		try {

			if (EntityManagerProvider.getEntityManager().contains(utente)) {
				utente = EntityManagerProvider.getEntityManager().merge(utente);
			}

			EntityManagerProvider.getEntityManager().persist(utente);
			return utente;

		} catch (Exception e) {

			System.out.println("Eccezione Nel Crud Utente ");
			e.printStackTrace();
			throw new Exception();
		}

	}

	public Utente findByEmailAndPassword(Utente utente) throws Exception {
		System.out.println("\tsono nel crud di findByEmailAndPassword");

		Utente utenteDaRestituire = new Utente();
		try {
			TypedQuery<Utente> query = EntityManagerProvider.getEntityManager()
					.createQuery("SELECT u FROM Utente u WHERE u.email = :email AND u.password = :password",
							Utente.class)
					.setParameter("email", utente.getEmail()).setParameter("password", utente.getPassword());
			return utenteDaRestituire = query.getSingleResult();

		} catch (NoResultException ex) {
			return utenteDaRestituire;

		} catch (Exception e) {
			System.out.println("Eccezione Nel Crud Utente ");
			e.printStackTrace();
			throw new Exception();
		}
	}

	public Utente updateUtente(Utente utente) throws Exception {
		System.out.println("\tsono nel crud di updateUtente");

		try {
			if (null == utente.getIdUtente()) {

				return utente = null;
			} else {

				utente = EntityManagerProvider.getEntityManager().merge(utente);
				return utente;
			}
		} catch (Exception e) {

			e.printStackTrace();
			System.out.println("Errore nel Crud Utente");
			throw new Exception();
		}
	}

	public Utente findById(Integer id) {
		System.out.println("\tsono nel crud di findById");

		try {

			return (Utente) EntityManagerProvider.getEntityManager()
					.createQuery("SELECT u From Utente u WHERE u.idUtente = :id").setParameter("id", id)
					.getSingleResult();

		} catch (NoResultException e) {

			return new Utente();
		}
	}

}
