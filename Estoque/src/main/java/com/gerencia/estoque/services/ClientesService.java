package com.gerencia.estoque.services;

import com.gerencia.estoque.models.ClientesModel;
import com.gerencia.estoque.repositories.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClientesService {
    @Autowired
    ClientesRepository clientes;

    public List<ClientesModel> buscaTodos() {
        return clientes.findAll();
    }

    public ClientesModel buscaUm (Integer codigoCliente) {
        return clientes.findById(codigoCliente).get();
    }

    public boolean existeCliente (Integer codigoCliente) {return clientes.existsById(codigoCliente);}

    public void inclui (ClientesModel cliente) {
         clientes.save(cliente);
    }

    public void altera (ClientesModel cliente) {
         clientes.save(cliente);
    }

    public void exclui (Integer codigoCliente){
        clientes.deleteById(codigoCliente);
    }
}