
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * This class will connect the database to the program
 *
 */
public class Connect {

    private Connection conn;

    public Connect() {
        try {
            String database = "Database11.accdb";
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            conn = DriverManager.getConnection("jdbc:ucanaccess://" + database + ";");
            System.out.println("Connection successful");

        } catch (ClassNotFoundException | SQLException ex) {
            System.err.println("ERROR: " + ex);
        }
    }

    /**
     * This method allows you to read out(SELECT) the data from the database
     * tables.
     *
     * @param sql the SELECT you wish to perform
     * @return a ResultSet from the database
     */
    public ResultSet query(String sql) {
        ResultSet rs = null;
        try {
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
        } catch (SQLException ex) {
            System.err.println("ERROR: " + ex);
        }
        return rs;
    }

    /**
     * This method allows you to insert, update or delete the data in the
     * database tables
     *
     * @param sql the INSERT, UPDATE or DELETE you wish to perform
     * @return an int number of rows modified by the INSERT/UPDATE/DELETE or 0
     * for a SELECT (use query instead)
     */
    public int modify(String sql) {
        int result = 0;
        try {
            Statement stmt = conn.createStatement();
            result = stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            System.err.println("ERROR: " + ex);
        }
        return result;
    }

}
