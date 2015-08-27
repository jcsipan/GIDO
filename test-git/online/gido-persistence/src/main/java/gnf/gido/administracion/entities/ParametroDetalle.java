package gnf.gido.administracion.entities;

import gnf.ada.core.persistence.AbstractEntity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="GID_PARAMETRODETALLES")
public class ParametroDetalle extends AbstractEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	@NotNull
	private long idPdetalle;
	private Parametro idParametro;
	private String descripcion;
	private String valor;
	private int estado;
	private Byte optimistLock;
	
	@Id
	@SequenceGenerator(name="ParamDetGenerator", sequenceName="SEC_PARAMETRODETALLES")
	@GeneratedValue(generator="ParamDetGenerator")
	@Column(name="IDPDETALLE")
	public long getIdPdetalle() {
		return idPdetalle;
	}

	public void setIdPdetalle(long idPdetalle) {
		this.idPdetalle = idPdetalle;
	}
	
	@Override
	@Transient
	public Object getId() {
		return idPdetalle;
	}

	@ManyToOne
	@JoinColumn(name="IDPARAMETRO")
	public Parametro getIdParametro() {
		return idParametro;
	}

	public void setIdParametro(Parametro idParametro) {
		this.idParametro = idParametro;
	}

	@Column(name="DESCRIPCION")
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Column(name="VALOR")
	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	@Column(name="ESTADO")
	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	
	@Override
	@Version
	@org.hibernate.annotations.Type(type = "gnf.ada.core.persistence.hibernate.types.VersionByteType")
	@Column(name = "OPTIMIST_LOCK", precision = 2, scale = 0)
	public Byte getOptimistLock() {
		return this.optimistLock;
	}

	@Override
	public void setOptimistLock(Byte optimistLock) {
		this.optimistLock=optimistLock;

	}

	@Override
	@Transient
	public Class<?> getClase() {
		return Parametro.class;
	}
	
	@Override
	public boolean equals(Object other) {
		if ((this == other)) {
			return true;
		}
		if ((other == null)) {
			return false;
		}
		if (!(other instanceof ParametroDetalle)) {
			return false;
		}
		ParametroDetalle castOther = (ParametroDetalle) other;
		return (this.getIdPdetalle() == castOther.getIdPdetalle());
	}

	@Override
	public int hashCode() {
		int result = 31;
		result = 37 * result + (int) getIdPdetalle();

		return result;
	}
}
