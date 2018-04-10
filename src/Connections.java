import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Connections {
    public static Connection connectTo(){
        try {
            Connection connectTo = DriverManager.getConnection("jdbc:sqlite:Hospital.db");
            return connectTo;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
