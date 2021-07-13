import { CotacaoObj } from "./cotacao-obj";

export interface RetornoBuscaCotacao {
    dados: CotacaoObj[];
    paginaAtual: number;
    totalPaginas: number;
}

