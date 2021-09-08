package br.com.site.application;

import br.com.site.domain.Country;
import br.com.site.domain.CountryRepository;

public class CountryQuery {

	private CountryRepository repository;

	public CountryQuery(CountryRepository repository) {
		this.repository = repository;
	}

	public Country findCountryByLanguage(String language) {
		try {
			return repository.findByLanguage(language);
		} catch (Exception e) {
			e.printStackTrace(); //Correct is log this error
			return null;
		}
	}
}
