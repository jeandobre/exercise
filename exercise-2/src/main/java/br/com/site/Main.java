package br.com.site;

import br.com.site.domain.CountryRepository;
import br.com.site.domain.Item;
import br.com.site.infra.MemCountryRepository;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Main {

	private final CountryRepository repository = new MemCountryRepository();

	public static void main(String ...args) {

		String inputJson = "[{\"country\":\"US\",\"languages\":[\"en\"]}," +
				"{\"country\":\"BE\",\"languages\":[\"nl\",\"fr\",\"de\"]}," +
				"{\"country\":\"NL\",\"languages\":[\"nl\",\"fy\"]}," +
				"{\"country\":\"DE\",\"languages\":[\"de\"]}," +
				"{\"country\":\"ES\",\"languages\":[\"es\"]}]";

		Gson gson = new Gson();

		Type listType = new TypeToken<ArrayList<Item>>(){}.getType();
		List<Item> lista = gson.fromJson(inputJson, listType);
		System.out.println(lista);

	}
}
