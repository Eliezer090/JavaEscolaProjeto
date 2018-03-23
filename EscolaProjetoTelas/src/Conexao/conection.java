/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author es005962
 */
public class conection {
    private static Connection connection = null;

    public static Connection getConnection()
    {
        if (connection == null)
        {
            try
            {
                Class.forName("org.firebirdsql.jdbc.FBDriver");
            } catch (ClassNotFoundException ex)
            {
                System.out.println(ex.getMessage());
            }

            String servidor = "192.168.21.130";
            String database = "C:\\Users\\PCESCOLA\\Documents\\db\\AULA02.FDB";
            String url = "jdbc:firebirdsql:" + servidor + "/3050:" + database + "?encoding=win1252";
            String usuario = "SYSDBA";
            String senha = "masterkey";

            try
            {
                connection = DriverManager.getConnection(url, usuario, senha);

            } catch (SQLException ex)
            {
                System.out.println("Não foi possível Conectar ao Banco de Dados: " + ex.getMessage());
            }
        }
        return connection;
    }
}
