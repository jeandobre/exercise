package br.com.site.domain;

import java.util.List;

public class Item {

	private String country;

	private List<String> languages;

	public Item(String country, List<String> languages) {
		this.country = country;
		this.languages = languages;
	}

	public String country() {
		return country;
	}

	public List<String> languages() {
		return languages;
	}
}