package com.gerencia.estoque.repositories;

import com.gerencia.estoque.models.ClientesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientesRepository extends JpaRepository<ClientesModel,Integer> {
}
