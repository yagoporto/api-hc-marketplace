package com.api.routes;

import io.javalin.http.Handler;
import io.javalin.http.Context;
import io.javalin.Javalin;

import com.api.service.UserService;


public class RotasUser {
    public static void processarRotas(Javalin app){
        app.post("/adduser", UserService.cadastrarUser);
        app.put("/updateuserid", UserService.altertarUserId);
        app.get("/consultarid", UserService.consultarUserId);
    }
}
