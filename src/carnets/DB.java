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
                + " clase char NOT NULL,\n"
                + " emision TEXT NOT NULL,\n"
                + " expiracion TEXT NOT NULL,\n"
                + " observaciones TEXT NOT NULL,\n"
                + " tipoDocumento TEXT NOT NULL,\n"
                + " numeroDocumento TEXT NOT NULL,\n"
                + " FOREIGN KEY(tipoDocumento, numeroDocumento) REFERENCES titulares(tipoDocumento, numeroDocumento)"
                + ");";
            stmt.execute(sql);
            
            sql = "CREATE TABLE IF NOT EXISTS titulares (\n"
                + " tipoDocumento TEXT NOT NULL,\n"
                + " numeroDocumento TEXT NOT NULL,\n"
                + " apellidos TEXT NOT NULL,\n"
                + " nombres TEXT NOT NULL,\n"
                + " fechaNacimiento TEXT NOT NULL,\n"
                + " direccion TEXT NOT NULL,\n"
                + " grupoSanguineo TEXT NOT NULL,\n"
                + " factorSanguineo TEXT NOT NULL,\n"
                + " esDonante INTEGER NOT NULL,\n"
                + " PRIMARY KEY (tipoDocumento, numeroDocumento)\n"
                + ");";
            stmt.execute(sql);
            
            sql = "CREATE TABLE IF NOT EXISTS auditoria (\n"
                + " numero INTEGER PRIMARY KEY AUTOINCREMENT,\n"
                + " timestamp TEXT NOT NULL,\n"
                + " descripcion TEXT NOT NULL\n"
                + ");";
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}