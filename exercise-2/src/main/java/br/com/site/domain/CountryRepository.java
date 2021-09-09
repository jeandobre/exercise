package br.com.site.domain;

public interface CountryRepository {

	void insertFromJson(String jsonStringify);

	Integer total();

	Country findMostLanguage(String language);

	Integer totalLanguageOfAll();
}
