package br.com.site.infra;

import br.com.site.domain.Country;
import br.com.site.domain.CountryRepository;
import br.com.site.domain.Language;

import java.util.ArrayList;
import java.util.List;

public final class TestCountryRepository implements CountryRepository {

	private List<Country> list;

	public TestCountryRepository() {
		this.list = new ArrayList<>();
	}

	@Override
	public void insert(Country country) {
		this.list.add(country);
	}

	@Override
	public List<Country> getAll() {
		return null;
	}

	@Override
	public Integer total() {
		return this.list.size();
	}

	@Override
	public Country findByLanguage(String language) throws Exception {
		for(Country country: this.list){
			for(Language lang: country.languages()) {
				if(lang.ietfTag().equals(language)) return country;
			}
		}
		throw new Exception("Country Not Found!");
	}
}
