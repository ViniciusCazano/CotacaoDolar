package com.shx.cotacaoDolar.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "COTACAO_DOLAR")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MoedaCotada {
    @Id
    @Column(name = "DATA_COTACAO", nullable = false)
    private Date dataCotacao;

    @Column(name = "VALOR_COTACAO", nullable = false)
    private Double valorCotacao;

    @Column(name = "COMPARACAO_REAL")
    private Double comparacaoReal;
}
