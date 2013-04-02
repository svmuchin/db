package dbconnection;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

    public void start() throws SQLException {
        con = MyConnection.getConection("jdbc:firebirdsql:localhost:db", "sysdba", "masterkey");
        m = new MyConnection(con);
        model = new TM(m.getData(), m.getColumName());
        table = new JTable(model);
        model.addTableModelListener(table);
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JScrollPane(table), BorderLayout.CENTER);
        JFrame frame = new JFrame("Database Table Model");
        but = new JButton("кнопка");
        but.setBounds(210, 10, 100, 20);
        panel.add(new JScrollPane(but), BorderLayout.PAGE_END);
        ActionListener actionListener = new TestActionListener();
        but.addActionListener(actionListener);
        frame.setLocationRelativeTo(null);
        frame.setSize(500, 400);
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        System.out.println();
        System.out.println();

    }
    public TableModel model;
    public JButton but;
    public JTable table;

    public class TestActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {

                new Select().insert(con, "insert into TEST (NAME, SECONDNAME) values ('q','q')");
            } catch (SQLException ex) {
                Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    Array mas;
    Collection col;
    int i;

    public static void main(String[] args) throws SQLException {
        new DBConnection().start();

    }
}