package com.gerencia.estoque.models;

import jakarta.persistence.*;
@Entity
@Table(name = "Clientes_TB")
public class ClientesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;

    @Column(nullable = false, unique = true, length = 40)
    private String nome;

    @Column(nullable = false, length = 30)
    private String cidade;

    @Column(nullable = false, length = 2)
    private String estado;

    @Column(length = 20)
    private String contato;

    public ClientesModel() {
    }

    public ClientesModel(Integer codigo, String nome, String cidade, String estado, String contato) {
        this.codigo = codigo;
        this.nome = nome;
        this.cidade = cidade;
        this.estado = estado;
        this.contato = contato;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
         return nome;
    }

    public void setNome(String nome) {
         this.nome = nome;
    }

    public String getCidade() {
         return cidade;
    }

    public void setCidade(String cidade) {
         this.cidade = cidade;
    }

    public String getEstado() {
         return estado;
    }

    public void setEstado(String estado) {
         this.estado = estado;
    }

    public String getContato() {
         return contato;
    }

    public void setContato(String contato) {
         this.contato = contato;
    }
}
