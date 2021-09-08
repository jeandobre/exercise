package br.com.site.application;

import br.com.site.domain.Country;
import br.com.site.domain.CountryRepository;
import br.com.site.infra.TestCountryRepository;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CountryQueryTest {

	private final CountryRepository repository = new TestCountryRepository();
	private final CountryQuery countryQuery = new CountryQuery(repository);

	@Before
	public void init() {
		this.repository.insert(new Country("US", "en"));
		this.repository.insert(new Country("BE", "nl", "nf", "de"));
		this.repository.insert(new Country("NL", "nl", "fy"));
		this.repository.insert(new Country("DE", "de"));
		this.repository.insert(new Country("ES", "es"));
	}

	@Test
	public void shouldBeFoundCountryByMostLanguageWithSuccess() {
		Country countryCorrect = new Country("BE");
		Country country = this.countryQuery.findCountryMostLanguage("nf");

		assertEquals(countryCorrect, country);
	}

	@Test
	public void shouldNotBeFounded() {
		Country country = this.countryQuery.findCountryMostLanguage("br");
		assertNull(country);
	}

	@Test
	public void shouldBeCountedCorrect(){
		Integer total = this.repository.total();
		assertEquals(total, this.countryQuery.numberOfCountries());
	}
}