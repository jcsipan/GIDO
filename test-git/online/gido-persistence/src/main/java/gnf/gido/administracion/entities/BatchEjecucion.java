package gnf.gido.administracion.entities;

import gnf.ada.core.persistence.AbstractEntity;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;

/**
 * The persistent class for the GID_BATCH_EJECUCIONES database table.
 * 
 */
@Entity
@Table(name = "GID_BATCH_EJECUCIONES")
@NamedQuery(name = "BatchEjecucion.findAll", query = "SELECT b FROM BatchEjecucion b")
public class BatchEjecucion extends AbstractEntity implements
		java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private long idbatch;
	private String nombre;
	private String descripcion;
	private BigDecimal diaEjecucion;
	private int estado;
	private Timestamp fUltimaEjecucion;
	private BigDecimal registroUltimaEjeccucion;
	private String rutaArchivo;
	private String tipoEjecucion;
	private Byte optimistLock;

	public BatchEjecucion() {
	}

	@Id
	@SequenceGenerator(name = "idBatchGenerator", sequenceName = "GID_S_ID_BATCH")
	@GeneratedValue(generator = "idBatchGenerator")
	@Column(name = "IDBATCH")
	public long getIdbatch() {
		return this.idbatch;
	}

	public void setIdbatch(long idbatch) {
		this.idbatch = idbatch;
	}

	@Column(name = "NOMBRE")
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "DESCRIPCION")
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Column(name = "DIA_EJECUCION")
	public BigDecimal getDiaEjecucion() {
		return this.diaEjecucion;
	}

	public void setDiaEjecucion(BigDecimal diaEjecucion) {
		this.diaEjecucion = diaEjecucion;
	}

	@Column(name = "ESTADO")
	public int getEstado() {
		return this.estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	@Column(name = "F_ULTIMA_EJECUCION")
	public Timestamp getFUltimaEjecucion() {
		return this.fUltimaEjecucion;
	}

	public void setFUltimaEjecucion(Timestamp fUltimaEjecucion) {
		this.fUltimaEjecucion = fUltimaEjecucion;
	}
	
	@Column(name = "REGISTRO_ULTIMA_EJECCUCION")
	public BigDecimal getRegistroUltimaEjeccucion() {
		return this.registroUltimaEjeccucion;
	}

	public void setRegistroUltimaEjeccucion(BigDecimal registroUltimaEjeccucion) {
		this.registroUltimaEjeccucion = registroUltimaEjeccucion;
	}

	@Column(name = "RUTA_ARCHIVO")
	public String getRutaArchivo() {
		return this.rutaArchivo;
	}

	public void setRutaArchivo(String rutaArchivo) {
		this.rutaArchivo = rutaArchivo;
	}

	@Column(name = "TIPO_EJECUCION")
	public String getTipoEjecucion() {
		return this.tipoEjecucion;
	}

	public void setTipoEjecucion(String tipoEjecucion) {
		this.tipoEjecucion = tipoEjecucion;
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
		this.optimistLock = optimistLock;

	}

	@Override
	@Transient
	public Class<?> getClase() {
		return BatchEjecucion.class;
	}

	@Override
	@Transient
	public Object getId() {
		return descripcion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result
				+ ((diaEjecucion == null) ? 0 : diaEjecucion.hashCode());
		result = prime
				* result
				+ ((fUltimaEjecucion == null) ? 0 : fUltimaEjecucion.hashCode());
		result = prime * result + (int) (idbatch ^ (idbatch >>> 32));
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result
				+ ((optimistLock == null) ? 0 : optimistLock.hashCode());
		result = prime
				* result
				+ ((registroUltimaEjeccucion == null) ? 0
						: registroUltimaEjeccucion.hashCode());
		result = prime * result
				+ ((rutaArchivo == null) ? 0 : rutaArchivo.hashCode());
		result = prime * result
				+ ((tipoEjecucion == null) ? 0 : tipoEjecucion.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object other) {
		if ((this == other)) {
			return true;
		}
		if ((other == null)) {
			return false;
		}
		if (!(other instanceof BatchEjecucion)) {
			return false;
		}
		BatchEjecucion castOther = (BatchEjecucion) other;
		return (this.getIdbatch() == castOther.getIdbatch());
	}

}