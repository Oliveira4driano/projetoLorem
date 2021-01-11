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
public class ProjetoTabelaModelo extends AbstractTableModel{
    private List<Projeto> projetos;
    private int qtdcoluna = 4;

    public ProjetoTabelaModelo(List<Projeto> projetos) {
        this.projetos = projetos;
    }
    
    

    @Override
    public int getRowCount() {
        return projetos.size();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getColumnCount() {
        return qtdcoluna;
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        Projeto projeto = projetos.get(linha);
        switch(coluna){
            case 0: return projeto.getId();
            case 1: return projeto.getNome();
            case 2: return projeto.getDtinicio();
            case 3: return projeto.getDttermino();
         
            
            
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return null;
    }
     @Override
    public String getColumnName(int coluna){
        switch(coluna){
            case 0: return "cod";
            case 1: return "projeto";
            case 2: return "Data início";
            case 3: return "Data termino";
        
        }
        return null;
    }
    
}
