package com.shx.util;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

public class InformacoesGenericas {
    public static final SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy HH:mm");

    public static final int minutoEmMilis=60000;
    public static final int horaEmMilis=3600000;

    private static final  Double valorCotacaoMax=5.86;
    private static final  Double valorCotacaoMin=4.73;
    public static final Double valorCotacaoRandom(){
        return ( Math.random()*(valorCotacaoMax-valorCotacaoMin) ) + valorCotacaoMin;
    }
}
