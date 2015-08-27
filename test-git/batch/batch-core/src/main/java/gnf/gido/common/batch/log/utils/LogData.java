package gnf.gido.common.batch.log.utils;

import java.io.Serializable;

/**
 * The Class LogData.
 */
public final class LogData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String key;

	private String value;

	private boolean title;

	private boolean separator;

	/**
	 * Instantiates a new log data.
	 */
	public LogData() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Instantiates a new log data.
	 * 
	 * @param key the key
	 * @param value the value
	 */
	public LogData(final String key, final String value) {
		this(key, value, false, false);
	}

	/**
	 * Instantiates a new log data.
	 * 
	 * @param key the key
	 * @param value the value
	 * @param title the title
	 * @param separator the separator
	 */
	public LogData(final String key, final String value, final boolean title, final boolean separator) {
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
	public String getValue() {
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
