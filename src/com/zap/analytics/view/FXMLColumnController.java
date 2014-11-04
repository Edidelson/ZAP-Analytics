package com.zap.analytics.view;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.zap.analytics.model.Column;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;

/**
 *
 * @author Edidelson
 */
public class FXMLColumnController implements Initializable {

    private final ObservableList<Object> colunas = FXCollections.observableArrayList();

    @FXML
    private CheckBox cbPontoVirgula;
    @FXML
    private CheckBox cbPipe;
    @FXML
    private TextField tfOutro;
    @FXML
    private TextField tfNavegador;
    @FXML
    private Button btAdicionar;
    @FXML
    private Button btDelete;
    @FXML
    private Button btNavegador;
    @FXML
    private Button btOK;
    @FXML
    private Button btCancelar;
    @FXML
    private TableColumn colNome;
    @FXML
    private TableView tbColunas;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cellColums();
    }

    @FXML
    public void sair(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    public void adicionar(ActionEvent event) {
        Integer rows = tbColunas.getItems().size()+1;
        Column column = new Column();
        column.setNome("COLUMN_" + rows);
        tbColunas.getItems().add(column);
    }

    @FXML
    public void deletar(ActionEvent event) {
        int modelView = tbColunas.getSelectionModel().getSelectedIndex();
        tbColunas.getItems().remove(modelView);
    }

    @FXML
    public void readFile(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(null);
        tfNavegador.setText(file.getAbsolutePath()); 
    }

    @FXML
    public void carregar(ActionEvent event) {
        
    }

    public void cellColums() {
        colNome.setCellValueFactory(new PropertyValueFactory("nome"));
    }
   
}
