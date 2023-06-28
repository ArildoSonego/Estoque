package com.gerencia.estoque.repositories;

import com.gerencia.estoque.models.MovimentacaoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovimentacaoRepository extends JpaRepository<MovimentacaoModel,Integer> {
}
