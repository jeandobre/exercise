package br.com.site.application;

import br.com.site.domain.Country;
import br.com.site.domain.CountryRepository;

public class CountryQuery {

	private CountryRepository repository;

	public CountryQuery(CountryRepository repository) {
		this.repository = repository;
	}

	public Integer numberOfCountries() {
		return repository.total();
	}

	public Country findCountryByLanguage(String language) {
		try {
			return repository.findByLanguage(language);
		} catch (Exception e) {
			//e.printStackTrace(); //The correct is logging this error
			return null;
		}
	}
}
