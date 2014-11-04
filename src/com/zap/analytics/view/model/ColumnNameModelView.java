/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zap.analytics.view.model;

import com.zap.analytics.model.Column;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Edidelson
 */
public class ColumnNameModelView {

    private final SimpleStringProperty nome;

    public ColumnNameModelView(Column column) {
        this.nome = new SimpleStringProperty(column.getNome());
    }

    public String getNome() {
        return nome.get();
    }

}
