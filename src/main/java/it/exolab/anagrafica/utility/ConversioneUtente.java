package it.exolab.anagrafica.utility;


import java.text.ParseException;
import java.text.SimpleDateFormat;

//import java.time.format.DateTimeFormatter;

import it.exolab.anagrafica.dto.UtenteDto;
import it.exolab.login.models.Utente;
//import static it.exolab.anagrafica.utility.Costanti.*;

public class ConversioneUtente {

	
	public UtenteDto utenteEntityToDto(Utente utente) {
		
	
		UtenteDto utenteOut = new UtenteDto();
		
		utenteOut.setIdUtente(utente.getIdUtente());
		utenteOut.setNome(utente.getNome());
		utenteOut.setCognome(utente.getCognome());
		utenteOut.setEmail(utente.getEmail());
		utenteOut.setPassword(utente.getPassword());
		utenteOut.setLuogoDiNascita(utente.getLuogoDiNascita());
//		utenteOut.setDataDiNascita(utente.getDataDiNascita()
//		   		 .format(DateTimeFormatter.ofPattern(FORMATTAZIONE_DATA)));
		utenteOut.setDataDiNascita(new SimpleDateFormat("dd/MM/yyyy").format(utente.getDataDiNascita()));
		utenteOut.setIdRuolo(utente.getIdRuolo());
		utenteOut.setNomeFile(utente.getNomeFile());
		utenteOut.setContenutoFile(utente.getContenutoFile());
		utenteOut.setTipoContenutoFile(utente.getTipoContenutoFile());
		
		return utenteOut;
	}
	
	public Utente dtoToUtenteEntity(UtenteDto utenteDto) throws ParseException {
		
		
		Utente utente = new Utente();
		
		utente.setIdUtente(utenteDto.getIdUtente());
		utente.setNome(utenteDto.getNome());
		utente.setCognome(utenteDto.getCognome());
		utente.setEmail(utenteDto.getEmail());
		utente.setPassword(utenteDto.getPassword());
		utente.setLuogoDiNascita(utenteDto.getLuogoDiNascita());
		System.out.println("utenteDto.getDataDiNascita() " + utenteDto.getDataDiNascita());
		utente.setDataDiNascita(new SimpleDateFormat("dd/MM/yyyy")
				.parse(utenteDto.getDataDiNascita()));
		utente.setIdRuolo(utenteDto.getIdRuolo());
		utente.setNomeFile(utenteDto.getNomeFile());
		utente.setContenutoFile(utenteDto.getContenutoFile());
		utente.setTipoContenutoFile(utenteDto.getTipoContenutoFile());
		
		return utente;
	}
	
	
}
