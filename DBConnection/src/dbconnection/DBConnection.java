package dbconnection;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.TableModel;

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
