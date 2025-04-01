package com.api.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private static final String URL = "jdbc:mysql://localhost:3306/heroclix";
    private static final String USUARIO = "root";
    private static final String SENHA = "123456";
    
    public static Connection getConexao() throws Exception {
        try{

            return DriverManager.getConnection(URL, USUARIO, SENHA);
        }catch(SQLException e){
            System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
            throw new Exception("Erro ao conectar ao banco de dados", e);
        }

    }
}
