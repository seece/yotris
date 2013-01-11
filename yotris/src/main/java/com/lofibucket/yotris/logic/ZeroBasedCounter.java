
package com.lofibucket.yotris.logic;


/**
 * A simple counter class that wraps around when its value is less than zero.
 * The counter can only decrease.
 */
public class ZeroBasedCounter {
	/**
	 * Current value of this counter.
	 */
	private int value;
	/**
	 * When value hits this limit, it will be set to upperLimit 
	 */
	private int lowerLimit;
	/**
	 * Value will be set to this when it hits the lowerLimit
	 */
	private int upperLimit;

	/**
	 *	The default constructor. The limit values are inclusive.
	 * @param value	The initial value for the counter
	 * @param upperLimit	The limit to which the value wraps around to when
	 * under zero
	 */
	public ZeroBasedCounter(int value, int upperLimit) {
		this.value = value;
		this.lowerLimit = 0;
		this.upperLimit = upperLimit;
		checkLimit();
	}

	/**
	 *	Returns the counter value
	 * @return	the current counter value
	 */
	public int getValue() {
		return value;
	}

	/**
	 *
	 * @return	counters upper limit
	 */
	public int getUpperLimit() {
		return upperLimit;
	}

	/**
	 * 
	 * @return counters lower limit
	 */
	public int getLowerLimit() {
		return lowerLimit;
	}

	/**
	 *
	 * @param new_value
	 */
	public void setValue(int new_value) {
		this.value = new_value;	
		checkLimit();
	}

	/**
	 *	Decreases the counter by one, wraps around if necessary
	 */
	public void decrease() {
		value--;
		checkLimit();
	}

	/**
	 * Tells if the counter value is zero
	 * @return true if value is zero, otherwise false
	 */
	public boolean isZero() {
		return value==0;
	}

	/**
	 * Sets the counter upper limit.
	 * @param newLimit The new upper limit to use.
	 */
	public void setLimit(int newLimit) {
		upperLimit = newLimit;
	}

	/**
	 * Checks if the value has gone under the lower limit, and resets it to 
	 * the upper limit if necessary.
	 */
	private void checkLimit() {
		if (value < lowerLimit) {
			value = upperLimit;
		}
	}

}
