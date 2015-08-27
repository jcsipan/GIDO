package gnf.gido.gido.application.dto;

import gnf.ada.core.beans.dto.AbstractDto;


public class ParametroDetalleSearchDto extends AbstractDto {
	
	private static final long serialVersionUID = 1L;
	
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	private String descripcion;
	private String valor;
}
