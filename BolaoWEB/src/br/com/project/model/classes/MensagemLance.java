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
import org.hibernate.annotations.ForeignKey;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

@Entity
@Audited
@AuditTable(value = "mensagensLance_aud")
@Table(name = "mensagensLances")
public class MensagemLance implements Serializable {	
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_mensagemLance")
	private long id;
	@Basic
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "lance", nullable=false)
	@ForeignKey(name = "lance_mensagemfk")
	private Lance lance;
	@Basic
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "usuario", nullable=false)
	@ForeignKey(name = "remetente_mensagemfk")
	private Usuario remetente;
	@Column(nullable = false)
	private String texto;

	
	
}
