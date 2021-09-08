package br.com.site.common;

public class Assertion {

	protected Assertion() {
		super();
	}

	protected void assertArgumentNotNull(Object anObject, String aMessage) {
		if (anObject == null) {
			throw new IllegalArgumentException(aMessage);
		}
	}
}
