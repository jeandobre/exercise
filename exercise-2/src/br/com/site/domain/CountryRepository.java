package br.com.site.domain;

import java.util.List;

public interface CountryRepository {

	void insert(Country country);

	List<Country> getAll();

	Integer total();

	Country findMostLanguage(String language) throws Exception;
}
