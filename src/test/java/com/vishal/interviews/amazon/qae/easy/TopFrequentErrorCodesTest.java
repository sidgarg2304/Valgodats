package com.vishal.interviews.amazon.qae.easy;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TopFrequentErrorCodesTest {

	TopFrequentErrorCodes topFrequentErrorCodes;

	@Before
	public void setUp() {
		topFrequentErrorCodes = new TopFrequentErrorCodes();
		Assert.assertNotNull(topFrequentErrorCodes);
	}

	@Test
	public void testTopKErrorCodesNullInput() {
		List<Integer> result = topFrequentErrorCodes.topKErrorCodes(null, 10);
		Assert.assertNotNull(result);
		Assert.assertTrue(result.isEmpty());
	}

	@Test
	public void testTopKErrorCodesEmptyInput() {
		List<Integer> result = topFrequentErrorCodes.topKErrorCodes(new ArrayList<>(), 10);
		Assert.assertNotNull(result);
		Assert.assertTrue(result.isEmpty());
	}

	@Test
	public void testTopKErrorCodesLesserInput() {

		List<Integer> errorCodes = new ArrayList<>();
		errorCodes.add(500);
		errorCodes.add(304);
		errorCodes.add(304);
		errorCodes.add(404);
		errorCodes.add(404);
		errorCodes.add(404);

		List<Integer> result = topFrequentErrorCodes.topKErrorCodes(errorCodes, 10);
		
		Assert.assertNotNull(result);
		Assert.assertFalse(result.isEmpty());
		Assert.assertEquals(result.size(), 3);
		Assert.assertEquals(result.get(0), Integer.valueOf(404));
		Assert.assertEquals(result.get(1), Integer.valueOf(304));
		Assert.assertEquals(result.get(2), Integer.valueOf(500));
	}

	@Test
	public void testTopKErrorCodes() {
		List<Integer> errorCodes = new ArrayList<>();
		errorCodes.add(500);
		errorCodes.add(304);
		errorCodes.add(304);
		errorCodes.add(404);
		errorCodes.add(404);
		errorCodes.add(404);

		List<Integer> result = topFrequentErrorCodes.topKErrorCodes(errorCodes, 2);

		Assert.assertNotNull(result);
		Assert.assertFalse(result.isEmpty());
		Assert.assertEquals(result.size(), 2);
		Assert.assertEquals(result.get(0), Integer.valueOf(404));
		Assert.assertEquals(result.get(1), Integer.valueOf(304));
	}

}
