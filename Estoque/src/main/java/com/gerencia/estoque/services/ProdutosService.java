package com.gerencia.estoque.services;

import com.gerencia.estoque.models.ProdutosModel;
import com.gerencia.estoque.repositories.ProdutosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProdutosService {
    @Autowired
    ProdutosRepository produtos;

    public List<ProdutosModel> buscaTodos() {
        return produtos.findAll();
    }

    public ProdutosModel buscaUm (Integer codigoProduto) {
        return produtos.findById(codigoProduto).get();
    }

    public boolean existeProduto (Integer codigoProduto) {return produtos.existsById(codigoProduto);}

    public void inclui (ProdutosModel produto) { produtos.save(produto); }

    public void altera (ProdutosModel produto) {
        produtos.save(produto);
    }

    public void exclui (Integer codigoProduto){
        produtos.deleteById(codigoProduto);
    }
}
