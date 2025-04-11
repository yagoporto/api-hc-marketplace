package com.api;

import io.javalin.Javalin;
import io.javalin.http.Handler;
import io.javalin.http.Context;
import io.javalin.http.HttpStatus;

import java.sql.Connection;

import com.api.routes.RotasPecas;
import com.api.routes.RotasUser;
import com.api.config.Conexao;
import com.api.dao.DAOUser;
import com.api.service.UserService;
public class Main {
    public static void main(String[] args) {
        try {
            //obtem uma conexão com o banco de dados
            Conexao.getConexao();

            DAOUser.conexao = Conexao.getConexao();

            //inicia o servidor na porta 7000
            Javalin app = Javalin.create().start(7000);

            //habilita o CORS para permitir requisições de outros domínios
            //Informando o Browser que é aceito os metodos HTTP OPTIONS, GET, POST, PUT, DELETE para qualquer endereço
            app.before("/*", ctx -> {
                String acessControlRequestHeaders = ctx.header("Access-Control-Allow-Origin");
                if(acessControlRequestHeaders != null){
                    ctx.header("Acess-coontrol-Allow-Origin", acessControlRequestHeaders);
                }

                String acessControlRequestMethod = ctx.header("Access-Control-Allow-Methods");
                if(acessControlRequestMethod != null){
                    ctx.header("Access-Control-Allow-Methods", acessControlRequestMethod);
                }
            
                ctx.result("ok");
            });

            RotasUser.processarRotas(app);
            RotasPecas.processarRotas(app);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}