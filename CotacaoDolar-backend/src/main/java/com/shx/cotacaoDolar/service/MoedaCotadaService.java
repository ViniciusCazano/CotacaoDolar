package com.shx.cotacaoDolar.service;

import com.shx.cotacaoDolar.model.MoedaCotada;
import com.shx.cotacaoDolar.repository.MoedaCotadaRepository;
import com.shx.util.InformacoesGenericas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class MoedaCotadaService {
    @Autowired
    private MoedaCotadaRepository repository;

    public MoedaCotada cotacaoAtual(){
        return repository.getCotacaoAtual();
    }

    public List<MoedaCotada> listagemCotacao(Map<String, String> requestParams) {
        List<MoedaCotada> cotacoes = null;

        if(requestParams.get("dataCotacaoDe")!=null && requestParams.get("dataCotacaoAte")!=null){
            try {
                Date dataDe= InformacoesGenericas.formatoData.parse(requestParams.get("dataCotacaoDe"));
                Date dataAte=InformacoesGenericas.formatoData.parse(requestParams.get("dataCotacaoAte"));

                cotacoes=repository.findByDataCotacaoBetween(dataDe, dataAte);
            }catch(ParseException e){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Falha no processamento da data do periodo");
            }
        }else {
            cotacoes=repository.findAll();
        }

        return cotacoes;
    }
}
