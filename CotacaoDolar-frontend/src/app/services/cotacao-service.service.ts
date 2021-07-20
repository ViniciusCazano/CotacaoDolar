import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { retry } from 'rxjs/operators';

import { CotacaoObj } from '../models/cotacao-obj';
import { ParametrosBuscaCotacao } from '../models/ParametrosBuscaCotacao';
import { RetornoBuscaCotacao } from '../models/RetornoBuscaCotacao';

@Injectable({
  providedIn: 'root'
})
export class CotacaoServiceService {
  urlBackend='http://localhost:8000/cotacao';
  constructor(private httpClient: HttpClient) { }

  httpOptions={
    headers: new HttpHeaders({'Content-Type': 'application/json'})
  }

  getCotacaoAtual(): Observable<CotacaoObj>{
    return this.httpClient.get<CotacaoObj>(this.urlBackend+"/instante")
      .pipe( retry(1) )
  }

  getBuscaCotacoes(parametrosBusca:ParametrosBuscaCotacao ): Observable<RetornoBuscaCotacao>{
    let parametros = new HttpParams();
    for (var [chave, valor] of Object.entries(parametrosBusca)) {
      if(valor!='') parametros = parametros.append(chave, valor);
    }

    return this.httpClient.get<RetornoBuscaCotacao>(this.urlBackend+"/listagem", {params: parametros})
      .pipe( retry(1) )
  }

  getPrimeiraCotacaoDia(): Observable<CotacaoObj>{
    return this.httpClient.get<CotacaoObj>(this.urlBackend+"/primeiraCotacaoDia")
      .pipe( retry(1) )
  }
}
