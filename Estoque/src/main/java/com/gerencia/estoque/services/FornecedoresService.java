package com.gerencia.estoque.services;

import com.gerencia.estoque.models.FornecedoresModel;
import com.gerencia.estoque.repositories.FornecedoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FornecedoresService {
    @Autowired
    FornecedoresRepository fornecedores;

    public List<FornecedoresModel> buscatodos() {
        return fornecedores.findAll();
    }

    public FornecedoresModel buscaUm (Integer codigoFornecedor) {
         return fornecedores.findById(codigoFornecedor).get();
    }

    public boolean existeFornecedor (Integer codigoFornecedor) {return fornecedores.existsById(codigoFornecedor);}

    public void inclui (FornecedoresModel fornecedor) {fornecedores.save(fornecedor);}

    public void altera (FornecedoresModel fornecedor) { fornecedores.save(fornecedor); }

    public void exclui (Integer codigoFornecedor){
        fornecedores.deleteById(codigoFornecedor);
    }
}

