package com.shx.cotacaoDolar.controller;

import com.shx.cotacaoDolar.model.MoedaCotada;
import com.shx.cotacaoDolar.service.MoedaCotadaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;

@RestController
@RequestMapping("/cotacao")
@CrossOrigin
public class MoedaCotadaController {
    @Autowired
    private MoedaCotadaService service;

    @GetMapping("/instante")
    public MoedaCotada valorAtual() throws Exception {
        MoedaCotada moedaCotada = service.cotacaoAtual();
        if (moedaCotada == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Sem dados cadastrados na base");
        return moedaCotada;
    }

    @GetMapping("/primeiraCotacaoDia")
    public MoedaCotada primeiraCotacaoDia() throws Exception {
        MoedaCotada moedaCotada = service.primeiraCotacaoDia();
        if (moedaCotada == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Sem dados cadastrados na base");
        return moedaCotada;
    }

    @GetMapping("/listagem")
    public Map<String, Object> listarCotacoes(
        @RequestParam Map<String, String> requestParams,
        @RequestParam(defaultValue = "0") int paginaAtual,
        @RequestParam(defaultValue = "10") int itemsPorPagina
    ) {
        Map<String, Object> cotacoes = service.listagemCotacao(requestParams, paginaAtual, itemsPorPagina);
        if (cotacoes == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Sem dados cadastrados na base");
        return cotacoes;
    }
}
