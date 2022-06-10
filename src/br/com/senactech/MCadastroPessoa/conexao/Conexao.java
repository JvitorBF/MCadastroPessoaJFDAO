/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senactech.MCadastroPessoa.conexao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

/**
 *
 * @author João Vitor
 */
public class Conexao {

    // cria uma constante com endereço do BD e schema 
    private static String url = "jdbc:mysql://localhost:3306/devm211";
    // cria uma constante com USER de conexão do banco
    private static String user = "root";
    // cria uma constante com a senha de acesso ao BD
    private static String pass = "";

    public static Connection getConnection() throws SQLException {
        // Iniciar conexão nula, ainda não estabelecida 
        Connection c = null;
        // Tenta estabelecer conexão
        try {
            c = DriverManager.getConnection(url, user, pass);
            // Caso haja falha na conexão gera uma exceção
        } catch (Exception e) {
            throw new SQLException("Erro ao conectar! \n" + e.getMessage());
        }

        return c;
    }
}
