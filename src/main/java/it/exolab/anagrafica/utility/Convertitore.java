package it.exolab.anagrafica.utility;
import static it.exolab.anagrafica.utility.Costanti.*;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;

public class Convertitore {

	public String LocalDateToString(LocalDate data) {

		System.out.println("\tSono dentro la class Convertitore nel LocalDateToString");

		return data.format(DateTimeFormatter.ofPattern(FORMATTAZIONE_DATA));
	}

	public LocalDate dateToLocalDate(Date data) {

		System.out.println("\tSono dentro la class Convertitore nel dateToLocalDate");

		return LocalDate.ofInstant(data.toInstant(), ZoneId.systemDefault());
	}

	public LocalDate StringaToLocalDate(String data) {

		System.out.println("\tSono dentro la class Convertitore nel Stringa " + data + " ToLocalDate");

		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern(FORMATTAZIONE_DATA);
			LocalDate dataConvertita = LocalDate.parse(data, formatter);
			return dataConvertita;
		} catch (DateTimeParseException dateTimeExc) {
			return null;
		}

	}
	
	
}
