package com.api.model;

public class PecasModel {
    private int id;
    private String id_colection;
    private String nome;
    private String descricao;
    private String imagem;
    private String qtd_pecas;

    public PecasModel() {
    }

    public PecasModel(
            int id,
            String id_colection,
            String nome,
            String descricao,
            String imagem,
            String qtd_pecas
            ){
        this.id = id;
        this.id_colection = id_colection;
        this.nome = nome;
        this.descricao = descricao;
        this.imagem = imagem;
        this.qtd_pecas = qtd_pecas;
    }

    public PecasModel(
        String id_colection,
        String nome,
        String descricao,
        String imagem,
        String qtd_pecas
        ){
    this.id_colection = id_colection;
    this.nome = nome;
    this.descricao = descricao;
    this.imagem = imagem;
    this.qtd_pecas = qtd_pecas;
}

public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getId_colection() {
        return id_colection;
    }

    public void setId_colection(String id_colection) {
        this.id_colection = id_colection;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getQtd_pecas() {
        return qtd_pecas;
    }

    public void setQtd_pecas(String qtd_pecas) {
        this.qtd_pecas = qtd_pecas;
    }
}
