package sql;


import getset.variaveis;
import java.sql.Connection;
import java.util.Date;
import javax.swing.JOptionPane;
import java.sql.ResultSet;

public class crudsql extends connSql {
   // connSql con= new connSql();
    java.sql.Statement st;
    ResultSet rs;
    variaveis var = new variaveis();
    
    public void insert(String NomeF, String Nome, Date Cad){ // inserts Restaurantes
        try{
          Connection conexion= conectar();
          st= conexion.createStatement();  
          String sql = "insert into cozinheiro(nome_fantasia, nome_cozinheiro, dt_contrato) values('"+NomeF+"','"+Nome+"','"+Cad+"');";
          st.execute(sql);
          st.close();
          conexion.close();
            JOptionPane.showMessageDialog(null,"O Registro foi salvo corretamente no banco de dados!", "Mensage", JOptionPane.INFORMATION_MESSAGE);
        }catch(Exception e){
          JOptionPane.showMessageDialog(null,"O Registro não foi salvo corretamente no banco de dados!", "Mensage", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    public void Mostrar (String nome){
        try {
          Connection conexion= conectar();
          st= conexion.createStatement();  
          String sql = "select * from cozinheiro where nome_cozinheiro = '"+nome+"'";
          rs = st.executeQuery(sql);
          
          if(rs.next()){
              var.setNomefantasia(rs.getString("nome_fantasia"));
              var.setNome(rs.getString("nome_cozinheiro"));
              var.setDatacad(rs.getDate("dt_contrato"));   
          }else{
              var.setNomefantasia("");
              var.setNome("");
              var.setDatacad(null);
          JOptionPane.showMessageDialog(null,"Não se encontra o arquivo", "Sem registro", JOptionPane.INFORMATION_MESSAGE);
          }
          st.close();
         
          conexion.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro na busca do registro", "Erro de Busca", JOptionPane.ERROR_MESSAGE);
        }
            
    }
    
    public void Atualizar(String nomefantasia, String nome, Date Cad){
        try {
            
          Connection conexion= conectar();
          st= conexion.createStatement();  
          String sql = "update cozinheiro set nome_fantasia = '"+nomefantasia+"',nome_cozinheiro='"+nome+"',dt_contrato='"+Cad+"'  where nome_cozinheiro='"+nome+"';";
         
          st.execute(sql);
          
          st.close();
         
          conexion.close();

            JOptionPane.showMessageDialog(null,"O Registro foi atualizado corretamente no banco de dados!", "Mensage", JOptionPane.INFORMATION_MESSAGE);
        }catch(Exception e){
          JOptionPane.showMessageDialog(null,"O Registro não foi atualizado corretamente no banco de dados!", "Mensage", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    public void Deletar(String Nome){
        try {
          
          Connection conexion= conectar();
          st= conexion.createStatement();  
          String sql = "delete from cozinheiro where nome_cozinheiro= '"+Nome+"';";
         
          st.execute(sql);
          
          st.close();
         
          conexion.close();

            JOptionPane.showMessageDialog(null,"O Registro foi excluido corretamente no banco de dados!", "Mensage", JOptionPane.INFORMATION_MESSAGE);
        }catch(Exception e){
          JOptionPane.showMessageDialog(null,"Erro !O Registro não foi excluido corretamente no banco de dados!", "Mensage", JOptionPane.ERROR_MESSAGE);
        }
        
        
    }
}
