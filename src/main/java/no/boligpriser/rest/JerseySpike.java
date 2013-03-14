package no.boligpriser.rest;

import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import no.boligerpriser.repository.BrukereRepository;
import no.boligerpriser.repository.BrukereRepositoryImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Path("/brukere")
public class JerseySpike {

	@GET
	@Path("/alle")
	@Produces({MediaType.APPLICATION_JSON})
	public List<BrukerJson>  getBrukere() {
		BrukereRepository brukereRepository = new BrukereRepositoryImpl();
		try {
			return brukereRepository.getAlleBrukere();
		} catch (SQLException e) {
			// TODO 500 message eller lignende
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
