package br.com.site.infra;

import br.com.site.domain.Country;
import br.com.site.domain.CountryRepository;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
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
	public void insertFromJson(String jsonStringify) {
		Gson gson = new Gson();

		Type listType = new TypeToken<ArrayList<Country>>(){}.getType();
		this.list = gson.fromJson(jsonStringify, listType);
	}

	@Override
	public List<Country> getAll() {
		return Collections.unmodifiableList(this.list);
	}

	@Override
	public Integer total() {
		return this.list.size();
	}
}
