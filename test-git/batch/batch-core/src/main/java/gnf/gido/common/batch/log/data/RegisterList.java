/**
 * Copyright 2011 GNF
 * @author ivmedina
 * 
 */
package gnf.gido.common.batch.log.data;

import java.util.ArrayList;
import java.util.List;

/**
 * The Class RegisterList.
 */
public final class RegisterList {

	private final List<Register> list = new ArrayList<Register>();

	/**
	 * Adds the.
	 * 
	 * @param register the register
	 */
	public void add(final Register register) {
		getList().add(register);
	}

	/**
	 * Gets the.
	 * 
	 * @param index the index
	 * @return the register
	 */
	public Register get(final int index) {
		return getList().get(index);
	}

	/**
	 * Size.
	 * 
	 * @return the int
	 */
	public int size() {
		return getList().size();
	}

	private List<Register> getList() {
		return list;
	}
}
