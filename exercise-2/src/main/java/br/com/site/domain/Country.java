package br.com.site.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Country {

	private final String country;

	private List<String> languages;

	public Country(String country) {
		this.country = country;
		this.languages = new ArrayList<>();
	}

	public Country(String country, List<String> languages) {
		this(country);
		this.languages = languages;
	}

	public Boolean contains(String language) {
		return this.languages.contains(language);
	}

	public String country() {
		return country;
	}

	public Integer totalLanguages() {
		return this.languages.size();
	}

	public List<String> languages() {
		return Collections.unmodifiableList(this.languages);
	}
}