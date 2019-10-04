package br.com.project.model.classes;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;

import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;
import br.com.project.anotation.IdentificaCampoPesquisa;


@Audited
@AuditTable(value = "usuarios_aud")
@Entity
@Table(name = "usuarios", uniqueConstraints = 
	{
		@UniqueConstraint(name = "uniques_usuario", columnNames = {"username","email"})
	}
)
public class Usuario implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@IdentificaCampoPesquisa(campoConsulta = "id_usuario", descricaoCampo = "Código")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_usuario")
	private long id;
	@Column(nullable = true )
	private String password;
	@IdentificaCampoPesquisa(campoConsulta = "username", descricaoCampo = "Username", principal =  1)
	@Column(nullable = true )
	private String username;
	@IdentificaCampoPesquisa(campoConsulta = "acesso", descricaoCampo = "Permissão" )
	@Column(nullable = true )
	@Enumerated(EnumType.STRING)
	private TipoAcesso acesso;
	@IdentificaCampoPesquisa(campoConsulta = "email", descricaoCampo = "Email")
	@Column(nullable = true)
	private String email;
	@Version
	@Column(name = "versionNum")
	private int versionNum;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public TipoAcesso getAcesso() {
		return acesso;
	}
	public void setAcesso(TipoAcesso acesso) {
		this.acesso = acesso;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
		Usuario other = (Usuario) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
}