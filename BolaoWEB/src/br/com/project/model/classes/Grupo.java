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
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;
import br.com.project.anotation.IdentificaCampoPesquisa;

@Audited
@AuditTable(value = "grupo_aud")
@Entity
@Table( name = "grupos", uniqueConstraints = 
		@UniqueConstraint(columnNames =  {"nome"})
)
public class Grupo implements Serializable {

	private static final long serialVersionUID = 1L;
	@IdentificaCampoPesquisa(campoConsulta = "id_grupo",descricaoCampo = "Código")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_grupo", nullable = true)
	private long id;
	@IdentificaCampoPesquisa(campoConsulta = "nome",descricaoCampo = "Nome do Grupo")
	@Column(unique = true,nullable = true)
	private String nome;
	@Basic
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cambista", nullable=true)
	@ForeignKey(name = "cambista_grupofk")
	@Column(nullable = true)
	private Cambista cambista;
	@Column(nullable = true)
	private int campeonato;
	@Column(nullable = true)
	private double valorPorLance;
	
	@Version
	@Column(name = "versionNum")
	private int versionNum;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Cambista getCambista() {
		return cambista;
	}

	public void setCambista(Cambista cambista) {
		this.cambista = cambista;
	}

	public int getCampeonato() {
		return campeonato;
	}

	public void setCampeonato(int campeonato) {
		this.campeonato = campeonato;
	}

	public double getValorPorLance() {
		return valorPorLance;
	}

	public void setValorPorLance(double valorPorLance) {
		this.valorPorLance = valorPorLance;
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
		Grupo other = (Grupo) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
}
