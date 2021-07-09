package com.shx.util;

import com.shx.cotacaoDolar.model.MoedaCotada;
import com.shx.cotacaoDolar.repository.MoedaCotadaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class  PopulaBaseDados {
    @Autowired
    private MoedaCotadaRepository repository;
    private List<MoedaCotada> listaCotacaoSalvar = new ArrayList<MoedaCotada>(); ;

    public void salvarDadosBase() {
        try {
            MoedaCotada moedaCotada=new MoedaCotada(InformacoesGenericas.formatoData.parse("01/07/2021 08:59"), 5.35, 1.53);
            int count=0;
            while(moedaCotada.getDataCotacao().getTime() < new Date().getTime()){
                count++;

                if(count==(9*60)) {
                    moedaCotada.setDataCotacao(new Date(moedaCotada.getDataCotacao().getTime() + (15*60*60*1000) ));
                    count=0;
                }
                else moedaCotada.setDataCotacao(new Date(moedaCotada.getDataCotacao().getTime() + (60*1000) ));

                //System.out.println("SLA: "+moedaCotada.getDataCotacao().toString());
                repository.save(moedaCotada);
            }
        }catch (Exception ex){
            System.out.println("Erro ao popular dados: "+ex);
        }

    }
}
