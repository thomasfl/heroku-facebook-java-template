package no.boligpriser.repository;

import static org.junit.Assert.*;

import java.util.List;

import no.boligerpriser.repository.BrukereRepositoryImpl;
import no.boligpriser.rest.BrukerJson;

import org.junit.Test;

public class BrukerRepositoryTest {

	@Test
	public void testQuery(){
		assertEquals(1,1);
		BrukereRepositoryImpl brukereRepo = new BrukereRepositoryImpl();
		try {
			List<BrukerJson> alleBrukere = brukereRepo.getAlleBrukere();
			assertTrue(alleBrukere.size() > 0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
