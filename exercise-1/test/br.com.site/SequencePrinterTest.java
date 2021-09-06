package br.com.site;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class SequencePrinterTest {

	private static SequencePrinter sequencePrinter;
	static final private String TEXT_DIVISIBLE_BY_15 = "Visual Nuts";
	static final private String TEXT_DIVISIBLE_BY_5 = "Nuts";
	static final private String TEXT_DIVISIBLE_BY_3 = "Visual";

	static final private int totalElements = 100;

	private final ByteArrayOutputStream outputContent = new ByteArrayOutputStream();
	private final PrintStream originalOutput = System.out;

	@BeforeClass
	public static void init() {
		sequencePrinter = new SequencePrinter(totalElements);
	}

	@Before
	public void setUpStream() {
		System.setOut(new PrintStream(outputContent));
	}

	@After
	public void restoreStream(){
		System.setOut(originalOutput);
	}

	@Test
	public void shouldBePrintedCorrect() {
		sequencePrinter.print();
		String[] sequence = outputContent.toString().split("\n");
		assertEquals(totalElements, sequence.length);
		assertEquals("1", sequence[0]);
		assertEquals(TEXT_DIVISIBLE_BY_3, sequence[2]);
		assertEquals(TEXT_DIVISIBLE_BY_5, sequence[4]);
		assertEquals(TEXT_DIVISIBLE_BY_15, sequence[14]);
		assertEquals(TEXT_DIVISIBLE_BY_5, sequence[totalElements - 1]);
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
