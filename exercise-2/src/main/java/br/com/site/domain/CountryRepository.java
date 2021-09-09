package br.com.site.domain;

import java.util.List;

public interface CountryRepository {

	void insertFromJson(String jsonStringify);

	List<Country> getAll();

	Integer total();

	Country findMostLanguage(String language);

	Integer totalLanguageOfAll();
}
