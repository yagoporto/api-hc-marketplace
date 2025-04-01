package com.api.dao;

import com.api.config.Conexao;
import com.api.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class DAOUser {
        public static Connection conexao = null;

        public static int adicionarUser(User user) throws Exception {
            conexao = Conexao.getConexao();
            //query de inserção
            String sql = "INSERT INTO users (user_name, password, email, celular, foto, data_cadastro) VALUES (?, ?, ?, ?, ?, ?)";

            try(PreparedStatement comando = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                comando.setString(1, user.getUser_name());
                comando.setString(2, user.getPassword());
                comando.setString(3, user.getEmail());
                comando.setString(4, user.getCelular());
                comando.setString(5, user.getFoto());
                comando.setDate(6, new java.sql.Date(user.getData_cadastro().getTime()));

                //enviar sql para o banco de dados
                comando.execute();

                try(ResultSet idGerado = comando.getGeneratedKeys()) {
                    if(idGerado.next())
                        return idGerado.getInt(1);
                }
            }
            //Gera exceção caso ocorra erro, e retorna mensagem de erro
            throw new SQLException("Erro ao inserir usuário");
        }

        public static int alterarUser(User user) throws Exception{
            //query para alteração
            String sql = "UPDATE user SET user_name = ?, password = ?, email = ?, celular = ?, foto = ?, data_cadastro = ? WHERE id = ?";
            try(PreparedStatement comando = conexao.prepareStatement(sql)){

                //substituir os ? pelos valores
                comando.setString(1, user.getUser_name());
                comando.setString(2, user.getPassword());
                comando.setString(3, user.getEmail());
                comando.setString(4, user.getCelular());
                comando.setString(5, user.getFoto());
                comando.setDate(3, new java.sql.Date(user.getData_cadastro().getTime()));

                //enviar sql para o banco de dados
                int linhasAfetadas = comando.executeUpdate();

                return linhasAfetadas;
            }
        }


}
