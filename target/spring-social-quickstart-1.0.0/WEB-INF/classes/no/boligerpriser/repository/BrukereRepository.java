package no.boligerpriser.repository;

import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.List;

import no.boligpriser.domene.Bruker;
import no.boligpriser.rest.BrukerJson;

public interface BrukereRepository {

	List<BrukerJson> getAlleBrukere() throws SQLException, URISyntaxException, Exception;

}
