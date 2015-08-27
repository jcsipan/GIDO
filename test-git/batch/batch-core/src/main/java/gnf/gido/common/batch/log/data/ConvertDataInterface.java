/**
 * Copyright 2012 GNF
 * @author ivmedina
 *
 */
package gnf.gido.common.batch.log.data;

/**
 * The Interface ConvertDataInterface.
 */
public interface ConvertDataInterface {

	 void add(final String key, final Object value);
	
	 void add(final String key, final Object value, final boolean title);
	
	 void addSeparator();
	
	 Register get(final int index);
	
	 int size();
}
