/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author dev
 */
public class ParticipanteTabelaModelo extends AbstractTableModel{
    private List<Participante> participantes;
    private int qtdcoluna = 3;

    public ParticipanteTabelaModelo(List<Participante> participantes) {
        this.participantes = participantes;
    }
    
    

    @Override
    public int getRowCount() {
        return participantes.size();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getColumnCount() {
        return qtdcoluna;
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        Participante participante = participantes.get(linha);
        switch(coluna){
            case 0: return participante.getId();
            case 1: return participante.getNome();
            case 2: return participante.getFuncao();
            
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return null;
    }
     @Override
    public String getColumnName(int coluna){
        switch(coluna){
            case 0: return "cod";
            case 1: return "Nome";
            case 2: return "Funcao";
        
        }
        return null;
    }
    
}
