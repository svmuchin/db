package dbconnection;

import java.awt.FlowLayout;
import java.sql.SQLException;
import javax.swing.*;

/**
 *
 * @author Дмитрий
 */
public class DBConnection {

  

    public static void main(String[] args) throws SQLException {
//        new CreateForm().Create();
        try {
            new Conection().go("jdbc:firebirdsql:localhost/3050:db", "sysdba", "masterkey");
            System.out.println("true");
        } catch (Exception e) {
            System.exit(-1);
        }
    }
}
