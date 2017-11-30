import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({})
public class Tests {

	// Processing string original by comparing with appearance string tests

	@Test
	public void processingString1Test() {
		String sourceString = "sometextsome";
		String appString = "some";
		String expString = "text";
		String res = Tasks.interviewStringTest(sourceString, appString);
		assertEquals(expString, res);
	}

	@Test
	public void processingString2Test() {
		String sourceString = "2323sometextsomesdsd";
		String appString = "some";
		String expString = "text";
		String res = Tasks.interviewStringTest(sourceString, appString);
		assertEquals(expString, res);
	}

	@Test
	public void processingString3Test() {
		String sourceString = "2323textsdsd";
		String appString = "some";
		String expString = "";
		String res = Tasks.interviewStringTest(sourceString, appString);
		assertEquals(expString, res);
	}

	// Check the amount of appearance a certain number in array tests

	@Test
	public void checkArray1Test() {

		int[] sourceArray = { 3, 1, 3, 1, 3 };
		boolean result = Tasks.interviewArrayTest(sourceArray, 3, 3);
		assertTrue(result);
	}

	@Test
	public void checkArray2Test() {

		int[] sourceArray = { 5, 1, 5, 5 };
		boolean result = Tasks.interviewArrayTest(sourceArray, 5, 2);
		assertFalse(result);

	}

	@Test
	public void checkArray3Test() {

		int[] sourceArray = { 3, 4, 3, 3, 4 };
		boolean result = Tasks.interviewArrayTest(sourceArray, 4, 2);
		assertTrue(result);
	}

	@Test
	public void checkArray4Test() {

		int[] sourceArray = { 3, 4, 3, 3, 4 };
		boolean result = Tasks.interviewArrayTest(sourceArray, 3, 3);
		assertFalse(result);

	}

	// Resuction tests

	@Test
	public void makeResursion1Test() {

		int result = Tasks.interviewRecursionTest(0);
		assertEquals(0, result);
	}

	@Test
	public void makeResursion2Test() {

		int result = Tasks.interviewRecursionTest(1);
		assertEquals(1, result);
	}

	@Test
	public void makeResursion3Test() {

		int result = Tasks.interviewRecursionTest(2);
		assertEquals(3, result);
	}

	// Convert to Map tests

	@Test
	public void convertToMap1Test() {
		String[] sourceArray = { "a", "bb", "a", "bb" };
		Map<String, Integer> result = Tasks.interviewMapTest(sourceArray);
		Map<String, Integer> expect = new HashMap<String, Integer>();
		expect.put("a", 2);
		expect.put("bb", 2);
		assertEquals(expect, result);
	}

	@Test
	public void convertToMap2Test() {
		String[] sourceArray = { "this", "and", "that", "and" };
		Map<String, Integer> result = Tasks.interviewMapTest(sourceArray);
		Map<String, Integer> expect = new HashMap<String, Integer>();
		expect.put("this", 1);
		expect.put("and", 2);
		expect.put("that", 1);
		assertEquals(expect, result);
	}

	@Test
	public void convertToMap3Test() {
		String[] sourceArray = { "code", "code", "code", "bug" };
		Map<String, Integer> result = Tasks.interviewMapTest(sourceArray);
		Map<String, Integer> expect = new HashMap<String, Integer>();
		expect.put("code", 3);
		expect.put("bug", 1);
		assertEquals(expect, result);
	}

	// Application Task Test

	@Test
	public void encodingTest() {
		String sourceSymbol = "G";
		String result = Application.toCustomEncoding(sourceSymbol);
		String expect = "00 0 0 0 00 000 0 000 ";
		assertEquals(expect, result);
	}

}
