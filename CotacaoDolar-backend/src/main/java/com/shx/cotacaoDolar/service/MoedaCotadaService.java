package com.shx.cotacaoDolar.service;

import com.shx.cotacaoDolar.model.MoedaCotada;
import com.shx.cotacaoDolar.repository.MoedaCotadaRepository;
import com.shx.util.InformacoesGenericas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class MoedaCotadaService {
    @Autowired
    private MoedaCotadaRepository repository;

    public MoedaCotada cotacaoAtual(){
        return repository.getCotacaoAtual();
    }


    public Map<String, Object> listagemCotacao(
        Map<String, String> requestParams,
        int paginaAtual, int itemPorPagina
    ){
        Page<MoedaCotada> listaCotacao = null;
        Pageable paginacao = PageRequest.of(paginaAtual, itemPorPagina);

        Date dataDe;
        Date dataAte;
        try {
            if(requestParams.get("dataCotacaoDe")!=null && requestParams.get("dataCotacaoAte")!=null){
                    dataDe= InformacoesGenericas.formatoData.parse(requestParams.get("dataCotacaoDe")+" 00:00:00");
                    dataAte= InformacoesGenericas.formatoData.parse(requestParams.get("dataCotacaoAte")+" 23:59:59");
            }
            else{
                String dataAtual=InformacoesGenericas.formatoData.format(new Date()).split(" ")[0];

                dataDe = InformacoesGenericas.formatoData.parse( dataAtual+" 00:00:00" );
                dataAte = InformacoesGenericas.formatoData.parse( InformacoesGenericas.formatoData.format(new Date().getTime()-InformacoesGenericas.minutoEmMilis) );
            }
        }catch(ParseException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Falha no processamento da data do periodo");
        }

        listaCotacao=repository.findByDataCotacaoBetweenOrderByDataCotacaoDesc(dataDe, dataAte, paginacao);
        Map<String, Object> response = new HashMap<>();
        response.put("dados", listaCotacao.getContent());
        response.put("paginaAtual", listaCotacao.getNumber());
        response.put("totalItems", listaCotacao.getTotalElements());
        response.put("totalPaginas", listaCotacao.getTotalPages());

        return response;
    }
}
