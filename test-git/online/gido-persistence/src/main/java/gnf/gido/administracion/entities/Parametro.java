package gnf.gido.administracion.entities;

import gnf.ada.core.persistence.AbstractEntity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="GID_PARAMETROS")
public class Parametro extends AbstractEntity implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	
	@NotNull
	private long idParametro;
	private String nombre;
	private String descripcion;
	private int agrupable;
	private int estado;
	private Byte optimistLock;
	
	private List<ParametroDetalle> detalles;
	
	@Id
	@SequenceGenerator(name="parametroGenerator",sequenceName="SEC_PARAMETROS" )
	@GeneratedValue(generator="parametroGenerator")
	@Column(name="IDPARAMETRO", nullable=false)
	public long getIdParametro() {
		return idParametro;
	}
	
	@Override
	@Transient
	public Object getId() {
		return idParametro;
	}

	public void setIdParametro(long idParametro) {
		this.idParametro = idParametro;
	}

	@Column(name="NOMBRE", nullable=false)
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name="DESCRIPCION", nullable=true)
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Column(name="AGRUPABLE", nullable=false)
	public int getAgrupable() {
		return agrupable;
	}

	public void setAgrupable(int agrupable) {
		this.agrupable = agrupable;
	}

	@Column(name="ESTADO", nullable=false)
	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	@OneToMany(mappedBy="idParametro")
	public List<ParametroDetalle> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<ParametroDetalle> detalles) {
		this.detalles = detalles;
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
		if (!(other instanceof Parametro)) {
			return false;
		}
		Parametro castOther = (Parametro) other;
		return (this.getIdParametro() == castOther.getIdParametro());
	}

	@Override
	public int hashCode() {
		int result = 31;
		result = 37 * result + (int) getIdParametro();

		return result;
	}

	

}
