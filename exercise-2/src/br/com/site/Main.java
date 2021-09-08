package br.com.site;

import br.com.site.domain.CountryRepository;
import br.com.site.infra.MemCountryRepository;

public class Main {

	private final CountryRepository repository = new MemCountryRepository();

	public static void main(String ...args) {

	}
}
