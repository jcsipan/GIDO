/**
 * Copyright 2011 GNF
 * @author ivmedina
 *
 */
package gnf.gido.common.batch.log.data;


/**
 * The Class Register.
 */
public final class Register {
	
	private final String key;

	private final Object value;
	
	private final boolean title;
	
	private final boolean separator; 
	
	/**
	 * Instantiates a new register.
	 * 
	 * @param key the key
	 * @param value the value
	 */
	public Register(final String key, final Object value) {
		this(key, value, false, false);
	}

	/**
	 * Instantiates a new register.
	 * 
	 * @param key the key
	 * @param value the value
	 * @param title the title
	 * @param separator the separator
	 */
	public Register(final String key, final Object value, final boolean title, final boolean separator) {
		super();
		this.key = key;
		this.value = value;
		this.title = title;
		this.separator = separator;
	}
	
	/**
	 * Gets the key.
	 * 
	 * @return the key
	 */
	public String getKey() {
		return key;
	}
	
	/**
	 * Gets the value.
	 * 
	 * @return the value
	 */
	public Object getValue() {
		return value;
	}

	/**
	 * Checks if is title.
	 * 
	 * @return true, if is title
	 */
	public boolean isTitle() {
		return title;
	}
	
	/**
	 * Checks if is separator.
	 * 
	 * @return true, if is separator
	 */
	public boolean isSeparator() {
		return separator;
	}
}
