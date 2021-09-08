package br.com.site.application;

import br.com.site.domain.Country;
import br.com.site.domain.CountryRepository;
import br.com.site.infra.TestCountryRepository;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CountryQuery {

	private final CountryRepository repository = new TestCountryRepository();

	@Before
	public void init() {
		repository.insert(new Country("US", "en"));
		repository.insert(new Country("BE", "nl", "nf", "de"));
		repository.insert(new Country("NL", "nl", "fy"));
		repository.insert(new Country("DE", "de"));
		repository.insert(new Country("ES", "es"));
	}

	@Test
	public void shouldBeFoundedWithSuccess() throws Exception {
		String languageRequired = "nf";
		Country countryEqual = new Country("BE");
		Country country = repository.findByLanguage(languageRequired);

		assertEquals(countryEqual, country);
	}

	@Test
	public void shouldNotBeFounded() {
		String languageRequired = "br";
		try {
			repository.findByLanguage(languageRequired);
			fail("Should be fail: Country Not Found!");
		} catch (Exception e) {
			assertEquals( "Country Not Found!", e.getMessage());
		}
	}
}
