package com.api.service;

import java.sql.Date;
import java.util.List;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.api.dao.DAOUser;
import com.api.model.User;

import io.javalin.Javalin;
import io.javalin.http.Handler;
import io.javalin.http.Context;



public class UserService {
    public static Handler cadastrarUser = (ctx) -> {
        String user_name = ctx.formParam("user_name");
        String password = ctx.formParam("password");
        String email = ctx.formParam("email");
        String celular = ctx.formParam("celular");
        String foto = ctx.formParam("foto");
        Date data_cadastro = Date.valueOf(ctx.formParam("data_cadastro"));
        
        // Cria um objeto User com os dados recebidos
        User user = new User(user_name, password, email, celular, foto, data_cadastro);

        try {
            int idGerado = DAOUser.adicionarUser(user);

            ctx.status(201); // 201 Criado
            ctx.json("{\"message\": \"Usuário criado com o ID " + idGerado + " com sucesso.\"}");
        } catch (Exception e) {
            e.printStackTrace();
            ctx.status(500).json("{\"message\": \"Erro ao criar usuário: " + e.getMessage() + "\"}");
        }
    };
}   
