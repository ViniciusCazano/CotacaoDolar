package com.shx.cotacaoDolar.repository;

import com.shx.cotacaoDolar.model.MoedaCotada;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Pageable;

import java.util.Date;


@Repository
public interface MoedaCotadaRepository  extends JpaRepository<MoedaCotada, Date> {
    @Query( value=MoedaCotadaSqls.cotacaoAtualSql, nativeQuery = true )
    MoedaCotada getCotacaoAtual();

    Page<MoedaCotada> findByDataCotacaoBetweenOrderByDataCotacaoDesc(Date de, Date ate, Pageable pageable);
}
