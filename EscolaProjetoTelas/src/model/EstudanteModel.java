/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author es005962
 */
public class EstudanteModel {
    private int estCod;
    private String estnome;
    private String curso;
    private Date dataMat;
    private char status;

    public int getEstCod() {
        return estCod;
    }

    public void setEstCod(int estCod) {
        this.estCod = estCod;
    }

    public String getEstnome() {
        return estnome;
    }

    public void setEstnome(String estnome) {
        this.estnome = estnome;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public Date getDataMat() {
        return dataMat;
    }

    public void setDataMat(Date dataMat) {
        this.dataMat = dataMat;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }
}
