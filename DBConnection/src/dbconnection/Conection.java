package dbconnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import org.firebirdsql.jdbc.FBDriver;

public class Conection {

public Connection connectToBase(String jdbcUrl, String login, String password) throws SQLException {
    try {
      Class.forName("org.firebirdsql.jdbc.FBDriver");
    FBDriver.class.newInstance();
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
}