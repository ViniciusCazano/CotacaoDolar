package com.shx.util;

import java.text.SimpleDateFormat;

public class InformacoesGenericas {
    public static final SimpleDateFormat formatoData = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static final int minutoEmMilis=60000;
    public static final int horaEmMilis=3600000;

    private static final  Double valorCotacaoMax=5.86;
    private static final  Double valorCotacaoMin=4.73;
    public static final Double valorCotacaoRandom(){
        return ( Math.random()*(valorCotacaoMax-valorCotacaoMin) ) + valorCotacaoMin;
    }
}
