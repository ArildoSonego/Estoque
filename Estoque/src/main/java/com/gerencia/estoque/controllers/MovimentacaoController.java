package com.gerencia.estoque.controllers;

import com.gerencia.estoque.models.MovimentacaoModel;
import com.gerencia.estoque.services.MovimentacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/movimentacao")
public class MovimentacaoController {
    @Autowired
    private MovimentacaoService servicoMovimentacao;
    @PostMapping
    public ResponseEntity<MovimentacaoModel> incluiMovimentacao (@RequestBody MovimentacaoModel movimentacao){
        return new ResponseEntity<>(servicoMovimentacao.inclui(movimentacao), HttpStatus.CREATED);
    }
}
