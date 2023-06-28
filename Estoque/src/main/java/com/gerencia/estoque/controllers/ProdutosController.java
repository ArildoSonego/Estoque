package com.gerencia.estoque.controllers;

import com.gerencia.estoque.dtos.ProdutosDto;
import com.gerencia.estoque.models.ProdutosModel;
import com.gerencia.estoque.services.ProdutosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.annotation.PatchExchange;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/produtos")
public class ProdutosController {

    @Autowired
    private ProdutosService servicoProdutos;

    @GetMapping
    public ResponseEntity<List<ProdutosModel>> buscaTodosProdutos() {
        return new ResponseEntity<>(servicoProdutos.buscaTodos(), HttpStatus.OK);
    }

    @GetMapping(value = "/{codigoProduto}")
    public ResponseEntity<Object> buscaUmProduto(@PathVariable Integer codigoProduto) {
        if (servicoProdutos.existeProduto(codigoProduto)) {
            return new ResponseEntity<>(servicoProdutos.buscaUm(codigoProduto), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Produto não encontrado", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Object> incluiProduto(@RequestBody ProdutosModel produto) {
        servicoProdutos.inclui(produto);
        return new ResponseEntity<>("Produto criado com sucesso", HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Object> alteraProduto(@RequestBody ProdutosModel produto) {
        if (servicoProdutos.existeProduto(produto.getCodigo())) {
            servicoProdutos.altera(produto);
            return new ResponseEntity<>("Produto alterado com sucesso", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Produto não encontrado", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "/{codigoProduto}")
    public ResponseEntity<Object> apagaProduto(@PathVariable Integer codigoProduto) {
        if (servicoProdutos.existeProduto(codigoProduto)) {
            servicoProdutos.exclui(codigoProduto);
            return new ResponseEntity<>("Produto excluído com sucesso", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Produto não encontrado", HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping
    public ResponseEntity<Object> atualizaSaldoProduto(@RequestBody ProdutosDto produto) {
        if (servicoProdutos.existeProduto(produto.codigo())) {
            var produtoSalva = servicoProdutos.buscaUm(produto.codigo());
            int saldoAtual = produtoSalva.getSaldo();
            if (produto.operacao() == 'E') {
                saldoAtual += produto.quantidade();
            } else if (produto.operacao() == 'S') {
                saldoAtual -= produto.quantidade();
            }
            produtoSalva.setSaldo(saldoAtual);
            servicoProdutos.altera(produtoSalva);
            return new ResponseEntity<>("Saldo atualizado com sucesso", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Produto não encontrado", HttpStatus.NOT_FOUND);
        }
    }
}