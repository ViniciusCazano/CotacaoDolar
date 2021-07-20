import { Component, OnInit } from '@angular/core';
import { timer } from 'rxjs';

import { CotacaoObj } from 'src/app/models/cotacao-obj';
import { RetornoBuscaCotacao } from 'src/app/models/RetornoBuscaCotacao';
import { ParametrosBuscaCotacao } from 'src/app/models/ParametrosBuscaCotacao';
import { CotacaoServiceService } from 'src/app/services/cotacao-service.service';


@Component({
  selector: 'app-cotacao-listagem',
  templateUrl: './cotacao-listagem.component.html',
  styleUrls: ['./cotacao-listagem.component.css']
})
export class CotacaoListagemComponent implements OnInit {
  primeiraCotacaoDia={} as CotacaoObj;
  cotacaoAtual={} as CotacaoObj;
  dadosTabela=[] as CotacaoObj[];
  parametrosApi={} as ParametrosBuscaCotacao;

  tipoListagem= '1';
  dataMinBusca= "2021-07-01";
  dataMaxBusca= new Date().toISOString().split("T")[0];
  totalPaginas= 1;

  cabecalhoTabela=["Data-Hora", "Preço(R$)", "Diferença c/ atual(R$)", "Diferença c/ 1ªCotação"];
  paginacaoPosicoes= [1, 2, 3, 4, 5, 6];
  
  constructor(
    private cotacaoService: CotacaoServiceService
  ){}
  ngOnInit(): void {
    this.zerarParametros();
    this.atualizaPrimeiraCotacaoDia();
    timer(0, 1000*60).subscribe(() => {
      this.buscaCotacoes();
    });
  }

  atualizaPrimeiraCotacaoDia(){
    this.cotacaoService.getPrimeiraCotacaoDia()
      .subscribe((cotacaoObj: CotacaoObj)=>{
        this.primeiraCotacaoDia=cotacaoObj;
      });
  }
  atualizaCotacaoAtual(){
      this.cotacaoService.getCotacaoAtual()
        .subscribe((cotacaoObj: CotacaoObj)=>{
          this.cotacaoAtual=cotacaoObj;
        });
  }
  buscaCotacoes() {
    this.atualizaCotacaoAtual();
    this.cotacaoService.getBuscaCotacoes( this.parametrosApi )
      .subscribe((retornoApi: RetornoBuscaCotacao)=>{
        this.dadosTabela=retornoApi.dados;
        this.parametrosApi.paginaAtual=retornoApi.paginaAtual;
        this.totalPaginas=retornoApi.totalPaginas-1;
      });
  }

  mudarPaginaAtual(novaPagina:number){  
    let contador=-3;
    let posi=0;
    this.parametrosApi.paginaAtual=novaPagina;

    while( contador<3 ){
      let novaSequencia= this.parametrosApi.paginaAtual + contador;
      let valorMax= this.parametrosApi.paginaAtual + 3;
      let valorMin= this.parametrosApi.paginaAtual - 3;

      if( valorMin> 0 && valorMax<this.totalPaginas){ 
        this.paginacaoPosicoes[posi]=novaSequencia;
      }
      else if(valorMin<=1 ){
        this.paginacaoPosicoes=[1, 2, 3, 4, 5, 6];
        break;
      }
      else if(valorMax>=this.totalPaginas ){
        this.paginacaoPosicoes=[this.totalPaginas-6, this.totalPaginas-5, this.totalPaginas-4, this.totalPaginas-3, this.totalPaginas-2, this.totalPaginas-1];
        break;
      }
      contador++;
      posi++;
    }
    this.buscaCotacoes();
  }
  zerarParametros(){
    this.tipoListagem='1';
    this.parametrosApi.dataCotacaoDe='';
    this.parametrosApi.dataCotacaoAte='';
    
    this.parametrosApi.paginaAtual=0;
    this.parametrosApi.itemsPorPagina=10;
  }

}