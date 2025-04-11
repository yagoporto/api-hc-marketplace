package com.api.service;

import java.sql.SQLException;
import java.util.List;

import com.api.dao.DAOPecas;
import com.api.dao.DAOUser;
import com.api.model.UserModel;
import com.api.model.PecasModel;


import io.javalin.http.Handler;

public class PecasService {
    
    public static Handler cadastrarPecas = (ctx) -> {
        //pega os dados do corpo da requisição
        String id_colection = ctx.formParam("id_colection");
        String nome = ctx.formParam("nome");
        String descricao = ctx.formParam("descricao");
        String imagem = ctx.formParam("imagem");
        String qtd_pecas = ctx.formParam("qtd_pecas");

        //criar objeto peca com os dados recebidos
        PecasModel peca = new PecasModel(id_colection, nome, descricao, imagem, qtd_pecas);

        try {
            int idGerado = DAOPecas.adicionarPecas(peca);

            ctx.status(201); // 201 criado
            ctx.json("{\"message\": \"Peca criado com o ID " + idGerado + " com sucesso. \"}");
        } catch (Exception e) {
            e.printStackTrace();
            ctx.status(500);
            ctx.json("{\"message\": \"Erro ao criar peca: " + e.getMessage() + "\"}");
        }
    };
}
