package br.com.site;

import org.junit.BeforeClass;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class SequencePrinterTest {

	private static SequencePrinter sequencePrinter;
	static final private String TEXT_DIVISIBLE_BY_3_AND_5 = "Visual Nuts";
	static final private String TEXT_DIVISIBLE_BY_5 = "Nuts";
	static final private String TEXT_DIVISIBLE_BY_3 = "Visual";

	static final private int totalElements = 100;
	private static String[] sequence;

	@BeforeClass
	public static void init() {
		sequencePrinter = new SequencePrinter(totalElements);

		ByteArrayOutputStream outputContent = new ByteArrayOutputStream();
		PrintStream originalOutput = System.out;
		System.setOut(new PrintStream(outputContent));
		sequencePrinter.print();
		sequence = outputContent.toString().split("\n");
		System.setOut(originalOutput);
	}

	@Test
	public void shouldBeCorrectTotalOfElements() {
		assertEquals(totalElements, sequence.length);
	}

	@Test
	public void shouldBePrintedCorrectlySomeRandomElements() {
		assertEquals("1", sequence[0]);
		assertEquals(TEXT_DIVISIBLE_BY_3, sequence[2]);
		assertEquals(TEXT_DIVISIBLE_BY_5, sequence[4]);
		assertEquals(TEXT_DIVISIBLE_BY_3_AND_5, sequence[14]);
		assertEquals(TEXT_DIVISIBLE_BY_5, sequence[totalElements - 1]);
	}

	@Test
	public void shouldBeCorrectAllNumbersDivisibleBy5() {
		for(int i = 5; (i % 15 != 0) && i <= totalElements; i += 5) {
			assertEquals(TEXT_DIVISIBLE_BY_5, sequence[i - 1]);
		}
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
		assertTrue(sequencePrinter.isDivisibleBy3And5(30));
		assertTrue(sequencePrinter.isDivisibleBy3And5(90));
	}

	@Test
	public void shouldNotBeDivisibleByFifteen() {
		assertFalse(sequencePrinter.isDivisibleBy3And5(9));
		assertFalse(sequencePrinter.isDivisibleBy3And5(41));
	}
}
