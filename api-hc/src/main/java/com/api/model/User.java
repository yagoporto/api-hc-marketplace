package com.api.model;

import java.util.Date;

public class User {
    private int id;
    private String user_name;
    private String password;
    private String email;
    private String celular;
    private String foto;
    private Date data_cadastro;


    public User() {}
    
    public User(
            int id, 
            String user_name, 
            String password, 
            String email, 
            String celular, 
            String foto, 
            Date data_cadastro
        ) {

        this.id = id;
        this.user_name = user_name;
        this.password = password;
        this.email = email;
        this.celular = celular;
        this.foto = foto;
        this.data_cadastro = data_cadastro;
        
    }

    public User(
            String user_name, 
            String password, 
            String email, 
            String celular, 
            String foto,
            Date data_cadastro
        ) {

        this.id = 0;
        this.user_name = user_name;
        this.password = password;
        this.email = email;
        this.celular = celular;
        this.foto = foto;
    }

    public int getId(){
        return id;
    }

    public int setId(){
        return id;
    }

    public String getUser_name(){
        return user_name;
    }

    public String setUser_name(){
        return user_name;
    }

    public String getPassword(){
        return password;
    }

    public String setPassword(){
        return password;
    }

    public String getEmail(){
        return email;
    }

    public String setEmail(){
        return email;
    }

    public String getCelular(){
        return celular;
    }

    public String setCelular(){
        return celular;
    }

    public String getFoto(){
        return foto;
    }

    public String setFoto(){
        return foto;
    }

    public Date getData_cadastro(){
        return data_cadastro;
    }

    public Date setData_cadastro(){
        return data_cadastro;
    }
    
}

