package gnf.gido.interfaces.batch.beans;

/**
 * The Class ResultGreenBookReader.
 */
public class ResultGidoLoadSupplyDebReader {

	private String codEnti;

	private String codOfi;

	private String denoEnti;

	private String denoOfi;

	private String domiOfi;

	private String codPostal;

	private String denoPlaza;

	private String denoProv;

	private Long codComuni;

	private String bic;

	/**
	 * Gets the cod enti.
	 * 
	 * @return the cod enti
	 */
	public String getCodEnti() {
		return codEnti;
	}

	/**
	 * Sets the cod enti.
	 * 
	 * @param codEnti the new cod enti
	 */
	public void setCodEnti(final String codEnti) {
		this.codEnti = codEnti;
	}

	/**
	 * Gets the cod ofi.
	 * 
	 * @return the cod ofi
	 */
	public String getCodOfi() {
		return codOfi;
	}

	/**
	 * Sets the cod ofi.
	 * 
	 * @param codOfi the new cod ofi
	 */
	public void setCodOfi(final String codOfi) {
		this.codOfi = codOfi;
	}

	/**
	 * Gets the deno enti.
	 * 
	 * @return the deno enti
	 */
	public String getDenoEnti() {
		return denoEnti;
	}

	/**
	 * Sets the deno enti.
	 * 
	 * @param denoEnti the new deno enti
	 */
	public void setDenoEnti(final String denoEnti) {
		this.denoEnti = denoEnti;
	}

	/**
	 * Gets the deno ofi.
	 * 
	 * @return the deno ofi
	 */
	public String getDenoOfi() {
		return denoOfi;
	}

	/**
	 * Sets the deno ofi.
	 * 
	 * @param denoOfi the new deno ofi
	 */
	public void setDenoOfi(final String denoOfi) {
		this.denoOfi = denoOfi;
	}

	/**
	 * Gets the domi ofi.
	 * 
	 * @return the domi ofi
	 */
	public String getDomiOfi() {
		return domiOfi;
	}

	/**
	 * Sets the domi ofi.
	 * 
	 * @param domiOfi the new domi ofi
	 */
	public void setDomiOfi(final String domiOfi) {
		this.domiOfi = domiOfi;
	}

	/**
	 * Gets the cod postal.
	 * 
	 * @return the cod postal
	 */
	public String getCodPostal() {
		return codPostal;
	}

	/**
	 * Sets the cod postal.
	 * 
	 * @param codPostal the new cod postal
	 */
	public void setCodPostal(final String codPostal) {
		this.codPostal = codPostal;
	}

	/**
	 * Gets the deno plaza.
	 * 
	 * @return the deno plaza
	 */
	public String getDenoPlaza() {
		return denoPlaza;
	}

	/**
	 * Sets the deno plaza.
	 * 
	 * @param denoPlaza the new deno plaza
	 */
	public void setDenoPlaza(final String denoPlaza) {
		this.denoPlaza = denoPlaza;
	}

	/**
	 * Gets the deno prov.
	 * 
	 * @return the deno prov
	 */
	public String getDenoProv() {
		return denoProv;
	}

	/**
	 * Sets the deno prov.
	 * 
	 * @param denoProv the new deno prov
	 */
	public void setDenoProv(final String denoProv) {
		this.denoProv = denoProv;
	}

	/**
	 * Gets the cod comuni.
	 * 
	 * @return the cod comuni
	 */
	public Long getCodComuni() {
		return codComuni;
	}

	/**
	 * Sets the cod comuni.
	 * 
	 * @param codComuni the new cod comuni
	 */
	public void setCodComuni(final Long codComuni) {
		this.codComuni = codComuni;
	}

	/** {@inheritDoc}
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "GreenBookDto [codComuni=" + codComuni + ", codEnti=" + codEnti + ", codOfi=" + codOfi + ", codPostal=" + codPostal
				+ ", denoEnti=" + denoEnti + ", denoOfi=" + denoOfi + ", denoPlaza=" + denoPlaza + ", denoProv=" + denoProv + ", domiOfi="
				+ domiOfi + ", bic=" + bic + "]";
	}

	public String getBic() {
		return bic;
	}

	public void setBic(final String bic) {
		this.bic = bic;
	}
}
