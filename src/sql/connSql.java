
package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;



public class connSql {
    Connection conn = null;
    String url="jdbc:postgresql://localhost/Receitas";
    String usuario="postgres";       
    String clave="594678";
    
    public Connection conectar(){
        try{
            Class.forName("org.postgresql.Driver");
            conn= DriverManager.getConnection(url, usuario, clave);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao conectar ao banco de dados"+e,"Error",JOptionPane.ERROR_MESSAGE) ;
        }
        
    return conn;
    }
    
    
    
    
}
