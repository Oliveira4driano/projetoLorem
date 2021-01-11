/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Model.Participante;
import Model.Projeto;
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
public class ProjetoDAO {
    private LogErro err = new LogErro();
    private List<Projeto> projetos;
    
    public void inserir(Projeto projeto) throws BDException, ClassNotFoundException, SQLException{     
        Connection conexao = null;
        CallableStatement instrucao = null;
        try {
            conexao = ControlaConexao.getConexao();
            String query ="{call sp_inserirProjeto(?,?,?,?,?,?)}";
            instrucao = conexao.prepareCall(query);
            instrucao.setString(1, projeto.getNome());
            instrucao.setString(2, projeto.getDtinicio());
            instrucao.setString(3, projeto.getDttermino());
            instrucao.setInt(4, projeto.getRisco());
            instrucao.setDouble(5, projeto.getValor());
            instrucao.setString(6, projeto.getParticipante());
            
            instrucao.executeUpdate();
            //ControlaConexao.fecharInstrucao(instrucao);
            //conexao.close();
            JOptionPane.showMessageDialog(null, "Cadastrado "+projeto.getNome(), "AVISO", JOptionPane.INFORMATION_MESSAGE);
            
        } catch (SQLException error) {
            err.logErro(error);
            throw new BDException(error); 
        }
        finally{
            ControlaConexao.fecharInstrucao(instrucao);
            ControlaConexao.fecharConexao(conexao);
        }   
    }
    
    public List<Projeto> listar() throws BDException, ClassNotFoundException{
        Connection conexao = null;
        CallableStatement instrucao = null;    
       try {
           ResultSet resultados;
           
           projetos = new ArrayList<>();
           conexao = ControlaConexao.getConexao();
           String query = "{call sp_listarProjeto()}";
           instrucao = conexao.prepareCall(query);
           resultados = instrucao.executeQuery();
         
           while (resultados.next()) {
               Projeto projetoSaida = new Projeto();
               projetoSaida.setId(resultados.getInt("procodigo"));
               projetoSaida.setNome((resultados.getString("pronome")));
               projetoSaida.setDtinicio(resultados.getString("prodtinicio"));
               projetoSaida.setDttermino(resultados.getString("prodttermino"));
          
               

               projetos.add(projetoSaida);
           }
         
        } catch (SQLException error) {
             err.logErro(error);            
             throw new BDException(error);  
        }       
        finally{
           ControlaConexao.fecharInstrucao(instrucao);
           ControlaConexao.fecharConexao(conexao);
        }
        return projetos;
        
        
   }
    
     public List<Projeto> pesquisar(Projeto projeto)throws BDException, ClassNotFoundException{
       Connection conexao = null;
       CallableStatement instrucao = null;
     
       try {
           ResultSet resultados;          
           projetos = new ArrayList<>();
           conexao = ControlaConexao.getConexao();
           String query = "{call sp_pesquisarProjeto(?)}";
           instrucao = conexao.prepareCall(query);
           instrucao.setString(1,projeto.getNome());
           resultados = instrucao.executeQuery();
           
           
           while (resultados.next()) {
               Projeto  projetoSaida = new Projeto(); 
               projetoSaida.setId((resultados.getInt("procodigo")));
               projetoSaida.setNome(resultados.getString("pronome"));
               projetoSaida.setDtinicio(resultados.getString("prodtinicio"));
               projetoSaida.setDttermino(resultados.getString("prodttermino"));
              

               projetos.add(projetoSaida);
           }
           
        } catch (SQLException error) {
            err.logErro(error);   
            throw new BDException(error); 
      //  }
        }finally{
            ControlaConexao.fecharInstrucao(instrucao);
            ControlaConexao.fecharConexao(conexao);
        }  
       return projetos;
       
        
   }
     
   public List<Projeto> pesquisarAux(Projeto projeto)throws BDException, ClassNotFoundException{
       Connection conexao = null;
       CallableStatement instrucao = null;
     
       try {
           ResultSet resultados;          
           projetos = new ArrayList<>();
           conexao = ControlaConexao.getConexao();
           String query = "{call sp_pesquisarProjetoAux(?)}";
           instrucao = conexao.prepareCall(query);
           instrucao.setString(1,projeto.getNome());
           resultados = instrucao.executeQuery();
           
           
           while (resultados.next()) {
               Projeto  projetoSaida = new Projeto(); 
               
               projetoSaida.setId((resultados.getInt("procodigo")));
               projetoSaida.setNome(resultados.getString("pronome"));
               projetoSaida.setDtinicio(resultados.getString("prodtinicio"));
               projetoSaida.setDttermino(resultados.getString("prodttermino"));

               projetos.add(projetoSaida);
           }
           
        } catch (SQLException e) {
            err.logErro(e);          
            throw new BDException(e);   
         
        }finally{
            ControlaConexao.fecharInstrucao(instrucao);
            ControlaConexao.fecharConexao(conexao);
        }  
       return projetos;
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
    
    public void deletar(Projeto projeto) throws BDException, ClassNotFoundException{
       try {
           Connection conexao = ControlaConexao.getConexao();
           String query = "{call sp_excluirProjeto(?)}";
           CallableStatement instrucao = conexao.prepareCall(query);
           System.out.println("DAO.AlunoDAO.deletar()"+projeto.getId());
           instrucao.setInt(1, (int) projeto.getId());
           instrucao.execute();
        } catch (SQLException e) {
            err.logErro(e);   
            throw new BDException(e);  
        }    
   }
}
