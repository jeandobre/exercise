package com.example.vuethymeleaf;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.vault.core.VaultKeyValueOperationsSupport.KeyValueBackend;
import org.springframework.vault.core.VaultTemplate;
import org.springframework.vault.support.VaultResponse;

@SpringBootApplication
public class VueThymeleafApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(VueThymeleafApplication.class, args);
	}
/*
	@Autowired
	private VaultTemplate vaultTemplate;
	
	@PostConstruct
	public void apos() {
		VaultResponse response = vaultTemplate.opsForKeyValue("secret", KeyValueBackend.KV_2).get("vue-thymeleaf");
		System.out.println(response.getData().get("password"));
	}
	*/
}
