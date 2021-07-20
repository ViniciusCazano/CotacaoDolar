package com.shx.util;

import com.shx.cotacaoDolar.model.MoedaCotada;
import com.shx.util.model.CotacaoApiExterna;
import com.shx.util.model.ResponseApiExterna;
import com.shx.cotacaoDolar.repository.MoedaCotadaRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class  PopulaBaseDados {
    @Autowired
    private MoedaCotadaRepository autowiredRepository;
    @PostConstruct
    private void init() {
        repository = this.autowiredRepository;
    }

    private static MoedaCotadaRepository repository;
    private List<MoedaCotada> listaCotacaoSalvar = new ArrayList<MoedaCotada>();
    private RestTemplate restTemplate = new RestTemplate();

    public void salvarDadosBase() {
        SimpleDateFormat formatoDataParametrosApi = new SimpleDateFormat("MM-dd-yyyy");
        try {
            Date dataBusca=InformacoesGenericas.formatoData.parse("2021-06-01 00:00:00");

            while(dataBusca.getTime() <= new Date().getTime() ){
                ResponseApiExterna response = restTemplate.getForObject(
                        InformacoesGenericas.geraUrlBuscaApi( formatoDataParametrosApi.format(dataBusca) ), ResponseApiExterna.class
                );

                for(CotacaoApiExterna responseApi : response.getValue()){
                    repository.save(responseApi.transformaEmMoedaCotacao());
                }
                dataBusca=new Date( dataBusca.getTime()+(InformacoesGenericas.horaEmMilis*24) );
            }
            System.out.println("########################## BASE DE DADOS CARREGADA COM SUCESSO ##########################");
        }catch (Exception ex){
            System.out.println("Falha ao popular base de dados: "+ex);
        }
    }

    public void adicionaPorMinuto(){
        MoedaCotada moedaCotada = new MoedaCotada();
        String urlApi="https://economia.awesomeapi.com.br/last/USD-BRL";

        try{
            ResponseEntity<String> response = restTemplate.getForEntity(urlApi, String.class);
            JSONObject jsonObject = new JSONObject( response.getBody() );

            moedaCotada.setValorCotacao( jsonObject.getJSONObject("USDBRL").getDouble("bid") );
            moedaCotada.setDataCotacao( InformacoesGenericas.formatoData.parse(jsonObject.getJSONObject("USDBRL").getString("create_date")) );
            repository.save(moedaCotada);
        }catch (Exception ex){
            System.out.println("Falha ao incluir atualização a base de dados: "+ex);
        }
    }

}
