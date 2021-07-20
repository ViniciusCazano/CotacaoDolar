package com.shx.util.model;

import com.shx.cotacaoDolar.model.MoedaCotada;
import com.shx.util.InformacoesGenericas;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.text.ParseException;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class CotacaoApiExterna implements Serializable {
    private Double cotacaoCompra;
    private String dataHoraCotacao;
    private String tipoBoletim;

    public MoedaCotada transformaEmMoedaCotacao() throws ParseException {
        return new MoedaCotada(InformacoesGenericas.formatoData.parse(dataHoraCotacao), cotacaoCompra );
    }
}
