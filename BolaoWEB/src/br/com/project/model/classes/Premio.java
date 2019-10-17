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

@Audited
@AuditTable(value = "premios_aud")
@Entity
@Table(name = "premios")
public class Premio implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_premio")
	private long id;
	@Basic
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "conta", nullable=false)
	@ForeignKey(name = "conta_premiofk")
	private ContaBancaria contaBancaria;
	@Basic
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "lance", nullable=false)
	@ForeignKey(name = "lance_premiofk")
	private Lance lance;
	@Column(nullable = false)
	private int posicao;
	@Column(nullable = false)
	private double valor;
	@Column(nullable = false)
	private boolean pago;
	@Column(nullable = false)
	private boolean confirmaPagamento;
	
	@Version
	@Column(name = "versionNum")
	private int versionNum;

	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public ContaBancaria getContaBancaria() {
		return contaBancaria;
	}
	public void setContaBancaria(ContaBancaria contaBancaria) {
		this.contaBancaria = contaBancaria;
	}
	public Lance getLance() {
		return lance;
	}
	public void setLance(Lance lance) {
		this.lance = lance;
	}
	public int getPosicao() {
		return posicao;
	}
	public void setPosicao(int posicao) {
		this.posicao = posicao;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public boolean isPago() {
		return pago;
	}
	public void setPago(boolean pago) {
		this.pago = pago;
	}
	public boolean isConfirmaPagamento() {
		return confirmaPagamento;
	}
	public void setConfirmaPagamento(boolean confirmaPagamento) {
		this.confirmaPagamento = confirmaPagamento;
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
		Premio other = (Premio) obj;
		if (id != other.id)
			return false;
		return true;
	}
}
