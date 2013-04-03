/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dbconnection;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.event.EventListenerList;
import javax.swing.event.TableModelEvent;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author Администратор
 */
public class CreateForm {
     MyConnection m;
    public Connection con;
    public TableModel model;
    public JButton but;
    public JTable table;
    public TM model1;
    public ArrayList<ArrayList> data;
    public ArrayList detaName;
    public  CreateForm(Connection con,MyConnection m) throws SQLException{
        this.con=con;
        this.m=m;
    }
    public void createF() throws SQLException{
        data=m.getData();
        detaName=m.getColumName();
        model1 = new TM(data, detaName);
        model1.addTableModelListener(table);
        table = new JTable(model1);
        model1.addTableModelListener(table);
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
        
    }
    
