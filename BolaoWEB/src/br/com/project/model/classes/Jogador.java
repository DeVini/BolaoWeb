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
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;
import br.com.project.anotation.IdentificaCampoPesquisa;


@Audited
@AuditTable(value = "jogadores_aud")
@Entity
@Table(name = "jogadores", uniqueConstraints = 
	{
			@UniqueConstraint(name = "uniques_jogador", columnNames = {"nome", "cpf"})
	}	
)
public class Jogador implements Serializable {

	private static final long serialVersionUID = 1L;
	@IdentificaCampoPesquisa(campoConsulta = "id_jogador",descricaoCampo = "Código")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_jogador", nullable = true)
	private long id;
	@IdentificaCampoPesquisa(campoConsulta = "nome",descricaoCampo = "Nome do Jogador", principal =  1)
	@Column(nullable = true,unique = true)
	private String nome;
	@IdentificaCampoPesquisa(campoConsulta = "cpf",descricaoCampo = "CPF")
	@Column(nullable = true,unique = true)
	private long cpf;
	@IdentificaCampoPesquisa(campoConsulta = "whatsapp",descricaoCampo = "WhatsApp")
	@Column(nullable = true)
	private int whatsapp;
	@Transient
	private byte[] foto;
	@Basic
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "usuario", nullable=true)
	@ForeignKey(name = "usuario_jogadorfk")
	private Usuario usuario;
	
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
	public long getCpf() {
		return cpf;
	}
	public void setCpf(long cpf) {
		this.cpf = cpf;
	}
	public int getWhatsapp() {
		return whatsapp;
	}
	public void setWhatsapp(int whatsapp) {
		this.whatsapp = whatsapp;
	}
	public byte[] getFoto() {
		return foto;
	}
	public void setFoto(byte[] foto) {
		this.foto = foto;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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
		Jogador other = (Jogador) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
}