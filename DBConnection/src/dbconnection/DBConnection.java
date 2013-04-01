package dbconnection;

import java.sql.SQLException;

/**
 *
 * @author Дмитрий
 */
public class DBConnection {

  

    public static void main(String[] args) throws SQLException {

        try {
            new Conection().go("jdbc:firebirdsql:localhost:db", "sysdba", "masterkey");
            System.out.println("true");
        } catch (Exception e) {
            System.exit(-1);
        }
    }
}
