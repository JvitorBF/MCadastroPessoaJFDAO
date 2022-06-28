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
                    + pVO.getTelefone() + "'," + pVO.getIdade() + ","
                    + pVO.isStatus() + ")";
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

    public boolean verCPF(String cpf) throws SQLException {
        Connection con = Conexao.getConnection();
        Statement stat = con.createStatement();
        boolean verCPF = false;

        try {
            String sql;
            sql = "select cpf from pessoa where cpf = " + cpf;
            ResultSet rs = stat.executeQuery(sql);
            while (rs.next()) {
                verCPF = rs.wasNull();
            }
        } catch (SQLException e) {
            throw new SQLException("Pessoa com este CPF não existe. \n"
                    + e.getMessage());
        } finally {
            con.close();
            stat.close();
        }
        return verCPF;
    }

    public Pessoa getByDocBD(String cpf) throws SQLException {
        Connection con = Conexao.getConnection();
        Statement stat = con.createStatement();
        Pessoa p = new Pessoa();

        try {
            String sql;
            sql = "select * from pessoa where cpf = " + cpf;
            ResultSet rs = stat.executeQuery(sql);
            while (rs.next()) {
                // Lado do java |x| Lado do banco 
                p.setIdPessoa(rs.getInt("idPessoa"));
                p.setNomePessoa(rs.getString("nomePessoa"));
                p.setCpf(rs.getString("cpf"));
                p.setEndereco(rs.getString("endereco"));
                p.setTelefone(rs.getString("telefone"));
                p.setIdade(rs.getInt("idade"));
                p.setStatus(rs.getBoolean("status"));
            }
        } catch (SQLException e) {
            throw new SQLException("Pessoa com este CPF não existe. \n"
                    + e.getMessage());
        } finally {
            con.close();
            stat.close();
        }
        return p;
    }

    public void deletarPessoa(int id) throws SQLException {
        Connection con = Conexao.getConnection();
        Statement stat = con.createStatement();
        Pessoa p = new Pessoa();

        try {
            String sql;
            sql = "delete from pessoa where idPessoa = " + id;
            stat.execute(sql);
        } catch (SQLException e) {
            throw new SQLException("Pessoa com este CPF não existe. \n"
                    + e.getMessage());
        } finally {
            con.close();
            stat.close();
        }
    }

    public void atualizarPessoa(Pessoa pVO) throws SQLException {
        Connection con = Conexao.getConnection();
        Statement stat = con.createStatement();

        try {
            String sql;
            sql = "update pessoa set "
                    + "nomePessoa = '" + pVO.getNomePessoa() + "',"
                    + "endereco = '" + pVO.getEndereco() + "',"
                    + "idade = " + pVO.getIdade() + ","
                    + "telefone = '" + pVO.getTelefone() + "',"
                    + "status = " + pVO.isStatus() + " "
                    + "where idPessoa = " + pVO.getIdPessoa() + "";
            stat.executeUpdate(sql);
        } catch (SQLException e) {
            throw new SQLException("Erro ao atualizar Pessoa. \n"
                    + e.getMessage());
        } finally {
            con.close();
            stat.close();
        }
    }

    public String getNomePessoa(int id) throws SQLException {
        String nomePessoa = null;
        try {
            for (Pessoa pes : buscarPessoas()) {
                if (pes.getIdPessoa() == id) {
                    nomePessoa = pes.getNomePessoa();
                    break;
                }
            }
        } catch (SQLException e) {
            throw new SQLException("Pessoa com este id não existe. \n"
                    + e.getMessage());
        }
        return nomePessoa;
    }

    public String getCpfPessoa(int id) throws SQLException {
        String cpf = null;
        try {
            for (Pessoa pes : buscarPessoas()) {
                if (pes.getIdPessoa() == id) {
                    cpf = pes.getNomePessoa();
                    break;
                }
            }
        } catch (SQLException e) {
            throw new SQLException("Pessoa com este id não existe. \n"
                    + e.getMessage());
        }
        return cpf;
    }

    public int pesqIdPes(String cpf) throws SQLException {
        int id = 0;
        try {
            for (Pessoa pes : buscarPessoas()) {
                if (pes.getCpf().equals(cpf)) {
                    id = pes.getIdPessoa();
                    break;
                }
            }
        } catch (SQLException e) {
            throw new SQLException("Pessoa com este cpf não existe. \n"
                    + e.getMessage());
        }
        return id;
    }

}
