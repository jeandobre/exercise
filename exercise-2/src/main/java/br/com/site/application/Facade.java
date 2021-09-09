package br.com.site.application;

import br.com.site.domain.Country;
import br.com.site.domain.CountryRepository;

import java.util.Comparator;
import java.util.List;

public class Facade {

	private CountryRepository repository;

	public Facade(CountryRepository repository) {
		this.repository = repository;
	}

	public Country findCountryHighestNumberLanguages() {
		List<Country> countries = this.repository.getAll();
		return countries
			.stream()
			.max(Comparator.comparing(Country::totalLanguages))
			.orElse(null);
	}
}
