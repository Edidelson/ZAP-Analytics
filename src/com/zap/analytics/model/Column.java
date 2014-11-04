/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zap.analytics.model;

import java.io.Serializable;

/**
 * com.zap.analytics.test
 * @author Edidelson
 */
public class Column implements Serializable{
    
    private String nome;

    public Column(String nome) {
        this.nome = nome;
    }

    public Column() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    

}
