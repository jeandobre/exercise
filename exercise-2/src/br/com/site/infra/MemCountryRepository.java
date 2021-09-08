package br.com.site.infra;

import br.com.site.domain.Country;
import br.com.site.domain.CountryRepository;
import br.com.site.domain.Language;

import java.util.ArrayList;
import java.util.List;

/**
 * This class was created only for demonstrate the use of repository.
 * In the final project it should be changed by a target DB repository
 * e.g.: CountryMongoRepository or CountryRepositoryMySql
 *
 */
public final class MemCountryRepository implements CountryRepository {

	private List<Country> list;

	public MemCountryRepository() {
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
		return null;
	}

	@Override
	public Country findByLanguage(String language) {
		for(Country country: this.list){
			for(Language lang: country.languages()) {
				if(lang.ietfTag().equals(language)) return country;
			}
		}
		return null;
	}
}
