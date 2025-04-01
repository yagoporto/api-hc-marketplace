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
        //Date data_cadastro = Date.valueOf(ctx.formParam("data_cadastro"));
        
        // Cria um objeto User com os dados recebidos
        User user = new User(user_name, password, email, celular, foto);

        try {
            int idGerado = DAOUser.adicionarUser(user);

            ctx.status(201); // 201 Criado
            ctx.json("{\"message\": \"Usuário criado com o ID " + idGerado + " com sucesso.\"}");
        } catch (Exception e) {
            e.printStackTrace();
            ctx.status(500);
            ctx.json("{\"message\": \"Erro ao criar usuário: " + e.getMessage() + "\"}");
        }
    };

    public static Handler altertarUserId = (ctx) -> {
        try{
            int id = Integer.parseInt(ctx.formParam("id"));
            String user_name = ctx.formParam("user_name");
            String password = ctx.formParam("password");
            String email = ctx.formParam("email");
            String celular = ctx.formParam("celular");
            String foto = ctx.formParam("foto");
            //Date data_cadastro = Date.valueOf(ctx.formParam("data_cadastro"));

            User user = new User(id,user_name, password, email, celular, foto);

            int linhasAfetadas = DAOUser.alterarUserId(user);

            if(linhasAfetadas > 0){
                ctx.status(200); // 200 OK
                ctx.json("{\"message\": \"Usuário com o ID " + id + " atualizado com sucesso.\"}");
            }else{
                ctx.status(404);
                ctx.json("{\"message\": \"O usuário com id " + id + " não foi encontrado.\"}");
            }
        }catch(NumberFormatException e){
            ctx.status(400);
            ctx.json("{\"message\": \"O ID do usuário deve ser um número.\"}");
        }catch(Exception e){
            e.printStackTrace();
            ctx.status(500);
            ctx.json("{\"message\": \"Erro ao atualizar usuário: " + e.getMessage() + "\"}");
        }
    };

    public static Handler altertarUserNome = (ctx) -> {
        try{
            String user_name = ctx.formParam("user_name");
            String password = ctx.formParam("password");
            String email = ctx.formParam("email");
            String celular = ctx.formParam("celular");
            String foto = ctx.formParam("foto");
            //Date data_cadastro = Date.valueOf(ctx.formParam("data_cadastro"));

            User user = new User(user_name, password, email, celular, foto);

            int linhasAfetadas = DAOUser.alterarUserId(user);

            if(linhasAfetadas > 0){
                ctx.status(200); // 200 OK
                ctx.json("{\"message\": \"Usuário com o nome " + user_name + " atualizado com sucesso.\"}");
            }else{
                ctx.status(404);
                ctx.json("{\"message\": \"O usuário com o nome " + user_name + " não foi encontrado.\"}");
            }
        }catch(NumberFormatException e){
            ctx.status(400);
            ctx.json("{\"message\": \"O ID do usuário deve ser um número.\"}");
        }catch(Exception e){
            e.printStackTrace();
            ctx.status(500);
            ctx.json("{\"message\": \"Erro ao atualizar usuário: " + e.getMessage() + "\"}");
        }
    };

    public static Handler consultarUserId = ctx -> {
        try {
            // Pega o ID enviado no formulário
            String idParam = ctx.formParam("id");
    
            if (idParam == null || idParam.isEmpty()) {
                ctx.status(400).json("{\"message\": \"ID não fornecido.\"}");
                return;
            }
    
            int id = Integer.parseInt(idParam);
            User user = DAOUser.consultarUserid(id); // Passar o ID diretamente
    
            ctx.status(200).json(user);
        } catch (NumberFormatException e) {
            ctx.status(400).json("{\"message\": \"ID inválido. Deve ser um número.\"}");
        } catch (Exception e) {
            ctx.status(404).json("{\"message\": \"Erro ao buscar usuário: " + e.getMessage() + "\"}");
        }
    };
}   
