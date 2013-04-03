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
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.addWindowListener(new WindowListener() {

            @Override
            public void windowOpened(WindowEvent e) {
                
            }

            @Override
            public void windowClosing(WindowEvent e) {
               Object[] options = { "Да", "Нет!" };
                int n = JOptionPane
                        .showOptionDialog(e.getWindow(), "Закрыть окно?",
                                "Подтверждение", JOptionPane.YES_NO_OPTION,
                                JOptionPane.QUESTION_MESSAGE, null, options,
                                options[0]);
                if (n == 0) {
                    e.getWindow().setVisible(false);
                    System.out.println("Window Closed");
                    try {
                        con.close();
                        System.out.println("con close");
                    } catch (SQLException ex) {
                        Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    System.exit(0);
                }
            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {
              
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
                
            }

            @Override
            public void windowActivated(WindowEvent e) {
               
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
                
            }
        });
        frame.setVisible(true);


    }
    public TableModel model;
    public JButton but;
    public JTable table;

    public class TestActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {

                new Select().insert(con, "INSERT INTO TEST (F, S) VALUES ('1', '1')");
            } catch (SQLException ex) {
                Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void main(String[] args) throws SQLException {
        try {
            new DBConnection().start();
        } catch (Exception e) {
            System.out.println(e);
        } 
                }
}
