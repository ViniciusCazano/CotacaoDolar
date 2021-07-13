import { CotacaoObj } from "./cotacao-obj";

export interface ParametrosBuscaCotacao {
    dataCotacaoDe: String;
    dataCotacaoAte: String;

    paginaAtual: number;
    itemsPorPagina: 10;
}

