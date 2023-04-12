package myClass;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


public class dbConnection {
    public static Connection con = null;
    public static Statement stm = null;
    
    public void connect(){//untuk membuka koneksi ke database
        try {
            String url ="jdbc:mysql://localhost/db_dpbo";
            String user="root";
            String pass="";
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url,user,pass);
            stm = con.createStatement();
            System.out.println("koneksi berhasil;");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("koneksi gagal" +e.getMessage());
        }
    }
    
    public ResultSet Query(String inputan){
        
        try{
            connect();
            String sql = inputan;
            return stm.executeQuery(sql);
            
        }catch(SQLException e){
            System.err.println("Read gagal " +e.getMessage());
        }
        return null;
    }
}
