package br.com.site.domain;

import br.com.site.common.Assertion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class Country extends Assertion {

	private String name;

	private List<Language> languages;

	public Country(String name, String ...languages) {
		this.setName(name);
		this.setLanguages(languages);
	}

	public String name() {
		return name;
	}

	public List<Language> languages() {
		return Collections.unmodifiableList(this.languages);
	}

	public void setName(String name) {
		this.assertArgumentNotNull(name, "The name of Country must not be null.");
		this.name = name;
	}

	public void setLanguages(String ...codesOfLanguages) {
		this.languages = new ArrayList<>(codesOfLanguages.length);
		for(String code: codesOfLanguages) {
			Language language = new Language(code);
			this.languages.add(language);
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Country country = (Country) o;
		return name.equals(country.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public String toString() {
		return "{" +
				" country:\"" + name + "\"," +
				" languages: [" + languages + "]\n" +
				'}';
	}
}
