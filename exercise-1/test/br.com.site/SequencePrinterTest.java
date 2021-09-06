package br.com.site;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SequencePrinterTest {

	private static SequencePrinter sequencePrinter;
	static final private String TEXT_DIVISIBLE_BY_15 = "Visual Nuts";
	static final private String TEXT_DIVISIBLE_BY_5 = "Nuts";
	static final private String TEXT_DIVISIBLE_BY_3 = "Visual";

	static final private int totalElements = 100;

	@BeforeClass
	public static void init() {
		sequencePrinter = new SequencePrinter(totalElements);
		sequencePrinter.generate();
	}

	@Test
	public void shouldBePrintedCorrect() {
		List<String> sequence = sequencePrinter.getAsList();
		assertEquals(totalElements, sequence.size());
		assertEquals("1", sequence.get(0));
		assertEquals(TEXT_DIVISIBLE_BY_3, sequence.get(2));
		assertEquals(TEXT_DIVISIBLE_BY_5, sequence.get(4));
		assertEquals(TEXT_DIVISIBLE_BY_15, sequence.get(14));
		assertEquals(TEXT_DIVISIBLE_BY_5, sequence.get(totalElements - 1));
	}

	@Test
	public void shouldBeDivisibleByThree() {
		assertTrue(sequencePrinter.isDivisibleBy3(3));
		assertTrue(sequencePrinter.isDivisibleBy3(33));
	}

	@Test
	public void shouldNotBeDivisibleByThree() {
		assertFalse(sequencePrinter.isDivisibleBy3(5));
		assertFalse(sequencePrinter.isDivisibleBy3(94));
	}

	@Test
	public void shouldBeDivisibleByFive() {
		assertTrue(sequencePrinter.isDivisibleBy5(5));
		assertTrue(sequencePrinter.isDivisibleBy5(25));
	}

	@Test
	public void shouldNotBeDivisibleByFive() {
		assertFalse(sequencePrinter.isDivisibleBy5(9));
		assertFalse(sequencePrinter.isDivisibleBy5(41));
	}

	@Test
	public void shouldBeDivisibleByFifteen() {
		assertTrue(sequencePrinter.isDivisibleBy15(30));
		assertTrue(sequencePrinter.isDivisibleBy15(90));
	}

	@Test
	public void shouldNotBeDivisibleByFifteen() {
		assertFalse(sequencePrinter.isDivisibleBy15(9));
		assertFalse(sequencePrinter.isDivisibleBy15(41));
	}
}
