package br.com.site.domain;

import static org.junit.Assert.*;
import br.com.site.domain.Country;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CountryTest {

	@Test
	public void shouldBePopulatedWithSuccess() {
		List<Country> countries = new ArrayList<>();
		countries.add(new Country("US", "en"));
		countries.add(new Country("BE", "nl", "nf", "de"));
		countries.add(new Country("NL", "nl", "fy"));
		countries.add(new Country("DE", "de"));
		countries.add(new Country("ES", "es"));

		assertEquals(5, countries.size());
		assertEquals("US", countries.get(0).name());
		assertEquals("[en]", countries.get(0).languages().toString());
		assertEquals("[nl, nf, de]", countries.get(1).languages().toString());
		assertEquals("ES", countries.get(4).name());
		assertEquals("[es]", countries.get(4).languages().toString());
	}

	@Test
	public void shouldBePopulatedByJson() {
		
	}
}
