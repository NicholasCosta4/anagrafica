package it.exolab.login.rest;

import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import it.exolab.anagrafica.dto.UtenteDto;
import it.exolab.anagrafica.interfacce.UtenteRestInterfaccia;
import it.exolab.login.models.Utente;
import it.exolab.login.services.UtenteService;
import jakarta.inject.Inject;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
@Path("/utente")
public class UtenteRest implements UtenteRestInterfaccia {

	@Inject
	private UtenteService utenteService;

	 private static Logger logger = LogManager.getLogger();
	
	@Inject
	Validator validator;

	@Path("/test")
	@GET
	public String test() throws Exception {

		return "test";

	}

	@Override
	@POST
	@Path("/login")
	public Response login(UtenteDto utenteDto) throws Exception {
		logger.info("" + this.getClass().getSimpleName() + "/findByEmailAndPassword");
		try {
			Set<ConstraintViolation<UtenteDto>> violations = validator.validate(utenteDto);
			
			if (  null == utenteDto || violations.isEmpty()) {
				logger.info("utente valido ");
				return Response.ok(utenteService.findByEmailAndPassword(utenteDto)).build();
			}else {
				return (Response) violations;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return Response.serverError().build();
		}

	}

	@Override
	@POST
	@Path("/insertUtente")
	public Response insertUtente(UtenteDto utenteDto) throws Exception {
		try {
			logger.info("rest insertUtente utente in" + utenteDto);
			return Response.ok(utenteService.insertUtente(utenteDto)).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}

	@Override
	@PUT
	@Path("/updateUtente")
	public Response updateUtente(Utente utente) throws Exception {
		try {
			logger.info("dentro rest update utente " + utente);
			return Response.ok(utenteService.updateUtente(utente)).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}

	@Override
	@GET
	@Path("/listUtenti")
	public Response findAllUtenti() throws Exception {
		try {
			logger.info("dentro rest findAll utente ");
			return Response.ok(utenteService.findAllUtenti()).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}

//	public Result tryMeManualValidation(UtenteDto utenteDto) {
//		Set<ConstraintViolation<UtenteDto>> violations = validator.validate(utenteDto);
//		if (violations.isEmpty()) {
//			return new Result("L' Utente ha superato le validazioni");
//		} else {
//			return new Result(violations);
//		}
//	}



}
