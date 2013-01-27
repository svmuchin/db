package dbconnection;

import java.awt.FlowLayout;
import java.sql.SQLException;
import javax.swing.*;

/**
 *
 * @author Дмитрий
 */
public class DBConnection {

    private static JTextField dbedit;
    private static JButton but;
    private static JTable tabl;

    public static void main(String[] args) throws SQLException {

        JFrame f = new JFrame();
        JPanel panel = new JPanel();
        f.setBounds(100, 100, 500, 500);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dbedit = new JTextField("Введите строку текста");
        dbedit.setLocation(10, 10);
        dbedit.setSize(100, 20);
        panel.setLayout(null);
        panel.add(dbedit);
        but = new JButton("кнопка");
        but.setBounds(100, 100, 100, 25);
        tabl = new JTable(3, 2);
        tabl.setBounds(100, 150, 100, 100);
        tabl.setEnabled(false);
        panel.add(tabl);
        panel.add(but);
        f.setContentPane(panel);
        f.setVisible(true);



        try {
            new Conection().go("jdbc:firebirdsql:localhost/3050:db", "sysdba", "masterkey");
            System.out.println("true");
        } catch (Exception e) {
            System.exit(-1);
        }
    }
}
