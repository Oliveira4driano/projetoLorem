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
    private int risco;
    private Double valor;
    private String participante;
  
    public Projeto() {
    }

    public Projeto(long id, String nome, String dtinicio, String dttermino, int risco, Double valor, String participante) {
        this.id = id;
        this.nome = nome;
        this.dtinicio = dtinicio;
        this.dttermino = dttermino;
        this.risco = risco;
        this.valor = valor;
        this.participante = participante;
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

    public int getRisco() {
        return risco;
    }

    public void setRisco(int risco) {
        this.risco = risco;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getParticipante() {
        return participante;
    }

    public void setParticipante(String participante) {
        this.participante = participante;
    }
    
    

        
    
}
