package dbconnection;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;


public class CreateForm {
    private static JTextField dbedit;
    private static JButton but;
    private static JTable tabl;
    private JTextField dbedit1;

    public class TeActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
             System.out.println("LF");
          new Conection().Insert("jdbc:firebirdsql:localhost:db", "sysdba", "masterkey");
        }
    }

    
     public DefaultTableModel TablVisual (ResultSet rs) throws SQLException{
   
        Vector namev = new Vector();
        Vector snamev = new Vector();

        DefaultTableModel Data = new DefaultTableModel();

        while (rs.next()) {
            namev.add(rs.getString("name"));
            snamev.add(rs.getString("SecondName"));
        }
        System.out.println(Data.getColumnName(0)+1);

        Data.addColumn("NAME", namev);
        Data.addColumn("SECONDNAME", snamev);

        JTable tabl = new JTable(2, 2);

        String[] columnNames = {"First Name",
            "Last Name"};
      
         
        return Data;
       
        }
    
    
    
    
    public void Create(ResultSet rs) throws SQLException {
        JFrame f = new JFrame();
        JPanel panel = new JPanel();
        f.setBounds(100, 100, 600, 600);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dbedit = new JTextField("Name");
        dbedit.setLocation(10, 10);
        dbedit.setSize(100, 20);
        dbedit1 = new JTextField("SecondName");
        dbedit1.setLocation(110, 10);
        dbedit1.setSize(100, 20);
        panel.setLayout(null);
        panel.add(dbedit);
        panel.add(dbedit1);
        ActionListener Acylist = new TeActionListener();
        but = new JButton("кнопка");
        but.setBounds(210, 10, 100, 20);
        but.addActionListener(Acylist);
        System.out.println("B");
         tabl.setModel(TablVisual(rs));
         System.out.println("c");
        tabl.setTableHeader(null);
        tabl.setBounds(10, 35, 500, 300);
        tabl.setBorder(new BevelBorder(BevelBorder.LOWERED));
        tabl.setEnabled(false);
       
        
        panel.add(tabl);
        panel.add(but);
        f.setContentPane(panel);
        f.setVisible(true);
    }
}
