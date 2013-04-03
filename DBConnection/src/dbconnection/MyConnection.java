package dbconnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MyConnection {

    Connection con;
    PreparedStatement select, insert,update;
    Statement stament;    
    public ResultSet RS;  
    public   ArrayList CollumName;

    public MyConnection(Connection connect){       
            con = connect;        
    }
            
    public static Connection getConection(String jdbcUrl, String login, String password) throws SQLException {
        try {
            Class.forName("org.firebirdsql.jdbc.FBDriver");
            final Properties prop = new Properties();
            prop.put("user", login);
            prop.put("password", password);
            prop.put("charSet", "Cp1251");
            prop.put("lc_ctype", "WIN1251");
            return DriverManager.getConnection(jdbcUrl, prop);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<ArrayList> GetData() throws SQLException {
        ArrayList element;
        ArrayList<ArrayList> Data = new ArrayList();
        try {            
            RS = GetSelectResultSet("select * from TEST");
            int columnCount = RS.getMetaData().getColumnCount();
            CollumName=new ArrayList();
            for (int i=0;i<RS.getMetaData().getColumnCount();i++){
             CollumName.add(RS.getMetaData().getColumnName(i+1).toString());
            }
               while (RS.next()) {
                element = new ArrayList();
                for (int i = 1; i <= columnCount; i++) {
                    element.add(RS.getObject(i));
                }
                Data.add(element);
            }           
        }
         catch (Exception e) {
            System.out.println(e.getStackTrace());
        }        
        return Data;
    }
    
    public ArrayList getColumName() throws SQLException
    {       
        return CollumName;//CollumName;
    }
    
    private ResultSet GetSelectResultSet(String query) throws SQLException
    {      
            return con.prepareStatement(query).executeQuery();
       
    }
}

