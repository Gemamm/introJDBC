
package mysql;


import java.sql.*;


public class TestMysql {
    
    public static void main(String[] args){
        String url = "jdcb:mysql://localhost:3306/test_java?useSSL=false"
                +"&useTimezone=true&serverTimezone=UTC&"
                +"allowPublicKeyRetrieval=true";
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexion = DriverManager.getConnection(url, "root","");
            Statement instruccion = conexion.createStatement();
            
            var sql = "SELECT idPersona, nombre, apellido, email, telefono"
                        + "FROM persona";
            
            ResultSet resultado = instruccion.executeQuery(sql);
            
            while(resultado.next()){
                System.out.println("Id. persona: " + resultado.getInt("idPersona"));
                System.out.println("Nombre: " + resultado.getString("nombre"));
                System.out.println("Apellido: " + resultado.getString("apellido"));
                System.out.println("Email: " + resultado.getString("email"));
                System.out.println("Telefono" + resultado.getString("itelefono"));
                
            }
            resultado.close();
            instruccion.close();
            conexion.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace(System.out);
        }
        
    }
    
}
