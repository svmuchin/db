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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Администратор
 */
public class CreateForm extends JFrame {

    MyConnection m;
    public Connection con;
    public TableModel model;
    JTextField Field, Field2;
    JLabel Label, Label2;
    public JButton but, but1, but2;
    public JTable table;
    public TM model1;
    public ArrayList<ArrayList> data;
    public ArrayList detaName;

    public CreateForm(Connection con, MyConnection m) throws SQLException {
        this.con = con;
        this.m = m;
    }

    public void createF() throws SQLException {
        data = m.getData();
        detaName = m.getColumName();
        model1 = new TM(data, detaName);
        model1.addTableModelListener(table);
        table = new JTable(model1);

        model1.addTableModelListener(table);
        JPanel panel = new JPanel(new BorderLayout());

        panel.setSize(500, 400);
        panel.add(new JScrollPane(table), BorderLayout.PAGE_START);
        JFrame frame = new JFrame("Database Table Model");
        but = new JButton("добавить");
        but1 = new JButton("очистить");
        but2 = new JButton("удалить");
        Field = new JTextField("");
        Field2 = new JTextField("");
        Label = new JLabel(table.getColumnName(0));
        Label2 = new JLabel(table.getColumnName(1));
        panel.add(new JScrollPane(but));
        ActionListener IntactionListener = new IntActionListener();
        ActionListener DelactionListener = new DelActionListener();
        but.addActionListener(IntactionListener);
        but1.addActionListener(DelactionListener);
        frame.setSize(500, 400);

        Box box = Box.createVerticalBox();
        Box Labelpanel = Box.createHorizontalBox();
        Box Textpanel = Box.createHorizontalBox();

        Textpanel.add(Field);
        Textpanel.add(Field2);

        Labelpanel.add(Label);
        Labelpanel.add(Label2);

        JToolBar toolBar = new JToolBar();
        box.add(new JScrollPane(table));

        toolBar.add(but);
        toolBar.add(but1);
        frame.setContentPane(box);
        frame.getContentPane().add(toolBar);
        frame.getContentPane().add(Labelpanel);
        frame.getContentPane().add(Textpanel);

        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
            }

            @Override
            public void windowClosing(WindowEvent e) {
                Object[] options = {"Да", "Нет!"};
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

    public class IntActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                new Select().sqlcod(con, "INSERT INTO TEST (ID, name, Secondname) VALUES ('" + table.getRowCount() + "','" + Field.getText() + "', '" + Field2.getText() + "')");
            } catch (SQLException ex) {
                Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    updateTable();
                } catch (SQLException ex) {
                    Logger.getLogger(CreateForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public void updateTable() throws SQLException {
        model1.setTableData(m.getData());
    }

    public class DelActionListener implements ActionListener {

        private Object someTable;

        @Override
        public void actionPerformed(ActionEvent e) {

            try {

                new Select().sqlcod(con, "Delete from TEST where Id='" + model1.getValueAt(table.getSelectedRow(), 2) + "'");
            } catch (SQLException ex) {
                Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    updateTable();
                } catch (SQLException ex) {
                    Logger.getLogger(CreateForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
