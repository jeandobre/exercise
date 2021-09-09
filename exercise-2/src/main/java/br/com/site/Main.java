package br.com.site;

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

		System.out.format("Number of the countries is %d\n", repository.total());

		Country country = repository.findMostLanguage("de");
		System.out.println("Country most official language where officially speaks 'de' is " + country.country());

		System.out.format("Count all official languages in all countries is %d\n", repository.totalLanguageOfAll());

	}
}
