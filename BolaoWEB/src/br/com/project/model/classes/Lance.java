package br.com.project.model.classes;

import java.io.Serializable;
import java.util.Date;
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
@AuditTable(value = "Lances_aud")
@Entity
@Table(name = "Lances")
public class Lance implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_lance")
	private long id;
	@Basic
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "jogador", nullable=false)
	@ForeignKey(name = "jogador_lancefk")
	private Jogador jogador;
	@Basic
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "bolao", nullable=false)
	@ForeignKey(name = "bolao_lancefk")
	private Bolao bolao;
	private boolean validado;
	@Column(nullable = false)
	private Date dataHoraEmissao;
	@Column(nullable = false)
	private Date dataHoraExpiracao;
	@Column(nullable = false)
	private String codigoValidacao;
	private byte recibo;
	private boolean finalizado;
	
	@Version
	@Column(name = "versionNum")
	private int versionNum;
	
	public int getVersionNum() {
		return versionNum;
	}
	
	public void setVersionNum(int versionNum) {
		this.versionNum = versionNum;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Jogador getJogador() {
		return jogador;
	}

	public void setJogador(Jogador jogador) {
		this.jogador = jogador;
	}

	public Bolao getBolao() {
		return bolao;
	}

	public void setBolao(Bolao bolao) {
		this.bolao = bolao;
	}

	public boolean isValidado() {
		return validado;
	}

	public void setValidado(boolean validado) {
		this.validado = validado;
	}

	public Date getDataHoraEmissao() {
		return dataHoraEmissao;
	}

	public void setDataHoraEmissao(Date dataHoraEmissao) {
		this.dataHoraEmissao = dataHoraEmissao;
	}

	public Date getDataHoraExpiracao() {
		return dataHoraExpiracao;
	}

	public void setDataHoraExpiracao(Date dataHoraExpiracao) {
		this.dataHoraExpiracao = dataHoraExpiracao;
	}

	public String getCodigoValidacao() {
		return codigoValidacao;
	}

	public void setCodigoValidacao(String codigoValidacao) {
		this.codigoValidacao = codigoValidacao;
	}

	public byte getRecibo() {
		return recibo;
	}

	public void setRecibo(byte recibo) {
		this.recibo = recibo;
	}

	public boolean isFinalizado() {
		return finalizado;
	}

	public void setFinalizado(boolean finalizado) {
		this.finalizado = finalizado;
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
		Lance other = (Lance) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
}