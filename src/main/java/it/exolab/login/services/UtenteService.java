package it.exolab.login.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import it.exolab.anagrafica.dto.UtenteDto;
import it.exolab.anagrafica.utility.ConversioneUtente;
import it.exolab.login.models.Utente;
import it.exolab.login.repository.UtenteRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@ApplicationScoped
public class UtenteService {

	@Inject
	private UtenteRepository utenteRepository;

	private ConversioneUtente convertitoreUtente = new ConversioneUtente();
	private static Logger logger = LogManager.getLogger();

	public Utente findByEmailAndPassword(@Valid UtenteDto utenteDto) throws Exception {
		logger.info("" + this.getClass().getSimpleName() + "/findByEmailAndPassword");
		try {

			return utenteRepository.findByEmailAndPassword(utenteDto).get();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception();
		}

	}

	@Transactional
	public Utente insertUtente(UtenteDto utenteDto) throws Exception {
		System.out.println("" + this.getClass().getSimpleName() + "/insertUtente");
		try {

			Utente utenteEntityin = convertitoreUtente.dtoToUtenteEntity(utenteDto);
			return utenteRepository.insertUtente(utenteEntityin);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception();
		}

	}

	@Transactional
	public Utente updateUtente(Utente utente) throws Exception {
		System.out.println("" + this.getClass().getSimpleName() + "/updateUtente");
		try {
//			QuarkusTransaction.begin();
			System.out.println("dentro rest service update utente " + utente);
			utenteRepository.updateUtente(utente);
//			QuarkusTransaction.commit();
			return utente;
		} catch (Exception e) {
//			QuarkusTransaction.rollback();
			e.printStackTrace();
			throw new Exception();
		}
	}

	public List<Utente> findAllUtenti() throws Exception {
		System.out.println("" + this.getClass().getSimpleName() + "/findAllUtenti");
		try {
			return utenteRepository.findAllUtenti();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception();
		}

	}

	public UtenteRepository getUtenteRepository() {
		return utenteRepository;
	}

	public void setUtenteRepository(UtenteRepository utenteRepository) {
		this.utenteRepository = utenteRepository;
	}

}
