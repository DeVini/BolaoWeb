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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;
import br.com.project.anotation.IdentificaCampoPesquisa;
@Audited
@AuditTable(value = "bolao_aud")
@Entity
@Table( name = "boloes")
public class Bolao implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@IdentificaCampoPesquisa(campoConsulta = "id_grupo",descricaoCampo = "Código")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_bolao")
	private long id;
	@Basic
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "grupo", nullable=false)
	@ForeignKey(name = "grupo_bolaofk")
	private Grupo grupo;
	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date dataEmissao;
	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date dataExpiracao;
	@Column(nullable = false)
	private int rodada;
	
	@Version
	@Column(name = "versionNum")
	private int versionNum;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Grupo getGrupo() {
		return grupo;
	}
	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}
	public Date getDataEmissao() {
		return dataEmissao;
	}
	public void setDataEmissao(Date dataEmissao) {
		this.dataEmissao = dataEmissao;
	}
	public Date getDataExpiracao() {
		return dataExpiracao;
	}
	public void setDataExpiracao(Date dataExpiracao) {
		this.dataExpiracao = dataExpiracao;
	}
	public int getRodada() {
		return rodada;
	}
	public void setRodada(int rodada) {
		this.rodada = rodada;
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
		Bolao other = (Bolao) obj;
		if (id != other.id)
			return false;
		return true;
	}
}