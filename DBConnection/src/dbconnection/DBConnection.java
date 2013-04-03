package dbconnection;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Дмитрий
 */
public class DBConnection {

    public static Connection con;
    MyConnection m;
    CreateForm create;

    public void start() throws SQLException {
        con = MyConnection.getConection("jdbc:firebirdsql:localhost:db", "sysdba", "masterkey");
        m = new MyConnection(con);
        create= new CreateForm(con,m);
        create.createF();
                }

    public static void main(String[] args) throws SQLException {
        try {
            new DBConnection().start();
        } catch (Exception e) {
            System.out.println(e);
        } 
                }
}
