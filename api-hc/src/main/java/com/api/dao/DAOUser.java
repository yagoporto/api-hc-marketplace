package com.api.dao;

import com.api.config.Conexao;
import com.api.model.UserModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;


public class DAOUser {
        public static Connection conexao = null;

        public static int adicionarUser(UserModel user) throws Exception {
            conexao = Conexao.getConexao();
            //query de inserção
            String sql = "INSERT INTO users (user_name, password, email, celular, foto) VALUES (?, ?, ?, ?, ?)";

            try(PreparedStatement comando = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                comando.setString(1, user.getUser_name());
                comando.setString(2, user.getPassword());
                comando.setString(3, user.getEmail());
                comando.setString(4, user.getCelular());
                comando.setString(5, user.getFoto());
                //comando.setDate(6, new java.sql.Date(user.getData_cadastro().getTime()));

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

        public static int alterarUserId(UserModel user) throws Exception{
            //query para alteração
            String sql = "UPDATE users SET user_name = ?, password = ?, email = ?, celular = ?, foto = ? WHERE id = ?";
            try(PreparedStatement comando = conexao.prepareStatement(sql)){

                //substituir os ? pelos valores
                comando.setString(1, user.getUser_name());
                comando.setString(2, user.getPassword());
                comando.setString(3, user.getEmail());
                comando.setString(4, user.getCelular());
                comando.setString(5, user.getFoto());
                comando.setInt(6, user.getId());

                //enviar sql para o banco de dados
                int linhasAfetadas = comando.executeUpdate();

                return linhasAfetadas;
            }
        }

        public static int alterarUserNome(UserModel user) throws Exception{
            //query para alteração
            String sql = "UPDATE users SET user_name = ?, password = ?, email = ?, celular = ?, foto = ? WHERE user_name = ?";
            try(PreparedStatement comando = conexao.prepareStatement(sql)){

                //substituir os ? pelos valores
                comando.setString(1, user.getUser_name());
                comando.setString(2, user.getPassword());
                comando.setString(3, user.getEmail());
                comando.setString(4, user.getCelular());
                comando.setString(5, user.getFoto());
                comando.setString(6, user.getUser_name());
            

                //enviar sql para o banco de dados
                int linhasAfetadas = comando.executeUpdate();

                return linhasAfetadas;
            }
        }

        public static UserModel consultarUserid(int id) throws Exception{
            String sql = "SELECT * FROM users WHERE id = ?";
            try(PreparedStatement comando = conexao.prepareStatement(sql)){


                //substitui o ? pelo valor
                comando.setInt(1, id);
                //Executar consulta
                try(ResultSet resultado = comando.executeQuery()){
                    if(resultado.next()){
                        return new UserModel(
                            resultado.getInt("id"),
                            resultado.getString("user_name"),
                            resultado.getString("password"),
                            resultado.getString("email"),
                            resultado.getString("celular"),
                            resultado.getString("foto"),
                            resultado.getDate("data_cadastro")
                        );

                    }else{
                        throw new SQLException("Usuário não encontrado");
                    }
                }
            }
        }

        public static List<UserModel> consultarTodosUsuarios() throws Exception{
            ArrayList<UserModel> lista = new ArrayList<UserModel>();
            String sql = "SELECT * FROM users";

            try(PreparedStatement comando = conexao.prepareStatement(sql)){
                try(ResultSet resultado = comando.executeQuery()){
                    while(resultado.next()){
                        UserModel listUser = new UserModel(
                            resultado.getInt("id"),
                            resultado.getString("user_name"),
                            resultado.getString("password"),
                            resultado.getString("email"),
                            resultado.getString("celular"),
                            resultado.getString("foto"),
                            resultado.getDate("data_cadastro")
                            );
                            lista.add(listUser);
                            
                    }
                    return lista;
                }   
            }
        }

        public static int deletarUserId(int id) throws Exception{
            String sql = "DELETE FROM users WHERE id = ?";
            try(PreparedStatement comando = conexao.prepareStatement(sql)){
                //substitui o ? pelo valor
                comando.setInt(1,id);

                //Executar consulta
                int linhasAfetadas = comando.executeUpdate();
                return linhasAfetadas;
            }
        }

        public static int deletarTodosUsers() throws Exception{
            String sql = "DELETE FROM users";
            try(PreparedStatement comando = conexao.prepareStatement(sql)){

                //Executar consulta
                int linhasAfetadas = comando.executeUpdate();
                return linhasAfetadas;
            }catch(Exception e){
                throw e;
            }
        }
}    
