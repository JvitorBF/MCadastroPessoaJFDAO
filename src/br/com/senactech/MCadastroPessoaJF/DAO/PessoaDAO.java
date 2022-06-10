/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senactech.MCadastroPessoaJF.DAO;

import br.com.senactech.MCadastroPessoaJF.conexao.Conexao;
import br.com.senactech.MCadastroPessoaJF.model.Pessoa;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author João Vitor
 */
public class PessoaDAO {

    public void cadastrarPessoa(Pessoa pVO) throws SQLException {
        //Busca conexãp com o BD 
        Connection con = Conexao.getConnection();
        //Cria um objeto stat responsável por enviar os comandos sql do java
        //para serem executados dentro do BD
        Statement stat = con.createStatement();
        try {
            //sql vai receber o comando sql
            String sql;
            sql = "Insert into pessoa values (null,'" + pVO.getNomePessoa() + "','"
                    + pVO.getCpf() + "','" + pVO.getEndereco() + "','"
                    + pVO.getTelefone() + "','" + pVO.getIdade() + "','"
                    + pVO.isStatus() + "')";
            // vamos executar o comando construido na string sql
            stat.execute(sql);
        } catch (SQLException e) {
            throw new SQLException("Erro ao inserir Pessoa!\n" + e.getMessage());
        } finally {
            stat.close();
            con.close();
        }
    }

    public ArrayList<Pessoa> buscarPessoas() throws SQLException {
        // Busca conexão com o BD
        Connection con = Conexao.getConnection();
        Statement stat = con.createStatement();
        try {
            String sql;
            sql = "Select * from pessoa";
            // Atribuo ao rs o resultado da exceução da query no banco
            ResultSet rs = stat.executeQuery(sql);
            ArrayList<Pessoa> pessoas = new ArrayList<>();
            while (rs.next()) {
                Pessoa p = new Pessoa();
                // Lado do java |x| Lado do banco 
                p.setIdPessoa(rs.getInt("idPessoa"));
                p.setNomePessoa(rs.getString("nomePessoa"));
                p.setCpf(rs.getString("cpf"));
                p.setEndereco(rs.getString("endereco"));
                p.setTelefone(rs.getString("telefone"));
                p.setIdade(rs.getInt("idade"));
                p.setStatus(rs.getBoolean("status"));
                pessoas.add(p);
            }
            return pessoas;
        } catch (SQLException e) {
            throw new SQLException("Erro ao buscar pessoas!\n" + e.getMessage());
        } finally {
            stat.close();
            con.close();
        }
    }
}
