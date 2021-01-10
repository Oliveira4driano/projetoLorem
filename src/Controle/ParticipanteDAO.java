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
    
     public List<Participante> pesquisar(Participante participante)throws BDException, ClassNotFoundException{
       Connection conexao = null;
       CallableStatement instrucao = null;
     
       try {
           ResultSet resultados;          
           participantes = new ArrayList<>();
           conexao = ControlaConexao.getConexao();
           String query = "{call sp_pesquisarParticipante(?)}";
           instrucao = conexao.prepareCall(query);
           instrucao.setString(1,participante.getNome());
           resultados = instrucao.executeQuery();
           
           
           while (resultados.next()) {
               Participante  participanteSaida = new Participante(); 
               participanteSaida.setId((resultados.getInt("parcodigo")));
               participanteSaida.setNome(resultados.getString("parnome"));
               participanteSaida.setFuncao(resultados.getString("parfuncao"));
              

               participantes.add(participanteSaida);
           }
           
        } catch (SQLException error) {
            err.logErro(error);   
            throw new BDException(error); 
      //  }
        }finally{
            ControlaConexao.fecharInstrucao(instrucao);
            ControlaConexao.fecharConexao(conexao);
        }  
       return participantes;
       
        
   }
     
   public List<Participante> pesquisarAux(Participante participante)throws BDException, ClassNotFoundException{
       Connection conexao = null;
       CallableStatement instrucao = null;
     
       try {
           ResultSet resultados;          
           participantes = new ArrayList<>();
           conexao = ControlaConexao.getConexao();
           String query = "{call sp_pesquisarParticipanteAux(?)}";
           instrucao = conexao.prepareCall(query);
           instrucao.setString(1,participante.getNome());
           resultados = instrucao.executeQuery();
           
           
           while (resultados.next()) {
               Participante  participanteSaida = new Participante(); 
               
               participanteSaida.setId((resultados.getInt("parcodigo")));
               participanteSaida.setNome(resultados.getString("parnome"));
               participanteSaida.setFuncao(resultados.getString("parfuncao"));

               participantes.add(participanteSaida);
           }
           
        } catch (SQLException e) {
            err.logErro(e);          
            throw new BDException(e);   
         
        }finally{
            ControlaConexao.fecharInstrucao(instrucao);
            ControlaConexao.fecharConexao(conexao);
        }  
       return participantes;
    }  
    
    public void alterar(Participante participante) throws BDException, ClassNotFoundException{
         Connection conexao = null;
        CallableStatement instrucao = null;   
        try {
            conexao = ControlaConexao.getConexao();
            String query ="{call sp_alterarParticipante(?,?,?)}";
            instrucao = conexao.prepareCall(query);
            instrucao.setInt(1, (int) participante.getId());
            instrucao.setString(2, participante.getNome());
            instrucao.setString(3, participante.getFuncao());
               
            instrucao.execute();
           // conexao.close();
            
        } catch (SQLException e) {
            err.logErro(e);
                throw new BDException(e);  
        
        }finally{
           ControlaConexao.fecharInstrucao(instrucao);
           ControlaConexao.fecharConexao(conexao);
        }  
        }   
    
    public void deletar(Participante participante) throws BDException, ClassNotFoundException{
       try {
           Connection conexao = ControlaConexao.getConexao();
           String query = "{call sp_excluirParticipante(?)}";
           CallableStatement instrucao = conexao.prepareCall(query);
           System.out.println("DAO.AlunoDAO.deletar()"+participante.getId());
           instrucao.setInt(1, (int) participante.getId());
           instrucao.execute();
        } catch (SQLException e) {
            err.logErro(e);   
            throw new BDException(e);  
        }    
   }
}
