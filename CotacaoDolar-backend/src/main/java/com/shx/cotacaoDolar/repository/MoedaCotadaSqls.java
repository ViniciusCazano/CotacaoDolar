package com.shx.cotacaoDolar.repository;

public class MoedaCotadaSqls {
                //  Exibe a cotacao atual
    public static final String cotacaoAtualSql ="SELECT " +
        "   ctcUSD.DATA_COTACAO, " +
        "   ctcUSD.VALOR_COTACAO " +
        "FROM " +
        "   COTACAO_DOLAR ctcUSD " +
        "ORDER BY " +
        "   ctcUSD.DATA_COTACAO DESC " +
        "LIMIT 1;";

                //   Exibe primeira cotacao do dia
    public static final String primeiraCotacaoDiaSql ="SELECT " +
            "   ctcUSD.DATA_COTACAO, " +
            "   ctcUSD.VALOR_COTACAO " +
            "FROM " +
            "   COTACAO_DOLAR ctcUSD " +
            "WHERE " +
            "   ctcUSD.DATA_COTACAO>=:dataCotacao " +
            "ORDER BY " +
            "   ctcUSD.DATA_COTACAO ASC " +
            "LIMIT 1;";
}
