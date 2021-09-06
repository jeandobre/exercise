package br.com.site;

import org.junit.BeforeClass;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.Assert.*;

public class Problem1Test {

	private static Problem1 problem1;
	static final private String TEXT_DIVISIBLE_BY_15 = "Visual Nuts";
	static final private String TEXT_DIVISIBLE_BY_5 = "Nuts";
	static final private String TEXT_DIVISIBLE_BY_3 = "Visual";

	static final private int totalElements = 100;

	@BeforeClass
	public static void init() {
		problem1 = new Problem1(totalElements);
		problem1.generate();
	}

	@Test
	public void shouldBePrintedCorrect() {
		List<String> sequence = problem1.getAsList();
		assertEquals(totalElements, sequence.size());
		assertEquals("1", sequence.get(0));
		assertEquals(TEXT_DIVISIBLE_BY_3, sequence.get(2));
		assertEquals(TEXT_DIVISIBLE_BY_5, sequence.get(4));
		assertEquals(TEXT_DIVISIBLE_BY_15, sequence.get(14));
		assertEquals(TEXT_DIVISIBLE_BY_5, sequence.get(totalElements - 1));
	}

	@Test
	public void shouldBeDivisibleByThree() {
		assertTrue(problem1.isDivisibleBy3(3));
		assertTrue(problem1.isDivisibleBy3(33));
	}

	@Test
	public void shouldNotBeDivisibleByThree() {
		assertFalse(problem1.isDivisibleBy3(5));
		assertFalse(problem1.isDivisibleBy3(94));
	}

	@Test
	public void shouldBeDivisibleByFive() {
		assertTrue(problem1.isDivisibleBy5(5));
		assertTrue(problem1.isDivisibleBy5(25));
	}

	@Test
	public void shouldNotBeDivisibleByFive() {
		assertFalse(problem1.isDivisibleBy5(9));
		assertFalse(problem1.isDivisibleBy5(41));
	}

	@Test
	public void shouldBeDivisibleByFifteen() {
		assertTrue(problem1.isDivisibleBy15(30));
		assertTrue(problem1.isDivisibleBy15(90));
	}

	@Test
	public void shouldNotBeDivisibleByFifteen() {
		assertFalse(problem1.isDivisibleBy15(9));
		assertFalse(problem1.isDivisibleBy15(41));
	}
}
