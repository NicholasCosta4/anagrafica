 package it.exolab.login.models;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "utente")
public class Utente extends PanacheEntityBase{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_utente")
	private Integer idUtente;
	@NotBlank(message="nome non può essere vuoto")
	private String nome;
	@NotBlank(message="cognome non può essere vuoto")
	private String cognome;
	private String email;
	private String password;

	@Column(name = "data_di_nascita")
//	@JsonbDateFormat("yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date dataDiNascita;

	@Column(name = "luogo_di_nascita")
	private String luogoDiNascita;

	@Column(name = "id_ruolo")
	private Integer idRuolo;

	@Column(name = "nome_file")
	private String nomeFile;

	@Column(name = "contenuto_file")
	private byte[] contenutoFile;

	@Column(name = "tipo_contenuto_file")
	private String tipoContenutoFile;

	@ManyToOne
	@JoinColumn(name = "id_ruolo", nullable = true, insertable = false, updatable = false)
	private Ruolo ruolo;


//	@ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.REFRESH,
//			CascadeType.DETACH })
//	@JoinTable(name = "utente_conto", joinColumns = @JoinColumn(name = "id_utente", referencedColumnName = "id_utente"), inverseJoinColumns = @JoinColumn(name = "id_conto_corrente", referencedColumnName = "id_conto_corrente"))
//	private List<ContoCorrente> listaContiCorrenti;


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
	public Date getDataDiNascita() {
		return dataDiNascita;
	}
	public void setDataDiNascita(Date dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}
	public String getLuogoDiNascita() {
		return luogoDiNascita;
	}
	public void setLuogoDiNascita(String luogoDiNascita) {
		this.luogoDiNascita = luogoDiNascita;
	}
	public Ruolo getRuolo() {
		return ruolo;
	}
	public void setRuolo(Ruolo ruolo) {
		this.ruolo = ruolo;
	}

	public Integer getIdRuolo() {
		return idRuolo;
	}
	public void setIdRuolo(Integer idRuolo) {
		this.idRuolo = idRuolo;
	}



//	public List<ContoCorrente> getListaContiCorrenti() {
//		return listaContiCorrenti;
//	}
//	public void setListaContiCorrenti(List<ContoCorrente> listaContiCorrenti) {
//		this.listaContiCorrenti = listaContiCorrenti;
//	}
	public String getNomeFile() {
		return nomeFile;
	}
	public void setNomeFile(String nomeFile) {
		this.nomeFile = nomeFile;
	}
	public byte[] getContenutoFile() {
		return contenutoFile;
	}
	public void setContenutoFile(byte[] bs) {
		this.contenutoFile = bs;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(contenutoFile);
		result = prime * result + Objects.hash(cognome, dataDiNascita, email, idRuolo, idUtente, luogoDiNascita, nome,
				nomeFile, password, ruolo, tipoContenutoFile);
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
		Utente other = (Utente) obj;
		return Objects.equals(cognome, other.cognome) && Arrays.equals(contenutoFile, other.contenutoFile)
				&& Objects.equals(dataDiNascita, other.dataDiNascita) && Objects.equals(email, other.email)
				&& Objects.equals(idRuolo, other.idRuolo) && Objects.equals(idUtente, other.idUtente)
				&& Objects.equals(luogoDiNascita, other.luogoDiNascita) && Objects.equals(nome, other.nome)
				&& Objects.equals(nomeFile, other.nomeFile) && Objects.equals(password, other.password)
				&& Objects.equals(ruolo, other.ruolo) && Objects.equals(tipoContenutoFile, other.tipoContenutoFile);
	}
	@Override
	public String toString() {
		return "Utente [idUtente=" + idUtente + ", nome=" + nome + ", cognome=" + cognome + ", email=" + email
				+ ", password=" + password + ", dataDiNascita=" + dataDiNascita + ", luogoDiNascita=" + luogoDiNascita
				+ ", idRuolo=" + idRuolo + ", nomeFile=" + nomeFile + ", contenutoFile="
				+ Arrays.toString(contenutoFile) + ", tipoContenutoFile=" + tipoContenutoFile + ", ruolo=" + ruolo
				+ "]";
	}






}