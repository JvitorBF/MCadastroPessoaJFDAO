/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senactech.MCadastroPessoaJF.DAO;

/**
 *
 * @author João Vitor
 */

 /*
    SIGLAS
    • VO = Value Object - Objeto de valor
    • DAO = Data Access Object - Acesso aos dados do objeto
    • Factory = Fábrica     

    Dentro dessa classe DAO colocaremos todos os códigos de SQL DML(Data
    manipulation language), ou seja, vamos colocar os seguintes códigos:

    • insert

    • select

    • update

    • delete

   */

public class DAOFactory {

    private static PessoaDAO pessoaDAO = new PessoaDAO();

    public static PessoaDAO getPessoaDAO() {
        return pessoaDAO;
    }

}
