package dbconnection;

import java.sql.*;
import java.util.Properties;

public class Conection {

     Connection con;
     PreparedStatement create, select, insert;
    Statement qwe;
    ResultSet rs = null;

    

    public Connection getConection(String jdbcUrl, String login, String password) throws SQLException {
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

   /* public void Insert(Connection con) {
        try {
              System.out.println("2");
              con = getConection(jdbcUrl, login, password);
            insert = con.prepareStatement("INSERT INTO TEST (Name,SecondName) values('Name1','Name2')");
            insert.execute();
          
            System.out.println("1");
        } catch (SQLException ex) {
            Logger.getLogger(Conection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/

   /* public void go(String jdbcUrl, String login, String password) throws SQLException {
        con = Conection(jdbcUrl, login, password);

        create = con.prepareStatement("EXECUTE BLOCK AS BEGIN"
                + " if (not exists(select 1 from rdb$relations where rdb$relation_name = 'TEST')) then"
                + " execute statement 'create table TEST ( Name char (10),SecondName char (10))';"
                + " END");

        select = con.prepareStatement("SELECT * FROM TEST");


        con.setAutoCommit(false);
        try {
            rs = select.executeQuery();
            new CreateForm().Create(rs);
            create.execute();
            con.commit();
        } catch (Exception e) {
            con.rollback();
            throw new RuntimeException(e);
        } finally {
            con.close();
        }
    }*/
}
