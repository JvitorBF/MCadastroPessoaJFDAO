/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senactech.MCadastroPessoaJF.controller;

/**
 *
 * @author jairb
 */
public class CCarro {

    public boolean verAnoMod(int anoFab, int anoMod) {
        boolean teste = false;
        if (anoMod == anoFab || anoMod == anoFab + 1) {
            teste = true;
        }
        return teste;
    }

}
