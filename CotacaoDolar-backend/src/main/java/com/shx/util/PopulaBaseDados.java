package com.shx.util;

import com.shx.cotacaoDolar.model.MoedaCotada;
import com.shx.cotacaoDolar.repository.MoedaCotadaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
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


    public void salvarDadosBase() {
        try {
            MoedaCotada moedaCotada=new MoedaCotada(InformacoesGenericas.formatoData.parse("2021-07-01 08:59:00"), InformacoesGenericas.valorCotacaoRandom());
            int count=0;
            while(moedaCotada.getDataCotacao().getTime() < new Date().getTime()-InformacoesGenericas.minutoEmMilis){
                count++;
                moedaCotada.setDataCotacao( new Date(moedaCotada.getDataCotacao().getTime() + (InformacoesGenericas.minutoEmMilis)) );
                moedaCotada.setValorCotacao(InformacoesGenericas.valorCotacaoRandom());
                repository.save(moedaCotada);

                if(count==(9*60)) { //Avança a data para o proximo dia. A cada 9hrs de trabalho
                    moedaCotada.setDataCotacao( new Date(moedaCotada.getDataCotacao().getTime()+15*InformacoesGenericas.horaEmMilis) );//Adiciona 15hrs
                    count=0;
                }
            }
        }catch (Exception ex){
            System.out.println("Falha ao popular base de dados: "+ex);
        }
    }

    public void adicionaPorMinuto(){
        try{
            MoedaCotada moedaCotada=new MoedaCotada(new Date(), InformacoesGenericas.valorCotacaoRandom());
            repository.save(moedaCotada);
        }catch (Exception ex){
            System.out.println("Falha ao incluir atualização a base de dados: "+ex);
        }
    }

}
