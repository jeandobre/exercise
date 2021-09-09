package br.com.site.application;

import br.com.site.domain.Country;
import br.com.site.domain.CountryRepository;

import java.util.Comparator;
import java.util.List;

public class Facade {

	private final CountryRepository repository;
	private final List<Country> countries;

	public Facade(CountryRepository repository) {
		this.repository = repository;
		this.countries = this.repository.getAll();
	}

	public Country findCountryHighestNumberLanguages() {
		return countries
			.stream()
			.max(Comparator.comparing(Country::totalLanguages))
			.orElse(null);
	}

	public String mostCommonLanguagesOfAllCountries() {
		return countries
				.stream()
				.flatMap(country -> country.languages().stream())
				.max(Comparator.comparing(String::valueOf))
				.get();

	}
}
