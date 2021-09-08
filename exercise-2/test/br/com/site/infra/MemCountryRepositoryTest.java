package br.com.site.infra;

import br.com.site.domain.Country;
import br.com.site.domain.CountryRepository;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class MemCountryRepositoryTest {

	private final CountryRepository repository = new TestCountryRepository();

	@Before
	public void init() {
		this.repository.insert(new Country("US", "en"));
		this.repository.insert(new Country("BE", "nl", "nf", "de"));
		this.repository.insert(new Country("NL", "nl", "fy"));
		this.repository.insert(new Country("DE", "de"));
		this.repository.insert(new Country("ES", "es"));
	}

	@Test
	public void shouldBeFoundedWithSuccess() throws Exception {
		String languageRequired = "nf";
		Country countryEqual = new Country("BE");
		Country country = this.repository.findByLanguage(languageRequired);

		assertEquals(countryEqual, country);
	}

	@Test
	public void shouldNotBeFounded() {
		String languageRequired = "br";
		try {
			this.repository.findByLanguage(languageRequired);
			fail("Should be fail: Country Not Found!");
		} catch (Exception e) {
			assertEquals( "Country Not Found!", e.getMessage());
		}
	}

	@Test
	public void shouldBeCorrectCounted() {
		assertEquals(Integer.valueOf(5), this.repository.total());
	}
}
