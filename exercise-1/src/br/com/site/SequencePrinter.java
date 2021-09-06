package br.com.site;

public class SequencePrinter {

	static final private String TEXT_DIVISIBLE_BY_3_AND_5 = "Visual Nuts";
	static final private String TEXT_DIVISIBLE_BY_5 = "Nuts";
	static final private String TEXT_DIVISIBLE_BY_3 = "Visual";

	private static final Integer FIRST_NUMBER = 1;
	private final Integer maxNumber;

	public SequencePrinter(Integer maxNumber) {
		this.maxNumber = maxNumber;
	}

	void print() {
		for(int count = FIRST_NUMBER; count <= maxNumber; count++) {
			String item = String.valueOf(count);
			if(isDivisibleBy3And5(count)) item = TEXT_DIVISIBLE_BY_3_AND_5;
			else if(isDivisibleBy5(count)) item = TEXT_DIVISIBLE_BY_5;
			else if(isDivisibleBy3(count)) item = TEXT_DIVISIBLE_BY_3;

			System.out.println(item);
		}
	}

	protected boolean isDivisibleBy3And5(int number) {
		return isDisibleBy(3, number)
				&& isDisibleBy(5, number);
	}

	protected boolean isDivisibleBy5(int number) {
		return isDisibleBy(5, number);
	}

	protected boolean isDivisibleBy3(int number) {
		return isDisibleBy(3, number);
	}

	private boolean isDisibleBy(int factor, int number) {
		return ((number % factor) == 0);
	}
}