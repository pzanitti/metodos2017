package carnets;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
 
public class DB {
    static Connection conn = null;
    
    public static Connection conectar() {
        if (conn == null) {
            String url = "jdbc:sqlite:carnets.db";
            try {
                Connection nuevaConn = DriverManager.getConnection(url);
                conn = nuevaConn;
            } catch (SQLException e) {
                System.out.println("wat");
                System.out.println(e.getMessage());
            }
        }
        
        return conn;
    }
    
    public static void init() {
        String sql;
        try {
            Connection conn = DB.conectar();
            Statement stmt = conn.createStatement();

            sql = "CREATE TABLE IF NOT EXISTS carnets (\n"
                + " numero integer PRIMARY KEY AUTOINCREMENT,\n"
                + " clase integer NOT NULL,\n"
                + " emision TEXT NOT NULL,\n"
                + " expiracion TEXT NOT NULL\n"
                + ");";
            stmt.execute(sql);
            
            sql = "CREATE TABLE IF NOT EXISTS auditoria (\n"
                + " timestamp string NOT NULL,\n"
                + " descripcion string NOT NULL\n"
                + ");";
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}