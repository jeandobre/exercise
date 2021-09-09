package br.com.site.application;

import br.com.site.domain.Country;
import br.com.site.domain.CountryRepository;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Facade {

	private final CountryRepository repository;
	private final List<Country> countries;

	public Facade(CountryRepository repository) {
		this.repository = repository;
		this.countries = this.repository.getAll();
	}

	public Integer totalNumberCoutries() {
		return repository.total();
	}

	public Country findCountryHighestNumberLanguages() {
		return this.countries
			.stream()
			.max(Comparator.comparing(Country::totalLanguages))
			.orElse(null);
	}

	public String mostCommonLanguagesOfAllCountries() {
		return this.countries
				.stream()
				.flatMap(country -> country.languages().stream())
				.max(Comparator.comparing(String::valueOf))
				.get();

	}

	public Integer totalLanguageOfAll() {
		return this.countries
				.stream()
				.reduce(0, (partial, country) -> partial + country.totalLanguages(), Integer::sum);
	}

	public Country findMostLanguage(String language) {
		int max = 0;
		Country found = null;
		for(Country country: this.countries) {
			if(country.contains(language) && country.totalLanguages() > max) {
				max = country.totalLanguages();
				found = country;
			}
		}

		return found;
	}
}
