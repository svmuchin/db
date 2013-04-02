/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dbconnection;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import javax.swing.*;
import javax.swing.table.TableModel;

/**
 *
 * @author Администратор
 */
public class DBH {
  /*  public  ResultSet sel;
    public  ArrayList element;
    public  ArrayList<ArrayList> result;

    public void connection throws SQLException {
        Connection con=null;
        int k = 1;
        result=new ArrayList();
                try {
                con=new 
                    //System.out.println("true");
                 sel=new Select().rs(con, "select * from TEST");
                 int columnCount = sel.getMetaData().getColumnCount();
                 while (sel.next())
                 {    
                     element = new ArrayList();
            for (int i=1; i<=columnCount; i++)
            {
                
               element.add(sel.getObject(i));
            }
                        
                     
                   // System.out.println(sel.getString("1")+' '+sel.getString("2"));
                   result.add(element);   
                   
                   
                 }
                 
                  model = new TM();
                table = new JTable(model);
                    model.addTableModelListener(table);
                JPanel panel = new JPanel(new BorderLayout());
                    panel.add(new JScrollPane(table), BorderLayout.CENTER);
         
                    JFrame frame = new JFrame("Database Table Model");
                    but = new JButton("кнопка");
                    but.setBounds(210, 10, 100, 20);
                    panel.add(new JScrollPane(but),BorderLayout.PAGE_END);
                    ActionListener actionListener = new TestActionListener();
                    but.addActionListener(actionListener);
                    frame.setLocationRelativeTo(null);
                    frame.setSize(500, 400);
                    frame.setContentPane(panel);
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setVisible(true);
                 
                 System.out.println();
                 System.out.println();
                } catch (Exception e) {
                   System.out.println(e);
                }
                finally {
                    con.close();
                }
    }
    public TableModel model;
    public  JButton but;
    public  JTable table;
    public class TestActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
             
        }
    }
    Array mas;
    Collection col;
    int i;
    */
}
