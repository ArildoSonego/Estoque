package com.gerencia.estoque.repositories;

import com.gerencia.estoque.models.ProdutosModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutosRepository extends JpaRepository <ProdutosModel,Integer>{
}
