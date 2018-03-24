/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Conexao.conection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.EstudanteModel;

/**
 *
 * @author es005962
 */
public class EstudanteDao {

    Connection connection;

    public EstudanteDao() {
        connection = conection.getConnection();
    }

    public void inserir(EstudanteModel est) throws SQLException {
        String sql = "INSERT INTO ESTUDANTE (NOME, CURSO, DATA_MATRICULA, STATUS) "
                + "VALUES ('" + est.getEstnome() + "','" + est.getCurso() + "', '" + est.getDataMat() + "', '" + est.getStatus() + "')";
        PreparedStatement p = connection.prepareStatement(sql);
        p.execute();
    }

    public void delear(EstudanteModel est) throws SQLException {
        String sql = " DELETE FROM ESUDANTE WHERE ESTUDANTE_ID=" + est.getEstCod();
        PreparedStatement p = connection.prepareStatement(sql);
        p.execute();
    }

    public void alterar(EstudanteModel est) throws SQLException {
        String sql = "UPDATE ESTUDANTE SET NOME = '" + est.getEstnome() + "', "
                + "CURSO = '" + est.getCurso() + "', DATA_MATRICULA =" + est.getDataMat() + ", STATUS = " + est.getStatus() + " WHERE ESTUDANTE_ID = " + est.getEstCod();
        PreparedStatement p = connection.prepareStatement(sql);
        p.execute();
    }
    
            public List<EstudanteModel> findALL() {
        //Lisa para manter os valores do resultset
        List<EstudanteModel> list = new ArrayList<>();
        EstudanteModel objeto;
        String sql = "SELECT * FROM ESTUDANTE ORDER BY ESTUDANTE_ID";

        try {
            PreparedStatement p = connection.prepareStatement(sql);
            ResultSet r = p.executeQuery();
            while (r.next()) {
                objeto = new EstudanteModel();
                objeto.setEstCod(r.getInt("ESTUDANTE_ID"));
                objeto.setEstnome(r.getString("NOME"));
                objeto.setCurso(r.getString("CURSO"));
                objeto.setStatus(r.getString("STATUS").charAt(0));
                objeto.setDataMat(r.getString("DATA_MATRICULA"));                
                list.add(objeto);
            }     
            r.close();
            p.close();
        } catch (Exception e) {
        }

        return list;
    }

}
