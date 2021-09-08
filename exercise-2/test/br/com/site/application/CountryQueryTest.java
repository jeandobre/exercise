package br.com.site.application;

import br.com.site.domain.Country;
import br.com.site.domain.CountryRepository;
import br.com.site.infra.TestCountryRepository;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CountryQueryTest {

	private final CountryRepository repository = new TestCountryRepository();
	private final  CountryQuery countryQuery = new CountryQuery(repository);

	@Before
	public void init() {
		repository.insert(new Country("US", "en"));
		repository.insert(new Country("BE", "nl", "nf", "de"));
		repository.insert(new Country("NL", "nl", "fy"));
		repository.insert(new Country("DE", "de"));
		repository.insert(new Country("ES", "es"));
	}

	@Test
	public void shouldBeFoundedWithSuccess() {

		Country countryEqual = new Country("BE");
		Country country = countryQuery.findCountryByLanguage("nf");

		assertEquals(countryEqual, country);
	}

	@Test
	public void shouldNotBeFounded() {

		Country country = countryQuery.findCountryByLanguage("br");
		assertNull(country);
	}

	@Test
	public void shouldBeCorrectTotalized(){

		assertEquals(Integer.valueOf(5), countryQuery.numberOfCountries());
	}

}
