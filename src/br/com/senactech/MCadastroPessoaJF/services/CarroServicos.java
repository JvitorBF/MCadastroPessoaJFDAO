/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senactech.MCadastroPessoaJF.services;

import br.com.senactech.MCadastroPessoaJF.DAO.CarroDAO;
import br.com.senactech.MCadastroPessoaJF.DAO.DAOFactory;
import br.com.senactech.MCadastroPessoaJF.model.Carro;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author jairb
 */
public class CarroServicos {

    public void cadCarro(Carro pVO) throws SQLException {
        CarroDAO cDAO = DAOFactory.getCarroDAO();
        cDAO.cadastrarCarro(pVO);
    }

    public ArrayList<Carro> getCarros() throws SQLException {
        CarroDAO cDAO = DAOFactory.getCarroDAO();
        return cDAO.buscarCarros();
    }

    public boolean verPlaca(String placa) throws SQLException {
        CarroDAO cDAO = DAOFactory.getCarroDAO();
        return cDAO.verPlaca(placa);
    }

    public Carro pesquisarPlacaBD(String placa) throws SQLException {
        CarroDAO cDAO = DAOFactory.getCarroDAO();
        return cDAO.getByDocBD(placa);
    }

    public void deletarCarroBD(int id) throws SQLException {
        CarroDAO cDAO = DAOFactory.getCarroDAO();
        cDAO.deletarCarro(id);
    }

    public void atualizarCarroBD(Carro pVO) throws SQLException {
        CarroDAO cDAO = DAOFactory.getCarroDAO();
        cDAO.atualizarCarro(pVO);
    }
        
}
