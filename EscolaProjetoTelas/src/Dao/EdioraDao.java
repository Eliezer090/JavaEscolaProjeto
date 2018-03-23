/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Conexao.conection;
import Config.Editora;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.AutorModel;
import model.EditorModel;

/**
 *
 * @author es005962
 */
public class EdioraDao {

    Connection connection;

    public EdioraDao() {
        connection = conection.getConnection();
    }

    public void inserir(EditorModel ed) throws SQLException {
        String sql = "INSERT INTO EDITORA (NOME,MUNICIPIO) VALUES('" + ed.getNome() + "','" + ed.getMunicipio() + "')";
        PreparedStatement pst = connection.prepareStatement(sql);
        pst.execute();
    }

    public void editar(EditorModel ed) throws SQLException {
        String sql = "UPDATE EDITORA SET NOME = '" + ed.getNome() + "', MUNICIPIO = '" + ed.getMunicipio() + "' WHERE EDITORA_ID = " + ed.getCod();
        PreparedStatement pst = connection.prepareStatement(sql);
        pst.execute();
    }

    public void excluir(EditorModel ed) throws SQLException {
        String sql = " DELETE FROM EDITORA WHERE EDITORA_ID = " + ed.getCod();
        PreparedStatement pst = connection.prepareStatement(sql);
        pst.execute();
    }
    
        public List<EditorModel> findALL() {
        //Lisa para manter os valores do resultset
        List<EditorModel> list = new ArrayList<>();
        EditorModel objeto;
        String sql = "SELECT * FROM EDITORA";

        try {
            PreparedStatement p = connection.prepareStatement(sql);
            ResultSet r = p.executeQuery();
            while (r.next()) {
                objeto = new EditorModel();
                objeto.setCod(r.getInt("EDITORA_ID"));
                objeto.setNome(r.getString("NOME"));
                objeto.setMunicipio(r.getString("MUNICIPIO"));
                list.add(objeto);
            }
            r.close();
            p.close();
        } catch (Exception e) {
        }

        return list;
    }
}
