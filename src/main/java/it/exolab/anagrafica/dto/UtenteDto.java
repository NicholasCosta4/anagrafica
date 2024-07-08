package it.exolab.anagrafica.dto;

import java.util.Arrays;
import java.util.Objects;

public class UtenteDto {
	private Integer idUtente;
	private String nome;
	private String cognome;
	private String email;
	private String password;
	private String luogoDiNascita;
	private String dataDiNascita;
	private Integer idRuolo;
	
	private String nomeFile;
	private String tipoContenutoFile;
	
	private byte[] contenutoFile;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLuogoDiNascita() {
		return luogoDiNascita;
	}
	public void setLuogoDiNascita(String luogoDiNascita) {
		this.luogoDiNascita = luogoDiNascita;
	}
	public String getDataDiNascita() {
		return dataDiNascita;
	}
	public void setDataDiNascita(String dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}
	public String getNomeFile() {
		return nomeFile;
	}
	public void setNomeFile(String nomeFile) {
		this.nomeFile = nomeFile;
	}
	public byte[] getContenutoFile() {
		return contenutoFile;
	}
	public void setContenutoFile( byte[] bs) {
		this.contenutoFile = bs;
	}
	
	public String getTipoContenutoFile() {
		return tipoContenutoFile;
	}
	public void setTipoContenutoFile(String tipoContenutoFile) {
		this.tipoContenutoFile = tipoContenutoFile;
	}
	
	public Integer getIdUtente() {
		return idUtente;
	}
	public void setIdUtente(Integer idUtente) {
		this.idUtente = idUtente;
	}
	
	public Integer getIdRuolo() {
		return idRuolo;
	}
	public void setIdRuolo(Integer idRuolo) {
		this.idRuolo = idRuolo;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(contenutoFile);
		result = prime * result + Objects.hash(cognome, dataDiNascita, email, idRuolo, idUtente, luogoDiNascita, nome,
				nomeFile, password, tipoContenutoFile);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UtenteDto other = (UtenteDto) obj;
		return Objects.equals(cognome, other.cognome) && Arrays.equals(contenutoFile, other.contenutoFile)
				&& Objects.equals(dataDiNascita, other.dataDiNascita) && Objects.equals(email, other.email)
				&& Objects.equals(idRuolo, other.idRuolo) && Objects.equals(idUtente, other.idUtente)
				&& Objects.equals(luogoDiNascita, other.luogoDiNascita) && Objects.equals(nome, other.nome)
				&& Objects.equals(nomeFile, other.nomeFile) && Objects.equals(password, other.password)
				&& Objects.equals(tipoContenutoFile, other.tipoContenutoFile);
	}
	@Override
	public String toString() {
		return "UtenteDto [idUtente=" + idUtente + ", nome=" + nome + ", cognome=" + cognome + ", email=" + email
				+ ", password=" + password + ", luogoDiNascita=" + luogoDiNascita + ", dataDiNascita=" + dataDiNascita
				+ ", idRuolo=" + idRuolo + ", nomeFile=" + nomeFile + ", tipoContenutoFile=" + tipoContenutoFile
				+ ", contenutoFile=" + Arrays.toString(contenutoFile) + "]";
	}
	
	

}
