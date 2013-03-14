package no.boligpriser.domene;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.social.quickstart.config.MainConfig;

public class DatabaseSpike {

	public static void main(String[] args) throws Exception {
		System.out.println("start...");
		Connection con = null;
		try {
			MainConfig config = new MainConfig();
			con = config.dataSource().getConnection();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		Statement stmt = null;
		String query = "select \"brukerId\", brukernavn, fornavn, etternavn from brukere order by \"brukerId\"";

		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				int brukerId = rs.getInt("brukerId");
				String brukernavn = rs.getString("brukernavn");
				String fornavn = rs.getString("fornavn");
				String etternavn = rs.getString("etternavn");
				
				System.out.println(brukerId + ": " + brukernavn);
			}
		} catch (SQLException e) {
			System.out.println("oh shit" + e.toString());
		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}
	}

}
