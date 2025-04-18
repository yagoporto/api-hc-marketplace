package com.api.routes;


import io.javalin.Javalin;

import com.api.service.UserService;


public class RotasUser {
    public static void processarRotas(Javalin app){
        app.post("/adduser", UserService.cadastrarUser);
        app.put("/updateuserid", UserService.altertarUserId);
        app.get("/consultarid", UserService.consultarUserId);
        app.get("/consultartodos", UserService.consultarTodosUsuarios);
        app.delete("/deletaruserid", UserService.deletarUsuariosId);
        app.delete("/deletartodos", UserService.deletarTodosUsuarios);
    }
}
