package com.gerencia.estoque.services;

import com.gerencia.estoque.models.MovimentacaoModel;
import com.gerencia.estoque.repositories.MovimentacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovimentacaoService {

    @Autowired
    MovimentacaoRepository movimentacao;

    public MovimentacaoModel inclui (MovimentacaoModel movimentacaoNova) {
        return movimentacao.save(movimentacaoNova);
    }
}
