package dbconnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.table.*;

public class CreateForm {

    private static JTextField dbedit;
    private static JButton but;
    private static JTable tabl;

    public void Create(ResultSet rs) throws SQLException {
        JFrame f = new JFrame();
        JPanel panel = new JPanel();
        f.setBounds(100, 100, 600, 600);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dbedit = new JTextField("Введите строку текста");
        dbedit.setLocation(10, 10);
        dbedit.setSize(100, 20);
        panel.setLayout(null);
        panel.add(dbedit);
        but = new JButton("кнопка");
        but.setBounds(120, 10, 100, 20);
        
        
        Vector namev = new Vector();
        Vector snamev = new Vector();

        DefaultTableModel Data = new DefaultTableModel();
        
        while (rs.next()) {
            namev.add(rs.getString("name"));
            snamev.add(rs.getString("SecondName"));
        }
        Data.addColumn("name", namev);
        Data.addColumn("SecondName", snamev);
        
        
        
        JTable tabl = new JTable(3, 2);
        tabl.setBounds(10, 35, 500, 200);
        tabl.setBorder(new BevelBorder(BevelBorder.LOWERED));
        tabl.setEnabled(false);
        panel.add(tabl);
        panel.add(but);
        f.setContentPane(panel);
        f.setVisible(true);
    }

   
}