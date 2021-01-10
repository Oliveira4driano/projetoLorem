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
public class Participante {
    private static final long serialVersionUID = 1L;
    private long id;
    private String nome;
    private String funcao;

    public Participante() {
    }
    
    

    public Participante(long id, String nome, String funcao) {
        this.id = id;
        this.nome = nome;
        this.funcao = funcao;
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

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    
    
    
}
