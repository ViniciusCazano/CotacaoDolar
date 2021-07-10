import { Component, NgModule, OnInit } from '@angular/core';

@Component({
  selector: 'app-cotacao-listagem',
  templateUrl: './cotacao-listagem.component.html',
  styleUrls: ['./cotacao-listagem.component.css']
})

export class CotacaoListagemComponent implements OnInit {
  constructor() { }
  ngOnInit(): void {}

  parametrosBusca = {
    tipoListagem: 1,
    buscaDe: '',
    buscaAte: '',
    listarPorDia: ''
  };

  
}