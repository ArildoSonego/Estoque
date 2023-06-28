package com.gerencia.estoque.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Movimentacao_TB")
public class MovimentacaoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;

    @Column(nullable = false, length = 10)
    private String documento;

    @JsonFormat(pattern="yyyy-MM-dd")
    @Column(nullable = false)
    private LocalDate data;

    @Column(nullable = false)
    private char tipo;

    @Column(nullable = false)
    private Integer entidade;

    @Column(nullable = false)
    private Integer produto;

    @Column(nullable = false)
    private Integer quantidade;

    @Column(length = 60)
    private String observacao;

    public MovimentacaoModel() {
    }

    public MovimentacaoModel(Integer codigo, String documento, LocalDate data, char tipo, Integer entidade, Integer produto, Integer quantidade, String observacao) {
        this.codigo = codigo;
        this.documento = documento;
        this.data = data;
        this.tipo = tipo;
        this.entidade = entidade;
        this.produto = produto;
        this.quantidade = quantidade;
        this.observacao = observacao;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    public Integer getEntidade() {
        return entidade;
    }

    public void setEntidade(Integer entidade) {
        this.entidade = entidade;
    }

    public Integer getProduto() {
        return produto;
    }

    public void setProduto(Integer produto) {
        this.produto = produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
}


