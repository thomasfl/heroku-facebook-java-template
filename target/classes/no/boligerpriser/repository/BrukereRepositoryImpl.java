package no.boligerpriser.repository;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import no.boligpriser.domene.Bruker;
import no.boligpriser.rest.BrukerJson;

import org.springframework.social.quickstart.config.MainConfig;
import org.springframework.stereotype.Component;

@Component("brukereRepository")
public class BrukereRepositoryImpl implements BrukereRepository{

	@Override
	public List<BrukerJson> getAlleBrukere() throws Exception {
		MainConfig config = new MainConfig();
		Connection con = config.dataSource().getConnection();
		Statement stmt = null;
		String query = "select bruker_id, brukernavn, fornavn, etternavn from brukere order by bruker_id";

		stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		List<BrukerJson> brukere = new ArrayList<BrukerJson>();
		while (rs.next()) {
			BrukerJson bruker = new BrukerJson(rs.getInt("bruker_id"),rs.getString("brukernavn"));
			brukere.add(bruker);
			// int brukerId = rs.getInt("brukerId");
			// String brukernavn = rs.getString("brukernavn");
			// String fornavn = rs.getString("fornavn");
			// String etternavn = rs.getString("etternavn");
		}

		return brukere;
	};
	
}
