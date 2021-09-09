package br.com.site.domain;

import java.util.List;

public interface CountryRepository {

	void insertFromJson(String jsonStringify);

	Integer total();

	Country findMostLanguage(String language);
}
