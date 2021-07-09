package com.shx.cotacaoDolar;

import com.shx.util.PopulaBaseDados;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages={"com.shx.cotacaoDolar", "com.shx.util"})
public class CotacaoDolarBackendApplication {
	public static void main(String[] args) {
		SpringApplication.run(CotacaoDolarBackendApplication.class, args);
	}
}
