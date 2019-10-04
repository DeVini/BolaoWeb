package br.com.project.model.classes;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;


@Audited
@AuditTable(value = "contasBancarias_aud")
@Entity
@Table( name = "contasBancarias", uniqueConstraints = 

		{
			@UniqueConstraint(name = "uniques_contas", columnNames = {"agencia","conta"})
		}
)
public class ContaBancaria implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy =  GenerationType.AUTO)
	@Column(name = "id_conta", nullable =  true)
	private long id;
	@Column(unique = true, nullable =  true)
	private int agencia;
	@Column(unique = true, nullable =  true)
	private int conta;
	@Column(nullable = true)
	private String banco;
	
	@Version
	@Column(name = "versionNum")
	private int versionNum;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public int getConta() {
		return conta;
	}

	public void setConta(int conta) {
		this.conta = conta;
	}

	public String getBanco() {
		return banco;
	}

	public void setBanco(String banco) {
		this.banco = banco;
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
		ContaBancaria other = (ContaBancaria) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
}
