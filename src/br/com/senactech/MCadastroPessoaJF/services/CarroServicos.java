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
        CarroDAO pDAO = DAOFactory.getCarroDAO();
        pDAO.cadastrarCarro(pVO);
    }

    public ArrayList<Carro> getCarros() throws SQLException {
        CarroDAO pDAO = DAOFactory.getCarroDAO();
        return pDAO.buscarCarros();
    }

    public boolean verPlaca(String placa) throws SQLException {
        CarroDAO pDAO = DAOFactory.getCarroDAO();
        return pDAO.verPlaca(placa);
    }

    public Carro pesquisarPlacaBD(String placa) throws SQLException {
        CarroDAO pDAO = DAOFactory.getCarroDAO();
        return pDAO.getByDocBD(placa);
    }

    public void deletarCarroBD(int id) throws SQLException {
        CarroDAO pDAO = DAOFactory.getCarroDAO();
        pDAO.deletarCarro(id);
    }

    public void atualizarCarroBD(Carro pVO) throws SQLException {
        CarroDAO pDAO = DAOFactory.getCarroDAO();
        pDAO.atualizarCarro(pVO);
    }    
}
