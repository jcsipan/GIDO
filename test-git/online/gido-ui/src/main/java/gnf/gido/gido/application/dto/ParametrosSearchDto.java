package gnf.gido.gido.application.dto;

import gnf.ada.core.beans.dto.AbstractDto;

public class ParametrosSearchDto extends AbstractDto {
private static final long serialVersionUID = 1L;

private String descripcion;
private String nombre;
	
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
}
