package no.boligpriser.rest;

public class BrukerJson {

	private Integer brukerId;
	private String brukernavn;
	
	public BrukerJson(Integer brukerId, String brukernavn){
		this.brukerId = brukerId;
		this.brukernavn = brukernavn;
	}
	
	public Integer getBrukerId() {
		return brukerId;
	}
	public void setBrukerId(Integer brukerId) {
		this.brukerId = brukerId;
	}
	public String getBrukernavn() {
		return brukernavn;
	}
	public void setBrukernavn(String brukernavn) {
		this.brukernavn = brukernavn;
	}
	
}
