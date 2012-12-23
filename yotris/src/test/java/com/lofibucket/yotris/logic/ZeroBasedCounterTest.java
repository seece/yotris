
package com.lofibucket.yotris.logic;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class ZeroBasedCounterTest {

	ZeroBasedCounter counter;

	@Before
	public void createCounter() {
		counter = new ZeroBasedCounter(1, 10);
	}

    public ZeroBasedCounterTest() {
    }

	@Test
	public void initialValueIsCorrect() {
		assertEquals(1, counter.getValue());
	}

	@Test
	public void isZeroWorks() {
		ZeroBasedCounter zero_counter = new ZeroBasedCounter(0, 10);
		assertTrue(zero_counter.isZero());
	}
	
	@Test
	public void singleDecreaseWorks() {
		counter.decrease();
		assertTrue(counter.isZero());
	}

	@Test
	public void multipleDecreasesWork() {
		int amount = 5;

		for (int i=0;i<amount;i++) {
			counter.decrease();
		}

		assertEquals(7, counter.getValue());
	}

	@Test
	public void setValueWorks() {
		counter.setValue(8);
		assertEquals(8, counter.getValue());
		counter.setValue(0);
		assertEquals(0, counter.getValue());
		counter.setValue(-1);
		assertEquals(counter.getUpperLimit(), counter.getValue());
	}

	@Test
	public void limitsAreCorrect() {
		assertEquals(10, counter.getUpperLimit());
		assertEquals(0, counter.getLowerLimit());
	}


}