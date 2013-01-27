package dbconnection;

import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 *
 * @author Дмитрий
 */
public class DBConnection {

    private static JTextField dbedit;

    public static void main(String[] args) throws SQLException {

        JFrame f = new JFrame();
        f.setSize(500, 500);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dbedit = new javax.swing.JTextField("Введите строку текста", 35);
        dbedit.setSize(10, 10);
        f.add(dbedit);
        f.setVisible(true);



        try {
            new Conection().go("jdbc:firebirdsql:localhost/3050:db", "sysdba", "masterkey");
            System.out.println("true");
        } catch (Exception e) {
            System.exit(-1);
        }
    }
}