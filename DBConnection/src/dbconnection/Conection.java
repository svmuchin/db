package dbconnection;
import java.sql.*;
import java.util.Properties;
import org.firebirdsql.jdbc.FBDriver;

public class Conection {
    Connection con;
    PreparedStatement create;

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
public void go(String jdbcUrl, String login, String password)throws SQLException{
con = connectToBase(jdbcUrl,login,password);
create= con.prepareStatement("CREATE TABLE People "
        + "( Name    char (10), "
        + "SecondName   char (10), "
        + "city     char (10), "
        + "old   integer ); ");
con.setAutoCommit(false);
    try {
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