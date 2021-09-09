package br.com.site;

import br.com.site.application.Facade;
import br.com.site.domain.Country;
import br.com.site.domain.CountryRepository;
import br.com.site.infra.MemCountryRepository;

public class Main {

	public static void main(String ...args) {
		final CountryRepository repository = new MemCountryRepository();

		String inputJson = "[{\"country\":\"US\",\"languages\":[\"en\"]}," +
				"{\"country\":\"BE\",\"languages\":[\"nl\",\"fr\",\"de\"]}," +
				"{\"country\":\"NL\",\"languages\":[\"nl\",\"fy\"]}," +
				"{\"country\":\"DE\",\"languages\":[\"de\"]}," +
				"{\"country\":\"ES\",\"languages\":[\"es\"]}]";

		repository.insertFromJson(inputJson);

		Facade facade = new Facade(repository);

		System.out.format("Number of the countries is %d\n", facade.totalNumberCoutries());

		Country country = facade.findMostLanguage("de");
		System.out.println("Country most official language where officially speaks 'de' is " + country.country());

		System.out.format("Count all official languages in all countries is %d\n", facade.totalLanguageOfAll());

		Country countryHighestNumberLanguages = facade.findCountryHighestNumberLanguages();
		System.out.format("The country with the highest number of official language is %s with %d languages\n",
				countryHighestNumberLanguages.country(),
				countryHighestNumberLanguages.totalLanguages());

		System.out.println("The most common official language(s), of all coutries are " + facade.mostCommonLanguagesOfAllCountries());
	}
}
