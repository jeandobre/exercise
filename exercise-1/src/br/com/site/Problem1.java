package br.com.site;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem1 {

	static final private String TEXT_DIVISIBLE_BY_15 = "Visual Nuts";
	static final private String TEXT_DIVISIBLE_BY_5 = "Nuts";
	static final private String TEXT_DIVISIBLE_BY_3 = "Visual";

	private final Integer FIRST_NUMBER = 1;
	private final Integer lastNumber;

	private List<String> out;

	public Problem1(Integer lastNumber) {
		this.lastNumber = lastNumber;
	}

	void generate() {
		this.out = new ArrayList<>();
		for(int count = FIRST_NUMBER; count <= lastNumber; count++) {
			String item = String.valueOf(count);
			if(isDivisibleBy15(count)) item = TEXT_DIVISIBLE_BY_15;
			else if(isDivisibleBy5(count)) item = TEXT_DIVISIBLE_BY_5;
			else if(isDivisibleBy3(count)) item = TEXT_DIVISIBLE_BY_3;

			this.out.add(item);
		}
	}

	void printLn() {
		this.out.forEach(System.out::println);
	}

	protected List<String> getAsList() {
		return Collections.unmodifiableList(out);
	}

	protected boolean isDivisibleBy15(int number) {
		return isDisibleBy(15, number);
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