package com.api.routes;

import com.api.service.PecasService;

import io.javalin.Javalin;

public class RotasPecas {
    public static void processarRotas(Javalin app){
        app.post("/addpecas", PecasService.cadastrarPecas);
        app.get("/pecasid", PecasService.consultarPecasId);
    }
}