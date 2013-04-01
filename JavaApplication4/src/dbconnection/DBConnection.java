package dbconnection;

import java.sql.SQLException;

public class DBConnection {

    public static void main(String[] args) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        Class.forName("org.firebirdsql.jdbc.FBDriver");
        try {
            new Conection().connectToBase("jdbc:firebirdsql:localhost/3050:db", "sysdba", "masterkey");
            System.out.println("true");
        } catch (Exception e) {
            System.exit(-1);
        }
    }
}