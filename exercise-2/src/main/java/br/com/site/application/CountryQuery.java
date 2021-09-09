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

	public Country findCountryMostLanguage(String language) {
		try {
			return repository.findMostLanguage(language);
		} catch (Exception e) {
			//e.printStackTrace(); //The correct is logging this error
			return null;
		}
	}
}
