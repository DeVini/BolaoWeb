package br.com.project.model.classes;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

@Entity
@Audited
@AuditTable(value = "palpites_aud")
@Table(name = "palpites")
public class Palpite implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_palpite")
	private long id;
	@Basic
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "lance", nullable=false)
	@ForeignKey(name = "lance_palpitefk")
	private Lance lance;
	@Column(nullable = false)
	private int timeMandante;
	@Column(nullable = false)
	private int timeVisitante;
	@Column(nullable = false)
	private int placarMandante;
	@Column(nullable = false)
	private int placarVisitante;
	@Column(nullable = false)
	private int jogo;
	private int pontos;
	private boolean corrido;
	
	@Version
	@Column(name = "versionNum")
	private int versionNum;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Lance getLance() {
		return lance;
	}

	public void setLance(Lance lance) {
		this.lance = lance;
	}

	public int getTimeMandante() {
		return timeMandante;
	}

	public void setTimeMandante(int timeMandante) {
		this.timeMandante = timeMandante;
	}

	public int getTimeVisitante() {
		return timeVisitante;
	}

	public void setTimeVisitante(int timeVisitante) {
		this.timeVisitante = timeVisitante;
	}

	public int getPlacarMandante() {
		return placarMandante;
	}

	public void setPlacarMandante(int placarMandante) {
		this.placarMandante = placarMandante;
	}

	public int getPlacarVisitante() {
		return placarVisitante;
	}

	public void setPlacarVisitante(int placarVisitante) {
		this.placarVisitante = placarVisitante;
	}

	public int getJogo() {
		return jogo;
	}

	public void setJogo(int jogo) {
		this.jogo = jogo;
	}

	public int getPontos() {
		return pontos;
	}

	public void setPontos(int pontos) {
		this.pontos = pontos;
	}

	public boolean isCorrido() {
		return corrido;
	}

	public void setCorrido(boolean corrido) {
		this.corrido = corrido;
	}

	public int getVersionNum() {
		return versionNum;
	}

	public void setVersionNum(int versionNum) {
		this.versionNum = versionNum;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
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
		Palpite other = (Palpite) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
