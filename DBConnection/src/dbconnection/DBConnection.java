/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dbconnection;

import java.sql.Connection;
import java.sql.SQLException;
import org.firebirdsql.jdbc.FBDriver;


/**
 *
 * @author Дмитрий
 */
public class DBConnection {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        try {
      new Conection().go("jdbc:firebirdsql:localhost/3050:db","sysdba","masterkey");
      System.out.println("true");
    } catch (Exception e) {
      e.printStackTrace();
      System.exit(-1);
    }
}
}


