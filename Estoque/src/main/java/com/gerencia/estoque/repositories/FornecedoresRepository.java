package com.gerencia.estoque.repositories;

import com.gerencia.estoque.models.FornecedoresModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FornecedoresRepository extends JpaRepository<FornecedoresModel,Integer> {
}
