package com.api.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Conexao {
    private static final String URL = "jdbc:mysql://localhost:3306/api-hc";
    private static final String USUARIO = "root";
    private static final String SENHA = "123456";
    
    public static Connection getConexao() throws Exception {

            return DriverManager.getConnection(URL, USUARIO, SENHA);

    }
}
