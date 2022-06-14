/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senactech.MCadastroPessoaJF.services;

import br.com.senactech.MCadastroPessoaJF.model.Pessoa;
import br.com.senactech.MCadastroPessoaJF.DAO.DAOFactory;
import br.com.senactech.MCadastroPessoaJF.DAO.PessoaDAO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author João Vitor
 */
public class PessoaServicos {

    public void cadPessoa(Pessoa pVO) throws SQLException {
        PessoaDAO pDAO = DAOFactory.getPessoaDAO();
        pDAO.cadastrarPessoa(pVO);
    }

    public ArrayList<Pessoa> getPessoas() throws SQLException {
        PessoaDAO pDAO = DAOFactory.getPessoaDAO();
        return pDAO.buscarPessoas();
    }

    public boolean verCPF(String cpf) throws SQLException {
        PessoaDAO pDAO = DAOFactory.getPessoaDAO();
        return pDAO.verCPF(cpf);
    }

    public Pessoa buscarPessoaBD(String cpf) throws SQLException {
        PessoaDAO pDAO = DAOFactory.getPessoaDAO();
        return pDAO.getByDocBD(cpf);
    }
    
    public void deletarPessoaBD(int id) throws SQLException {
        PessoaDAO pDAO = DAOFactory.getPessoaDAO();
        pDAO.deletarPessoa(id);
    }
}
