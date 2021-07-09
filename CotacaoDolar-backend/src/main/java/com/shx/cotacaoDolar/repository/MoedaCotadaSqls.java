package com.shx.cotacaoDolar.repository;

public class MoedaCotadaSqls {
                //  Exibe a cotacao atual
    public static final String cotacaoAtualSql ="SELECT " +
        "   ctcUSD.DATA_COTACAO, " +
        "   ctcUSD.VALOR_COTACAO, " +
        "   ctcUSD.COMPARACAO_REAL " +
        "FROM " +
        "   COTACAO_DOLAR ctcUSD " +
        "ORDER BY " +
        "   ctcUSD.DATA_COTACAO DESC " +
        "LIMIT 1;";

}
