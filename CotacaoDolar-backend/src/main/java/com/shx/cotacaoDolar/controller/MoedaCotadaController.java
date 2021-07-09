package com.shx.cotacaoDolar.controller;

import com.shx.cotacaoDolar.model.MoedaCotada;
import com.shx.cotacaoDolar.service.MoedaCotadaService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/cotacao")
public class MoedaCotadaController {
    @Autowired
    private MoedaCotadaService service;

    @GetMapping("/instante")
    public MoedaCotada valorAtual() throws Exception {
        MoedaCotada moedaCotada = service.cotacaoAtual();
        if (moedaCotada == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Sem dados cadastrados na base");
        return moedaCotada;
    }

    @GetMapping("/listagem")
    public List<MoedaCotada> listarCotacoes(@RequestParam Map<String, String> requestParams) {
        List<MoedaCotada> cotacoes = service.listagemCotacao(requestParams);
        if (cotacoes == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Sem dados cadastrados na base");
        return cotacoes;
    }
}
