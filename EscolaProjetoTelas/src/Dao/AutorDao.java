/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Conexao.conection;
import Config.Autor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.AutorModel;

/**
 *
 * @author es005962
 */
public class AutorDao {

    Connection connection;

    public AutorDao() throws Exception {
        connection = conection.getConnection();
    }

    public void insert(AutorModel autor) throws SQLException {
        String sql = "INSERT INTO AUTOR (NOME) VALUES ('" + autor.getNome() + "')";
        PreparedStatement p = connection.prepareStatement(sql);
        p.execute();
    }

    public void update(AutorModel autor) throws SQLException {
        String sql = "UPDATE AUTOR SET NOME = '" + autor.getNome() + "' WHERE AUTOR_ID = " + autor.getAutor_id();
        PreparedStatement p = connection.prepareStatement(sql);
        p.execute();
    }

    public void delete(AutorModel autor) throws SQLException {
       
            String sql = "DELETE FROM AUTOR WHERE AUTOR_ID = " + autor.getAutor_id();
            PreparedStatement p = connection.prepareStatement(sql);
            p.execute();        
    }

    public AutorModel findById(int id) {
        return new AutorModel();
    }

    public List<AutorModel> findALL() {
        //Lisa para manter os valores do resultset
        List<AutorModel> list = new ArrayList<>();
        AutorModel objeto;
        String sql = "SELECT * FROM AUTOR";

        try {
            PreparedStatement p = connection.prepareStatement(sql);
            ResultSet r = p.executeQuery();
            while (r.next()) {
                objeto = new AutorModel();
                objeto.setAutor_id(r.getInt("AUTOR_ID"));
                objeto.setNome(r.getString("NOME"));
                list.add(objeto);
            }
            r.close();
            p.close();
        } catch (Exception e) {
        }

        return list;
    }
}
