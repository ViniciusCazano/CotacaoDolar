package com.shx.cotacaoDolar;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;

import com.shx.util.InformacoesGenericas;
import com.shx.util.PopulaBaseDados;
import lombok.SneakyThrows;


@SpringBootApplication(scanBasePackages={"com.shx.cotacaoDolar", "com.shx.util"})
public class CotacaoDolarBackendApplication {
	private static Runnable AdcCotacaoBaseDados = new Runnable() {
		@SneakyThrows
		public void run() {
			PopulaBaseDados populaBaseDados=new PopulaBaseDados();
			populaBaseDados.salvarDadosBase(); //Adiciona dados do dia 01/07 até data atual

			while(true){ //Adiciona por minuto
				populaBaseDados.adicionaPorMinuto();
				Thread.sleep(InformacoesGenericas.minutoEmMilis);
			}
		}
	};


	public static void main(String[] args) {
		SpringApplication.run(CotacaoDolarBackendApplication.class, args);

		new Thread(AdcCotacaoBaseDados).start();
	}
}
