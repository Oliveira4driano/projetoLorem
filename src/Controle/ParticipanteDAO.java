/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Model.Participante;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import util.BDException;
import util.ControlaConexao;
import util.LogErro;

/**
 *
 * @author dev
 */
public class ParticipanteDAO {
    private LogErro err = new LogErro();
    private List<Participante> participantes;
    
    public void inserir(Participante participante) throws BDException, ClassNotFoundException, SQLException{     
        Connection conexao = null;
        CallableStatement instrucao = null;
        try {
            conexao = ControlaConexao.getConexao();
            String query ="{call sp_inserirParticipante(?,?)}";
            instrucao = conexao.prepareCall(query);
            instrucao.setString(1, participante.getNome());
            instrucao.setString(2, participante.getFuncao());
            instrucao.executeUpdate();
            //ControlaConexao.fecharInstrucao(instrucao);
            //conexao.close();
            JOptionPane.showMessageDialog(null, "Cadastrado "+participante.getNome(), "AVISO", JOptionPane.INFORMATION_MESSAGE);
            
        } catch (SQLException error) {
            err.logErro(error);
            throw new BDException(error); 
        }
        finally{
            ControlaConexao.fecharInstrucao(instrucao);
            ControlaConexao.fecharConexao(conexao);
        }   
    }
    
    public List<Participante> listar() throws BDException, ClassNotFoundException{
        Connection conexao = null;
        CallableStatement instrucao = null;    
       try {
           ResultSet resultados;
           
           participantes = new ArrayList<>();
           conexao = ControlaConexao.getConexao();
           String query = "{call sp_listarParticipante()}";
           instrucao = conexao.prepareCall(query);
           resultados = instrucao.executeQuery();
         
           while (resultados.next()) {
               Participante  participanteSaida = new Participante();
               participanteSaida.setId(resultados.getInt("parcodigo"));
               participanteSaida.setNome((resultados.getString("parnome")));
               participanteSaida.setFuncao(resultados.getString("parfuncao"));
          
               

               participantes.add(participanteSaida);
           }
         
        } catch (SQLException error) {
             err.logErro(error);            
             throw new BDException(error);  
        }       
        finally{
           ControlaConexao.fecharInstrucao(instrucao);
           ControlaConexao.fecharConexao(conexao);
        }
        return participantes;
        
        
   }
    
}
