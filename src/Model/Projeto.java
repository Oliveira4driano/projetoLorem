/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author dev
 */
public class Projeto {
    private static final long serialVersionUID = 1L;
    private long id;
    private String nome;
    private String dtinicio;
    private String dttermino;
    private String status;

    public Projeto(long id, String nome, String dtinicio, String dttermino, String status) {
        this.id = id;
        this.nome = nome;
        this.dtinicio = dtinicio;
        this.dttermino = dttermino;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDtinicio() {
        return dtinicio;
    }

    public void setDtinicio(String dtinicio) {
        this.dtinicio = dtinicio;
    }

    public String getDttermino() {
        return dttermino;
    }

    public void setDttermino(String dttermino) {
        this.dttermino = dttermino;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
    
}
