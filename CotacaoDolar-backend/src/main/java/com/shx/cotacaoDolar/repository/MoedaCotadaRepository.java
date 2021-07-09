package com.shx.cotacaoDolar.repository;

import com.shx.cotacaoDolar.model.MoedaCotada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;


@Repository
public interface MoedaCotadaRepository  extends JpaRepository<MoedaCotada, Date> {
    @Query( value=MoedaCotadaSqls.cotacaoAtualSql, nativeQuery = true )
    MoedaCotada getCotacaoAtual();

    List<MoedaCotada> findByDataCotacaoBetween(Date de, Date ate);

    @Override
    List<MoedaCotada> findAll();

}
