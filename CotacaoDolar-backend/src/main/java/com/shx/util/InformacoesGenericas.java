package com.shx.util;

import java.text.SimpleDateFormat;

public class InformacoesGenericas {
    public static final SimpleDateFormat formatoData = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static final int minutoEmMilis=60000;
    public static final int horaEmMilis=3600000;

    public static final String geraUrlBuscaApi(String dataBusca){
        return "https://olinda.bcb.gov.br/olinda/servico/PTAX/versao/v1/odata/CotacaoMoedaDia(moeda=@moeda,dataCotacao=@dataCotacao)?" +
                "@moeda='USD'&" +
                "@dataCotacao='"+dataBusca+"'&" +
                "$format=json&" +
                "$select=cotacaoCompra,dataHoraCotacao,tipoBoletim";
    }
}
