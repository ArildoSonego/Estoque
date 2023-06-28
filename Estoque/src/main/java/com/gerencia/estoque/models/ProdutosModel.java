package com.gerencia.estoque.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Produtos_TB")
public class ProdutosModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;

    @Column(nullable = false, unique = true, length = 40)
    private String descricao;

    @Column(nullable = false)
    private Integer saldo;

    public ProdutosModel() {
    }

    public ProdutosModel(Integer codigo, String descricao, Integer saldo) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.saldo = saldo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getSaldo() {
        return saldo;
    }

    public void setSaldo(Integer saldo) {
        this.saldo = saldo;
    }
}

