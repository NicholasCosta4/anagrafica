package it.exolab.anagrafica.interfacce;

import it.exolab.anagrafica.dto.UtenteDto;
import it.exolab.login.models.Utente;
import jakarta.ws.rs.core.Response;

public interface UtenteRestInterfaccia {

	Response insertUtente(UtenteDto utenteDto) throws Exception;

	Response login(UtenteDto utenteDto) throws Exception;


	Response findAllUtenti() throws Exception;

	Response updateUtente(Utente utente) throws Exception;

}
