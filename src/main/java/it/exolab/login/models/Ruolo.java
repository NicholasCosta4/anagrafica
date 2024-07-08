package it.exolab.login.models;



import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ruolo")
public class Ruolo
{
	@Id
	@Column(name = "id_ruolo")
	private Integer idRuolo;

	@Column(name = "nome_ruolo")
	private String nomeRuolo;


	public Ruolo() {
		super();
	}

	public Integer getIdRuolo() {
		return idRuolo;
	}
	public void setIdRuolo(Integer idRuolo) {
		this.idRuolo = idRuolo;
	}
	public String getNomeRuolo() {
		return nomeRuolo;
	}
	public void setNomeRuolo(String nomeRuolo) {
		this.nomeRuolo = nomeRuolo;
	}

	@Override
	public String toString() {
		return "Ruolo [idRuolo=" + idRuolo + ", nomeRuolo=" + nomeRuolo + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(idRuolo, nomeRuolo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if ((obj == null) || (getClass() != obj.getClass())) {
			return false;
		}
		Ruolo other = (Ruolo) obj;
		return Objects.equals(idRuolo, other.idRuolo) && Objects.equals(nomeRuolo, other.nomeRuolo);
	}


}
