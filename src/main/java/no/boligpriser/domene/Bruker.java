package no.boligpriser.domene;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "brukere")
public class Bruker {

	private Integer brukerId;
	private String brukernavn;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "brukerId", unique = true, nullable = false)
	public Integer getBrukerId() {
		return this.brukerId;
	}
	
	@Column(name = "brukernavn", nullable = false, length = 20)
	public String getBrukernavn() {
		return this.brukernavn;
	}
	
}
