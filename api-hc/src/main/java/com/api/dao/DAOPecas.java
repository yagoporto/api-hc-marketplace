package com.api.dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.api.config.Conexao;
import com.api.model.PecasModel;

public class DAOPecas {
    
    public static Connection conexao = null;

    public static int adicionarPecas(PecasModel pecas) throws Exception{

        conexao = Conexao.getConexao();
        //Query de inserção
        String sql = "INSERT INTO pecas (id_colection, nome, descricao, imagem, qtd_pecas) VALUES (?, ?, ?, ?, ?)";

        try(PreparedStatement comando = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            //substituir os ? pelos valores
            comando.setString(1, pecas.getId_colection());
            comando.setString(2, pecas.getNome());
            comando.setString(3, pecas.getDescricao());
            comando.setString(4, pecas.getImagem());
            comando.setString(5, pecas.getQtd_pecas());

            //enviar sql para o banco de dados
            comando.execute();

            try(ResultSet idGerado = comando.getGeneratedKeys()) {
                if(idGerado.next())
                return idGerado.getInt(1);
            }

            //Gera exceção caso ocorra erro, e retorna mensagem de erro
            throw new SQLException("Erro ao inserir usuário");
        }
    }

    public static PecasModel consultarPecasId(int id) throws Exception {
        conexao = Conexao.getConexao();

        String sql = "SELECT * FROM pecas WHERE id = ?";

        try(PreparedStatement comando = conexao.prepareStatement(sql)) {
            //substituir os ? pelos valores
            comando.setInt(1, id);

            //enviar sql para o banco de dados
            try(ResultSet resultado = comando.executeQuery()){
                if(resultado.next()){
                    return new PecasModel(
                        resultado.getInt("id"),
                        resultado.getString("id_colection"),
                        resultado.getString("nome"),
                        resultado.getString("descricao"),
                        resultado.getString("imagem"),
                        resultado.getString("qtd_pecas")
                    );
                }else{
                    throw new SQLException("Peca não encontrada");
                }
            }
        }

    }
}
