package dbconnection;

import java.sql.*;
import java.util.Properties;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import org.firebirdsql.jdbc.FBDriver;

public class Conection {

    Connection con;
    PreparedStatement create, select;
    Statement qwe;
    ResultSet rs = null;
   

    private Connection connectToBase(String jdbcUrl, String login, String password) throws SQLException {
        try {
            Class.forName("org.firebirdsql.jdbc.FBDriver");
            final Properties prop = new Properties();
            prop.put("user", login);
            prop.put("password", password);
            prop.put("charSet", "Cp1251");
            prop.put("lc_ctype", "WIN1251");
            return DriverManager.getConnection(jdbcUrl, prop);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public void go(String jdbcUrl, String login, String password) throws SQLException {
        con = connectToBase(jdbcUrl, login, password);
        select = con.prepareStatement("SELECT * FROM TEST");
        create = con.prepareStatement("EXECUTE BLOCK AS BEGIN"
                + " if (not exists(select 1 from rdb$relations where rdb$relation_name = 'TEST')) then"
                + " execute statement 'create table TEST ( Name char (10),SecondName char (10))';"
                + " END");

        rs = select.executeQuery("SELECT * FROM TEST");
     new CreateForm().Create(rs);



        con.setAutoCommit(false);
        try {
            select.execute();
            create.execute();
            con.commit();
        } catch (Exception e) {
            con.rollback();
            throw new RuntimeException(e);
        } finally {
            con.close();
        }
    }
}