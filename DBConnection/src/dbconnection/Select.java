/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dbconnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Администратор
 */
public class Select {

    public ResultSet rs;
    MyConnection m;
    CreateForm f;
    TM model1;
   

    public ResultSet rs(Connection con, String query) throws SQLException {
        rs = con.prepareStatement(query).executeQuery();
        return rs;

    }

    public void sqlcod(Connection con, String query) throws SQLException {
        try {
            Statement s = con.createStatement();
            s.executeUpdate(query);
            
        m = new MyConnection(con);
        f = new CreateForm(con, m);
      
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
