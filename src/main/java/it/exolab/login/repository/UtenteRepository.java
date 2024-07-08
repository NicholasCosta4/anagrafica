package it.exolab.login.repository;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import it.exolab.anagrafica.dto.UtenteDto;
import it.exolab.login.models.Utente;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UtenteRepository implements PanacheRepository<Utente> {

	 private static Logger logger = LogManager.getLogger();
	 
	public Optional<Utente> findByEmailAndPassword(UtenteDto utente) throws Exception {
		logger.info("" + this.getClass().getSimpleName() + "/findByEmailAndPassword");
		try {
			System.out.println(find("email = ?1 and password = ?2", utente.getEmail(), utente.getPassword()).firstResultOptional().get());
			return find("email = ?1 and password = ?2", utente.getEmail(), utente.getPassword()).firstResultOptional();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
	}

	public Utente insertUtente(Utente utente) throws Exception {
		System.out.println("" + this.getClass().getSimpleName() + "/insertUtente");
		try {
			System.out.println(utente);
		utente.persist();
		return utente;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
	}

	public Utente updateUtente(Utente utente) throws Exception {
		System.out.println("" + this.getClass().getSimpleName() + "/updateUtente");
		try {
			System.out.println(utente);
			getEntityManager().merge(utente);
			return utente;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}

	}

	public List<Utente> findAllUtenti() throws Exception {
		System.out.println("" + this.getClass().getSimpleName() + "/findAllUtenti");
		try {
			return listAll();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
	}
}
